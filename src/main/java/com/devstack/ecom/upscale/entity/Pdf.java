package com.devstack.ecom.upscale.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "pdf")
public class Pdf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private  String userName;
    @Lob
    @Column(length = 1000000)
    private byte[] displayPicture;


}
