package com.devstack.ecom.upscale.dto.response;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseRoutineDto {
    private String sessionId;
    private String patientId;
    private String date;
    private String duration;
    private String dialysisSite;
    private String daialysisMachineSetting;
    private String treatmentAdjustment;
}
