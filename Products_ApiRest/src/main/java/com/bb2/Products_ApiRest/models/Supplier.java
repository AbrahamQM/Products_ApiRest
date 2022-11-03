package com.bb2.Products_ApiRest.models;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_id_seq")
        @SequenceGenerator(name = "supplier_id_seq", sequenceName = "supplier_id_seq", allocationSize = 1, schema = "erp")
        @Column(name = "supplier_id")
        private Long idSupplier;

        private String name;
        private String country;

        public Supplier() {
        }

        public Supplier(Long idSupplier, String name, String country) {
                this.idSupplier = idSupplier;
                this.name = name;
                this.country = country;
        }

        public Long getIdSupplier() {
                return idSupplier;
        }

        public void setIdSupplier(Long idSupplier) {
                this.idSupplier = idSupplier;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }
}
