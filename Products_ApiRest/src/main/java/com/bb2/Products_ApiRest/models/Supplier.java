package com.bb2.Products_ApiRest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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
