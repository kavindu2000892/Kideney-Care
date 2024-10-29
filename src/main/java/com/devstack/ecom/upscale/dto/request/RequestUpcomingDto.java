package com.devstack.ecom.upscale.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestUpcomingDto {
    private String patientId;
    private String date;
    private String time;
    private String sessionStatus;
    private String assignedBed;
}
