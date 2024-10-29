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
@Entity(name = "routine")
public class Routine {
    @Id
    @Column(name="session_id")
    private String sessionId;
    private String patientId;
    private String date;
    private String duration;
    private String dialysisSite;
    private String daialysisMachineSetting;
    private String treatmentAdjustment;


}
