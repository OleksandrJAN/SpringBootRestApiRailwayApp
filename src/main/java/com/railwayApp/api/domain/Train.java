package com.railwayApp.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trains")
@Getter
@Setter
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false, length = 63)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "train_type", nullable = false)
    private TrainType trainType;

    @Column(name = "electronic_registration", nullable = false)
    private boolean electronicRegistration;

    @Column(name = "firm_train", nullable = false)
    private boolean firmTrain;


    @OneToOne(mappedBy = "train")
    @JsonBackReference
    private Route route;

}
