package com.stajokulu.stajcell.service;

import com.stajokulu.stajcell.model.MobileLine;
import com.stajokulu.stajcell.repository.BalanceRepository;
import com.stajokulu.stajcell.model.BalanceUnit;
import com.stajokulu.stajcell.repository.MobileLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;

    private final MobileLineService mobileLineService;

    public List<BalanceUnit> getBalances(String number) {

        MobileLine mobileLine = new MobileLineService.find(number);
        if(Objects.isNull(mobileLine)){
            throw new RuntimeException(("there line is not found by nımber:" + number));
        }

        List<BalanceUnit> balanceUnitList = balanceRepository.findBalanceUnitsByMobileLineIs(number);
        if(CollectionUtils.isEmpty(balanceUnitList)){
            throw new RuntimeException(("there is no balance : " + number));
        }

        return BalanceUnitList;
    }

    public  String addBalance(String number , String kind , Double amount){

        MobileLine mobileLine = mobileLineService.find(number);
        if(Objects.isNull(mobileLine)){
            throw new RuntimeException(("mobile line is not found by number:" + number));
        }

        BalanceUnit balanceUnit = new BalanceUnit();

        balanceUnit.setamount(amount);
        balanceUnit.setKind(amount);
        balanceUnit.setMobileLine(amount);

        balanceRepository.save(balanceUnit);

        return " balance is reccorded succesfully";


    }
}
