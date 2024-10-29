package com.devstack.ecom.upscale.dto.response;



import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseNurseDto {
    private String nurseId;
    private String fullName;
    private String contact;
    private String lisenceNumber;
    private String onCallStatus;
    private String specialization;
}
