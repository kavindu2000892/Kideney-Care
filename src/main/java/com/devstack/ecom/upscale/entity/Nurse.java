package com.devstack.ecom.upscale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "nurse")
public class Nurse {
    @Id
    @Column(name="nurse_id")
    private String nurseId;
    private String fullName;
    private String contact;
    private String lisenceNumber;
    private String onCallStatus;
    private String specialization;



}
