package com.home.sfgdi.services;

import org.springframework.stereotype.Service;

//@Service // comment out for 'java' config vs annotations/stereotype
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor!";
    }
}
