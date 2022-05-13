package intec.be.Falconapp.services;


import intec.be.Falconapp.models.Contact;
import intec.be.Falconapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    //Get All Contacts
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    // Get Contacts By Id
    public Optional<Contact> findById(Integer id) {
        return contactRepository.findById(id);
    }


    //Delete Contact
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }


    //Update Contact
    public void save(Contact contact) {
        contactRepository.save(contact);
    }
}
