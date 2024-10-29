package com.devstack.ecom.upscale.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "doctor")
public class Doctor {
    @Id
    @Column(name="doctor_id")
    private String doctorId;
    private String fullName;
    private String contact;
    private String lisenceNumber;
    private String currentCaseload;
    private String specialization;


}
