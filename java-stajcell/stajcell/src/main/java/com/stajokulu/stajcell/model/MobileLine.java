package com.stajokulu.stajcell.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MobileLine {

    @Id
    private String number;

    private String openDate;

    private String closeDate;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "customer_identity_no")
    private Customer customer;
/*
    @OneToMany(mappedBy = "mobileLine")
    private List<BalanceUnit> balanceUnitList;
 */
}
