package com.nexthorizon.churnInsight_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChurnPredictionRequest {

  @NotNull
  @JsonProperty("Gender")
  private String gender;

  @NotNull
  @JsonProperty("SeniorCitizen")
  private Integer seniorCitizen;

  @NotNull
  @JsonProperty("Partner")
  private String partner;

  @NotNull
  @JsonProperty("Dependents")
  private String dependents;

  @NotNull
  @JsonProperty("TenureMonths")
  private Integer tenureMonths;

  @NotNull
  @JsonProperty("PhoneService")
  private String phoneService;

  @NotNull
  @JsonProperty("MultipleLines")
  private String multipleLines;

  @NotNull
  @JsonProperty("InternetService")
  private String internetService;

  @NotNull
  @JsonProperty("OnlineSecurity")
  private String onlineSecurity;

  @NotNull
  @JsonProperty("OnlineBackup")
  private String onlineBackup;

  @NotNull
  @JsonProperty("DeviceProtection")
  private String deviceProtection;

  @NotNull
  @JsonProperty("TechSupport")
  private String techSupport;

  @NotNull
  @JsonProperty("StreamingTV")
  private String streamingTV;

  @NotNull
  @JsonProperty("StreamingMovies")
  private String streamingMovies;

  @NotNull
  @JsonProperty("Contract")
  private String contract;

  @NotNull
  @JsonProperty("PaperlessBilling")
  private String paperlessBilling;

  @NotNull
  @JsonProperty("PaymentMethod")
  private String paymentMethod;

  @NotNull
  @JsonProperty("MonthlyCharges")
  private Double monthlyCharges;

  @NotNull
  @JsonProperty("TotalCharges")
  private Double totalCharges;
}
