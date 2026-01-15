package com.nexthorizon.churnInsight_api.service;

import com.nexthorizon.churnInsight_api.client.ChurnPredictionClient;
import com.nexthorizon.churnInsight_api.dto.ChurnPredictionRequest;
import com.nexthorizon.churnInsight_api.dto.ChurnPredictionResponse;
import org.springframework.stereotype.Service;

@Service
public class PredictionService implements ChurnPredictionService {

  private final ChurnPredictionClient churnPredictionClient;

  public PredictionService(ChurnPredictionClient churnPredictionClient) {
    this.churnPredictionClient = churnPredictionClient;
  }

  @Override
  public ChurnPredictionResponse predict(ChurnPredictionRequest request) {
    return churnPredictionClient.predict(request);
  }
}
