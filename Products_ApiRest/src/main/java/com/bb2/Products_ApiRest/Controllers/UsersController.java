package com.bb2.Products_ApiRest.Controllers;

import com.bb2.Products_ApiRest.Services.Implementations.UserServiceImpl;
import com.bb2.Products_ApiRest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
//@Controller //-------------------------todo convertir mvc en RestContoller con react
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/allUsers/")
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }



//    @GetMapping("/")
//    public String viewHomePage(Model model) {
////        model.addAttribute("alluserslist", userServiceImpl.getAllUsers());
//        return "Hola desde UsersController.viewHomePage";
//    }
//
//    //Añadir usuario  todo generar newuser
//    @GetMapping("/adduser")
//    public String addNewUser(Model model){
//        User user = new User();
//        model.addAttribute("user", user);
//        return "newuser";
//    }
//
//    //Guardar usuario
//    @PostMapping("/save")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userServiceImpl.save(user);
//        return "redirect:/";
//    }
//
//    //todo generar update
//    @GetMapping("/showFormForUpdate/{id}")
//    public String updateForm(@PathVariable(value = "id") long id, Model model) {
//        User user = userServiceImpl.getById(id);
//        model.addAttribute("user", user);
//        return "update";
//    }
//
//    //todo generar deleteViaId(id)
//    @GetMapping("/deleteEmployee/{id}")
//    public String deleteThroughId(@PathVariable(value = "id") long id) {
//        userServiceImpl.deleteViaId(id);
//        return "redirect:/";
//    }

}
