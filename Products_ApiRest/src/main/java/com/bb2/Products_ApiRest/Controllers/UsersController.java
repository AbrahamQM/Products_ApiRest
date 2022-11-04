package com.bb2.Products_ApiRest.Controllers;

import com.bb2.Products_ApiRest.DTOs.ProductDTO;
import com.bb2.Products_ApiRest.DTOs.UserDTO;
import com.bb2.Products_ApiRest.Repositories.UserRepository;
import com.bb2.Products_ApiRest.Services.Implementations.UserServiceImpl;
import com.bb2.Products_ApiRest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    //Get All
    @GetMapping("/allUsers")
    public List<UserDTO> getAllUsers() {
        List<UserDTO> usersDto = userServiceImpl.getAllUsers();
        for ( UserDTO userDTO : usersDto ){ //Oculto las contraseñas
            userDTO.setPassword(null);
        }

        return usersDto;
    }

    //Create User
    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        if(userDTO.getIdUser() != null){ //Si el usuario ya tiene id no es una creación
            return ResponseEntity.badRequest().build();
        }
        //compruebo que el nombre no existe ya en la lista de usuarios almacenados
        List<UserDTO> users = userServiceImpl.getAllUsers();
        for(UserDTO dto : users){
            if(dto.getUserName().equalsIgnoreCase(userDTO.getUserName())){
                return ResponseEntity.badRequest().build();
            }
        }
        //Everything parece ok, creo el usuario y lo devuelvo en la response
        userDTO = userServiceImpl.createUser(userDTO);
        userDTO.setPassword(null); //oculto la contraseña antes de devolverlo
        return ResponseEntity.ok(userDTO);
    }

    //Get one by id
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO dto = userServiceImpl.getById(id);
        if (dto != null){
            dto.setPassword(null); //oculto la contraseña antes de devolver el objeto creado.
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserDTO> deleteUserById(@PathVariable Long id){
        if (id.equals(null) || id == 0L){//compruebo que pasen una id y protejo el usuario ficticio
            return ResponseEntity.badRequest().build();
        }
        UserDTO dto = userServiceImpl.deleteById(id);
        dto.setPassword(null); //oculto la contraseña antes de devolver el objeto eliminado.
        return ResponseEntity.ok(dto);
    }


}
