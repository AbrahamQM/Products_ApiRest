package com.bb2.Products_ApiRest.models;

import com.bb2.Products_ApiRest.Enums.RoleEnum;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "user_id")
    private Long idUser;

    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;

//    @NotEmpty
    @Column(columnDefinition = "VARCHAR(6)", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public User() {
    }

    public User(Long idUser, @NotEmpty String userName, @NotEmpty String password, @NotEmpty RoleEnum role) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

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
