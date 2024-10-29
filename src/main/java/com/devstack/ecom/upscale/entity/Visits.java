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
@Entity(name = "visits")
public class Visits {
    @Id
    @Column(name="visit_id")
    private String visitId;
    private String patientId;
    private String preDialysisAssesments;
    private String postDialysisAssesments;
    private String actions;
    private String healthcareTeam;



}
