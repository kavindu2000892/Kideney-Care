package com.devstack.ecom.upscale.dto.response;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseUpcomingDto {
    private String sessionId;
    private String patientId;
    private String date;
    private String time;
    private String sessionStatus;
    private String assignedBed;
}
