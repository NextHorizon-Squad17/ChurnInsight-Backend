package com.nexthorizon.churnInsight_api.client;

import com.nexthorizon.churnInsight_api.dto.ChurnPredictionRequest;
import com.nexthorizon.churnInsight_api.dto.ChurnPredictionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ChurnPredictionClient {

  private final WebClient webClient;

  public ChurnPredictionClient(
      WebClient.Builder builder, @Value("${microservices.churn-model.base-url}") String baseUrl) {
    this.webClient = builder.baseUrl(baseUrl).build();
  }

  public ChurnPredictionResponse predict(ChurnPredictionRequest request) {
    return webClient
        .post()
        .uri("/predict")
        .bodyValue(request)
        .retrieve()
        .bodyToMono(ChurnPredictionResponse.class)
        .block();
  }
}
