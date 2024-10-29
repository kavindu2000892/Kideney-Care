package com.devstack.ecom.upscale.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestRoutineDto {
    private String patientId;
    private String date;
    private String duration;
    private String dialysisSite;
    private String daialysisMachineSetting;
    private String treatmentAdjustment;
}
