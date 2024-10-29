package com.devstack.ecom.upscale.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestSummeryDto {
    private String patientId;
    private String reportDate;
    private String doctorInCharge;
    private String treatmentHistory;
    private String dialysisSessionHistory;
    private String symptms;
}
