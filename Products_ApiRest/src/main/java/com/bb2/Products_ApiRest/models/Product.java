package com.bb2.Products_ApiRest.models;

import com.bb2.Products_ApiRest.Enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products", uniqueConstraints = @UniqueConstraint(columnNames = "item_code"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableJpaAuditing
//@ApiModel("Products: Entidad para representar un elemento producto con sus atributos") -->Para swagger
public class Product {

    //----------Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
//    @ApiModelProperty("Clave ficticia autoincremental tipo Long")  -->Para swagger
    private Long idProduct;
//  Item code: Must be a unique value. This should be a numeric value.
    @Column(name = "item_code", nullable = false)
    private Long itemCode;
//  Description
    @Column(nullable = false)
    private String description;
//  Price
    private Double price;
//  State : This can either be ‘Active’ or ‘Discontinued’.
    private StateEnum state;
//  Suppliers. Each item can be supplied by a set of suppliers. Likewise, a supplier can provide more than one item.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "suppliers_products", joinColumns = @JoinColumn(name = "id_product", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_supplier", nullable = false))
    private Set<Supplier> suppliers = new HashSet();

//  Price reductions. An item can have several price reductions associated to it. No control for overlapping dates is
//  required but recommended (look at the section ‘Extra points’).
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "price_reductions_products", joinColumns = @JoinColumn(name = "id_product", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "id_price_reduction", nullable = false))
    private Set<PriceReduction> priceReductions = new HashSet();

//  Creation date --->>SE DEBE GUARDAR UNA FECHA DE CREACIÓN AL CONSTRUIR LA ENTIDAD Product
    private ZonedDateTime creationDate;

//  Creator (User) -->Enlaza con Tabla Usuarios y obtiene el usuario que lo ha creado.
    private User creator;

}
