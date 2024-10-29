package com.devstack.ecom.upscale.dto.response;



import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDoctorDto {
    private String doctorId;
    private String fullName;
    private String contact;
    private String lisenceNumber;
    private String currentCaseload;
    private String specialization;
}
