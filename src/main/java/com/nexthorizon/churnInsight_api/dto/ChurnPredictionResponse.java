package com.nexthorizon.churnInsight_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChurnPredictionResponse {
  private Integer prediction;
  private Double probability;
  private String risk_level;
  private String retention_strategy;
}
