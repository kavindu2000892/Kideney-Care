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
@Entity(name = "summery")
public class Summery {
    @Id
    @Column(name="report_id")
    private String reportId;
    private String patientId;
    private String reportDate;
    private String doctorInCharge;
    private String treatmentHistory;
    private String dialysisSessionHistory;
    private String symptms;


}
