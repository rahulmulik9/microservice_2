package com.rahul.currency_exchange_service.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rahul.currency_exchange_service.bean.CurrencyExchange;
import com.rahul.currency_exchange_service.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    @Autowired
    private CurrencyExchangeRepository repository;
    @Autowired
    private Environment environment;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {

        logger.info("retrieveExchangeValue called with {} to {}", from, to);
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if(currencyExchange ==null) {
            throw new RuntimeException("Unable to Find data for " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }

}
