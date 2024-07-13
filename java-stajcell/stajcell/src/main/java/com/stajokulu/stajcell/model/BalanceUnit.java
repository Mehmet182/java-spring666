package com.stajokulu.stajcell.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceUnit {
    @Id
    @GeneratedValue
    private Long id;

    private String kind;

    private Double remainder;

    @ManyToOne
    @JoinColumn(name = "number")
    private MobileLine mobileLine;
}
