package com.devstack.ecom.upscale.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestNurseDto {
    private String fullName;
    private String contact;
    private String lisenceNumber;
    private String onCallStatus;
    private String specialization;
}
