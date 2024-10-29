package com.devstack.ecom.upscale.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestVisitsDto {
    private String patientId;
    private String preDialysisAssesments;
    private String postDialysisAssesments;
    private String actions;
    private String healthcareTeam;
}
