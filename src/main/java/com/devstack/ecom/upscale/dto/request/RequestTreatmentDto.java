package com.devstack.ecom.upscale.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestTreatmentDto {
    private String patientId;
    private String fullName;
    private String primaryDiagnosis;
    private String secondaryDiagnosis;
    private String frequencyOfDialysis;
    private String dialyzerType;
    private String preDialysisMedications;
    private String postDialysisMedications;

}
