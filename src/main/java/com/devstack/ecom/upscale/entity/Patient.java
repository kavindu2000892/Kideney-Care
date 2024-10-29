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
@Entity(name = "patient")
public class Patient {
    @Id
    @Column(name="patient_id")
    private String patientId;
    private String fullName;
    private String birthDay;
    private String gender;
    private String contact;
    private String diagnosisType;
    private String surgicalHistory;
    private String allergies;


}
