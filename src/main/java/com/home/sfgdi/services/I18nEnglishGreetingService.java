package com.home.sfgdi.services;

import com.home.sfgdi.repositories.EnglishGreetingRepository;

//@Profile({"EN", "default"})
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World Service - EN";
    }
}
