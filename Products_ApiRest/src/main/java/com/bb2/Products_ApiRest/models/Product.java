package com.bb2.Products_ApiRest.models;

import com.bb2.Products_ApiRest.Enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idproduct")
//    @ApiModelProperty("Clave ficticia autoincremental tipo Long")  -->Para swagger
    private Long idProduct;

    @Column(name = "item_code", nullable = false)
    private Long itemCode;//  Item code: Must be a unique value. This should be a numeric value.

    @Column(nullable = false)
    private String description;

    private Double price;
    private StateEnum state;//  State : This can either be ‘Active’ or ‘Discontinued’.
    private String reasonDeactivation;

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
    @CreatedDate
    private LocalDateTime creationDate;

//  Creator (User) -->Enlaza con Tabla Usuarios y obtiene el usuario que lo ha creado.
    private User creator;


    //----------Métodos
    public void addSupplier(Supplier supplier) {
        if (supplier.getName() == null || supplier.getCountry() == null) {
            System.out.println("Error trying to ad a supplier without necessary data.  REVISAR NOMBRE Y PAÍS");
        }else if (suppliers.contains(supplier)){
            System.out.println("Error the supplier: " + supplier.getName() + " is already at the list" );
        }else{
            suppliers.add(supplier);
        }
    }

    public void removeSupplier(Supplier supplier){
        if (suppliers.contains(supplier)) {
            suppliers.remove(supplier);
        }else{
            System.out.println("Error trying to remove a supplier that is not at the list for this product.");
        }
    }

    public void addPriceReduction(PriceReduction reduction) {
        if (reduction == null) {
            System.out.println("Error trying to ad a empty price reduction.");
        }
        priceReductions.add(reduction);
    }

    public void removePriceReduction(PriceReduction reduction) {
        if (priceReductions.contains(reduction)) {
            System.out.println("Removing price reduction " + reduction);
            priceReductions.remove(reduction);
        }
        System.out.println("Error trying to remove a price reduction that is not at the list for this product.");
    }
}
