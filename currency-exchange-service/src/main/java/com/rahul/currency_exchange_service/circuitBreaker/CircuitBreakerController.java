package com.rahul.currency_exchange_service.circuitBreaker;


import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/simple-api")
    @Retry(name="simple-api", fallbackMethod="hardCodedResponse")
    public String getSimpleAPI() {
        logger.info("Sample api call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class);
       // return "Simple_API";
        return forEntity.getBody();
    }

    public String hardCodedResponse(Exception exception){
        return "Fall-back Repose";
    }

}