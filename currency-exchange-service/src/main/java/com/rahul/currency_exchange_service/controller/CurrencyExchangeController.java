package com.rahul.currency_exchange_service.controller;

import com.rahul.currency_exchange_service.bean.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {


    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange thecurrencyExchange = new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(80));
        thecurrencyExchange.setEnvironment("8080");
        return thecurrencyExchange;
    }

}
