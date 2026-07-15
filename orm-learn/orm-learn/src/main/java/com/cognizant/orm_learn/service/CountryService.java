package com.cognizant.orm_learn.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

import java.util.List;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository=countryRepository;
    }

    @Transactional

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

}
