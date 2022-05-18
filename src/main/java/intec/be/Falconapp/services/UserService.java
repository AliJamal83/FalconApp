package intec.be.Falconapp.services;


import intec.be.Falconapp.models.User;
import intec.be.Falconapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //Get All Users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //Get User By id
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }


    //Delete User
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }


    //Update User
    public void save(User user) {
        userRepository.save(user);
    }

}
