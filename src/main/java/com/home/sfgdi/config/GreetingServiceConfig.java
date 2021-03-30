package com.home.sfgdi.config;

import com.home.sfgdi.repositories.EnglishGreetingRepository;
import com.home.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.home.sfgdi.services.*;
import org.springframework.context.annotation.*;
import org.springframework.pets.PetService;
import org.springframework.pets.PetServiceFactory;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    @Profile({"dog", "default"})
    @Bean
    PetService dogPetSerivce(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetSerivce("dog");
    }
    @Profile({"cat"})
    @Bean
    PetService catPetSerivce(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetSerivce("cat");
    }

    @Profile("ES")
    @Bean("i18nService") //by defualt java uses method name not the class
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"EN", "default"})
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary //profile setting works here as well, like in class annotation
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

//    @Bean  // Now defined via xml Lec77
//    ConstructorGreetingService constructorGreetingService() {
//        return new ConstructorGreetingService();
//    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
