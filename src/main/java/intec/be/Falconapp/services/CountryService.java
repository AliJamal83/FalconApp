package intec.be.Falconapp.services;

import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {


    //Autowired the service into the repository
    @Autowired
    private CountryRepository countryRepository;

    //Return list of countries
    public List<Country> getCountries() {
        return countryRepository.findAll();

    }

    //Save new country
    public void save(Country country) {
        countryRepository.save(country);
    }
}
