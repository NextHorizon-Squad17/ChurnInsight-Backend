package com.nexthorizon.churnInsight_api.dto;

public class ChurnPredictRequest {
    private Integer contractTenureMonths;
    private Integer paymentDelays;
    private Double monthlyUsage;
    private String planType;
}
