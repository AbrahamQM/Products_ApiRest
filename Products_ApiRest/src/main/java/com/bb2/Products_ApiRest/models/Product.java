package com.bb2.Products_ApiRest.models;
import com.bb2.Products_ApiRest.Enums.StateEnum;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products", uniqueConstraints = @UniqueConstraint(columnNames = "item_code"))
public class Product {

    //----------Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idproduct")
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
    private List<Supplier> suppliers = new ArrayList<>();

//  Price reductions. An item can have several price reductions associated to it. No control for overlapping dates is
//  required but recommended (look at the section ‘Extra points’).
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "price_reductions_products", joinColumns = @JoinColumn(name = "id_product", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "id_priceReduction", nullable = false))
    private List<PriceReduction> priceReductions = new ArrayList<>();

//  Creation date --->>SE DEBE GUARDAR UNA FECHA DE CREACIÓN AL CONSTRUIR LA ENTIDAD Product
    @CreatedDate
    private LocalDateTime creationDate;

//  Creator (User) -->Enlaza con Tabla Usuarios y obtiene el usuario que lo ha creado.
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "creator", referencedColumnName = "user_id", nullable = false)
    private User creator;

    //Constructores
    public Product() {
    }

    public Product(Long idProduct, Long itemCode, String description, Double price, StateEnum state,
                   String reasonDeactivation, List<Supplier> suppliers, List<PriceReduction> priceReductions,
                   LocalDateTime creationDate, User creator) {
        this.idProduct = idProduct;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.state = state;
        this.reasonDeactivation = reasonDeactivation;
        this.suppliers = suppliers;
        this.priceReductions = priceReductions;
        this.creationDate = creationDate;
        this.creator = creator;
    }


    //Getter y setter


    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public String getReasonDeactivation() {
        return reasonDeactivation;
    }

    public void setReasonDeactivation(String reasonDeactivation) {
        this.reasonDeactivation = reasonDeactivation;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<PriceReduction> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(List<PriceReduction> priceReductions) {
        this.priceReductions = priceReductions;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

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
