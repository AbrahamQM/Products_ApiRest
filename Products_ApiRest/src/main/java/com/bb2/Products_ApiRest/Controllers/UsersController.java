package com.bb2.Products_ApiRest.Controllers;

import com.bb2.Products_ApiRest.Services.Implementations.UserServiceImpl;
import com.bb2.Products_ApiRest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/") //Todo generar el index
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", userServiceImpl.getAllUsers());
        return "index";
    }

    //Añadir usuario  todo generar newuser
    @GetMapping("/adduser")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }

    //Guardar usuario
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/";
    }

    //todo generar update
    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        User user = userServiceImpl.getById(id);
        model.addAttribute("user", user);
        return "update";
    }

    //todo generar deleteViaId(id)
    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        userServiceImpl.deleteViaId(id);
        return "redirect:/";
    }

}
