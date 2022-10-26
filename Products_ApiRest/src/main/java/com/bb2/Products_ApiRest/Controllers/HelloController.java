package com.bb2.Products_ApiRest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/")
    public String saludo(){
        System.out.println("Saludando desde HelloController");
        return "Hola desde HelloController";
    }

    @GetMapping("/authUserPrueba")
    public String authUserPrueba(){
        System.out.println("Han accedido a la parte autenticada 'user'");
        return "FELICIDADES USUARIO, HAS CONSEGUIDO AUTENTICARTE CORRECTAMENTE!!!!!";
    }

    @GetMapping("/authAdminPrueba")
    public String authAdminPrueba(){
        System.out.println("Han accedido a la parte autenticada 'admin'");
        return "FELICIDADES ADMIN, HAS CONSEGUIDO AUTENTICARTE CORRECTAMENTE!!!!!";
    }


}
