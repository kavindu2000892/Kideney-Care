package com.devstack.ecom.upscale.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestPatientDto {
    private String fullName;
    private String birthDay;
    private String gender;
    private String contact;
    private String diagnosisType;
    private String surgicalHistory;
    private String allergies;
}
