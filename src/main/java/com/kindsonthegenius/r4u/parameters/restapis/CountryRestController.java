package com.kindsonthegenius.r4u.parameters.restapis;

import com.kindsonthegenius.r4u.parameters.models.Country;
import com.kindsonthegenius.r4u.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    @CrossOrigin
    @GetMapping("/api/parameters/countries")
    public List<Country>  getAll(Model model){
        List<Country> countries =   countryService.findAll();
        return countries;
    }
}
