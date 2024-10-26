package com.rahul.currency_exchange_service.controller;

import com.rahul.currency_exchange_service.bean.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment theEnviroment;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange thecurrencyExchange = new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(80));
        String port = theEnviroment.getProperty("local.server.port");
        thecurrencyExchange.setEnvironment(port);
        return thecurrencyExchange;
    }

}
