package com.devstack.ecom.upscale.dto.response;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePatientDto {
    private String patientId;
    private String fullName;
    private String birthDay;
    private String gender;
    private String contact;
    private String diagnosisType;
    private String surgicalHistory;
    private String allergies;
}
