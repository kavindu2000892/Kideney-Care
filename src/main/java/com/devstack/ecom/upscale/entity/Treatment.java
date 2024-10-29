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
@Entity(name = "treatment")
public class Treatment {
    @Id
    @Column(name="plan_id")
    private String planId;
    private String patientId;
    private String fullName;
    private String primaryDiagnosis;
    private String secondaryDiagnosis;
    private String frequencyOfDialysis;
    private String dialyzerType;
    private String preDialysisMedications;
    private String postDialysisMedications;


}
