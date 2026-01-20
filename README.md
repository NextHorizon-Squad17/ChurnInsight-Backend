# ChurnInsight Backend API
API REST responsável por receber dados de clientes e retornar uma previsão de churn (cancelamento), baseada em um modelo preditivo de Data Science.

Este projeto faz parte do MVP do ChurnInsight, desenvolvido durante um hackathon educacional.

# 📌 Objetivo

* Disponibilizar um endpoint HTTP que:
  * Receba dados de um cliente via JSON;
  * Valide as informações recebidas;
  * Retorne uma previsão de churn (Vai cancelar ou Vai continuar);
  * Inclua a probabilidade associada à previsão.

# ⚠️ Neste estágio, a previsão é mockada.
A integração com o modelo de Data Science será feita em uma etapa posterior.

# 🛠️ Tecnologias

* Java 17+
* Spring Boot
* Spring Web
* Bean Validation (Jakarta Validation)
* Maven
* Docker
* Docker Compose

# 🚀 Como executar o projeto

## Pré-requisitos

### Execução local

* Java 25 ou superior
* Maven 4.0+

### Execução com Docker

* Docker
* Docker Compose

---

## 💻 Acessando o projeto hospedado

* http://64.181.181.54:8081/login

## 🐳 Executando o projeto com Docker (localmente)

### 1️⃣ Clonar o repositório

```bash
git clone <url-do-repositorio>
cd churninsight-backend
```

---

### 2️⃣ Configurar variáveis de ambiente

O projeto utiliza variáveis de ambiente para configuração de **perfil**, **JWT**, **banco de dados** e **bootstrap do usuário administrador**.

Copie o arquivo de exemplo:

```bash
cp .env-example .env
```

Edite o arquivo `.env` conforme necessário:

```env
SPRING_PROFILE_ACTIVE=dev

SECURITY_JWT_SECRET=dev-secret-123
JWT_EXPIRATION_SECONDS=3600

DB_HOST=db
DB_PORT=5432
DB_NAME=churn_insight_db
DB_USER=user123
DB_PASSWORD=pass123

BOOTSTRAP_ADMIN_EMAIL=admin@local.dev
BOOTSTRAP_ADMIN_PASSWORD=admin123
BOOTSTRAP_ADMIN_NAME=Administrator
```

---

### 3️⃣ Subir a aplicação

```bash
docker compose up --build
```

A aplicação irá:
- Subir o banco PostgreSQL
- Executar as migrations (Flyway)
- Iniciar a API Spring Boot
- Criar o usuário administrador (se necessário)

A API ficará disponível em:

```
http://localhost:8080
```

---

## ▶️ Executando localmente (sem Docker)

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```
http://localhost:8080
```

> ⚠️ Para execução local sem Docker, é necessário configurar manualmente as variáveis de ambiente e um banco PostgreSQL acessível.

---

# 📡 Endpoints disponíveis

### POST /auth/login
Recebe dados de um usuário para acessar o sistema.

### POST /predict
Recebe dados de um cliente e retorna a previsão de churn.

# ❌ Tratamento de erros

```json
{
  "error": "Campo 'customer_id' é obrigatório"
}
```
A API retorna erro 400 quando:
* Algum campo obrigatório não é informado;
* O tipo do campo é inválido.

# 🧪 Exemplo de uso
Exemplo – Cliente com risco de churn
```json
{
  "customer_id": "9305-CDSKC"
}
```
Resposta:
```json
{
  "prediction": 1,
  "probability": 0.6254,
  "risk_level": "MÉDIO",
  "retention_strategy": "**Ação 1: Migração para Plano Fidelidade com Desconto Progressivo**\nOferecer a transição imediata do contrato mensal para um plano de 12 meses, aplicando um desconto de 15% na fatura (reduzindo o custo para R$ 84,70). Isso elimina a volatilidade do modelo \"month-to-month\" e aumenta o custo de saída, retendo a cliente pelo valor financeiro percebido.\n\n**Ação 2: Automação de Pagamento e Bonificação de Conveniência**\nPropor a alteração da forma de pagamento de \"Electronic check\" para Débito Automático ou Cartão de Crédito. Para incentivar a mudança, conceder um crédito único de R$ 30,00 na próxima fatura. Essa ação remove o atrito mensal do pagamento manual e reduz o churn involuntário ou por decisão reativa no momento do pagamento.\n\n**Ação 3: Upgrade de Experiência e Garantia de Estabilidade da Fibra**\nAgendar um \"Check-up Digital\" gratuito com suporte prioritário para otimizar o sinal da Fibra Óptica na residência e oferecer 3 meses de um serviço de valor agregado (como streaming ou antivírus) sem custo. O objetivo é reforçar a superioridade técnica do serviço de fibra e aumentar a percepção de cuidado personalizado, combatendo a alta probabilidade de cancelamento."
}
```

# 🔌 Integração com Data Science

A API foi projetada para integrar com um microserviço de Data Science responsável por:

* Carregar o modelo preditivo;
* Receber dados do cliente;
* Retornar a previsão, probabilidade e plano de retenção.
