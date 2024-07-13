package com.stajokulu.stajcell.controller;

import com.stajokulu.stajcell.service.BalanceService;
import com.stajokulu.stajcell.model.BalanceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping
    public List<BalanceUnit> getBalances(@RequestParam String number)
    {
        return  balanceService.getBalances(number);
    }

    @PostMapping("/add")
    public  String addBalance (@RequestParam String number
    @RequestParam String kind
            @RequestParam String amount ) {
        return balanceService.addBalance(number , kind , amount) ;
    }


}
