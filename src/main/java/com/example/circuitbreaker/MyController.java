package com.example.circuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    @CircuitBreaker(name = "getInvoiceCB", fallbackMethod = "otherHello")
    public String sayHello() throws Exception {
        throw new Exception();
    }

    public String otherHello(Exception e){
        return "Bonjour !";
    }
}
