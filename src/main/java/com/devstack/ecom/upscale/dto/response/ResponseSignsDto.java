package com.devstack.ecom.upscale.dto.response;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseSignsDto {
    private String recordId;
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
