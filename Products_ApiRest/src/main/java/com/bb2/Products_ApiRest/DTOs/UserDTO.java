package com.bb2.Products_ApiRest.DTOs;

import com.bb2.Products_ApiRest.Enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long idUser;
    private String userName;
    private String password;
    private RoleEnum role;
}
