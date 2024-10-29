package com.devstack.ecom.upscale.dto.response;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseSummeryDto {
    private String reportId;
    private String patientId;
    private String reportDate;
    private String doctorInCharge;
    private String treatmentHistory;
    private String dialysisSessionHistory;
    private String symptms;
}
