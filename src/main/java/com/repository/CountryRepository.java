package com.repository;

import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country country = new Country();
        country.setCapital("Madrid");
        country.setCurrency(Currency.EUR);
        country.setPopulation(300000);
        country.setName("Spain");
        countries.put("Spain", country);
        country = new Country();
        country.setCapital("Москва");
        country.setCurrency(Currency.RUB);
        country.setPopulation(146206000);
        country.setName("Россия");
        countries.put("Россия", country);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}