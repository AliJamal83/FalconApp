package intec.be.Falconapp.services;


import intec.be.Falconapp.models.State;
import intec.be.Falconapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {


    //Inject the service into the repository
    @Autowired
    private StateRepository stateRepository;


    //Return list of states
    public List<State> getStates() {
        return stateRepository.findAll();

    }

    //Save new state
    public void save(State state) {
        stateRepository.save(state);
    }

    //Get by id
    public Optional<State> findById(Integer id) {
        return stateRepository.findById(id);
    }

    // Delete state from state list

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
