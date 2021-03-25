package com.home.sfgdi.services;

//@Primary  //comment both out for the java impl vs annotations/stereotype
//@Service
public class PrimaryGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - From the PRIMARY Bean!";
    }
}
