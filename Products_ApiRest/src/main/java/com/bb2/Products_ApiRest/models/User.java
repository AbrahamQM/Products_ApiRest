package com.bb2.Products_ApiRest.models;

import com.bb2.Products_ApiRest.Enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @NotEmpty
    private RoleEnum role;
}
