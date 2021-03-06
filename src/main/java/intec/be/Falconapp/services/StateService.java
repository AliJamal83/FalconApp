package intec.be.Falconapp.services;


import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.models.State;
import intec.be.Falconapp.repositories.CountryRepository;
import intec.be.Falconapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {


    //Inject the state service into the StateRepository where he StateRepository extends from the JpaRepository.
    @Autowired
    private StateRepository stateRepository;

    //Get All States
    public List<State> findAll() {
        return stateRepository.findAll();

    }

    //Save new state
    public void save(State state) {
        stateRepository.save(state);
    }



    //Get State By id
    public Optional<State> findById(Integer id) {
        return stateRepository.findById(id);
    }

    // Delete state
    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
