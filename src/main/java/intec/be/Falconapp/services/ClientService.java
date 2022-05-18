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

    //Return list of clients
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    //SAve new client
    public void save(Client client) {
        clientRepository.save(client);
    }

    //get by id
    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
