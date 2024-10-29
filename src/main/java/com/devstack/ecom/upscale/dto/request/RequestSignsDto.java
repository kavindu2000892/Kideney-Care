package com.devstack.ecom.upscale.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestSignsDto {
    private String patientId;
    private String date;
    private String bloodPressure;
    private String heartRate;
    private String respiratoryRate;
    private String bloodOxygenSaturation;
    private String bodyTemperature;
    private String bodyWeight;
    private String patientSymptoms;
}
