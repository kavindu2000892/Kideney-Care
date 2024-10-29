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
@Entity(name = "signs")
public class Signs {
    @Id
    @Column(name="record_id")
    private String recordId;
    private String patientId;
    private String date;
    private String bloodPressure;
    private String heartRate;
    private String respiratoryRate;
    private String bloodOxygenSaturation;
    private String bodyTemperature;
    private String bodyWeight;
    private String patientSymptoms;


}
