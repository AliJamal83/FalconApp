package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.User;
import intec.be.Falconapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //Gte All Users
    @GetMapping("users")
    public String findAll(Model model) {
        return "User";
    }


    @RequestMapping("users/findById")
    @ResponseBody
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }


    //Add User
    @PostMapping(value = "users/addNew")
    public String addNew(User user) {
        userService.save(user);
        return "redirect:/users";

    }


    @RequestMapping(value = "users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        userService.save(user);
        return "redirect:/users";
    }


    @RequestMapping(value = "users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }


}
