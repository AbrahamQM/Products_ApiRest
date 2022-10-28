package com.bb2.Products_ApiRest.DTOs;

import com.bb2.Products_ApiRest.Enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class UserDTO {
    private Long idUser;
    private String userName;
    private String password;
    private RoleEnum role;

    public UserDTO() {
    }

    public UserDTO(Long idUser, String userName, String password, RoleEnum role) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    //Getters & setters

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
