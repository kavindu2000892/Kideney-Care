package com.devstack.ecom.upscale.dto.response;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseVisitsDto {
    private String visitId;
    private String patientId;
    private String preDialysisAssesments;
    private String postDialysisAssesments;
    private String actions;
    private String healthcareTeam;
}
