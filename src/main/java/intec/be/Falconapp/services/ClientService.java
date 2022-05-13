package intec.be.Falconapp.services;


import intec.be.Falconapp.controllers.ClientController;
import intec.be.Falconapp.models.Client;
import intec.be.Falconapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    //Get all Clients
    public List<Client> findAll() {
        return clientRepository.findAll();
    }


    //Get Clients by id
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }


    //Delete Client
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }


    //Update Client
    public void save(Client client) {
        clientRepository.save(client);
    }
}
