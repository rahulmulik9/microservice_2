package com.rahul.currency_exchange_service.circuitBreaker;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    @GetMapping("/simpleapi")
    public String getSimpleAPI() {
        return "Simple_API";
    }

}
