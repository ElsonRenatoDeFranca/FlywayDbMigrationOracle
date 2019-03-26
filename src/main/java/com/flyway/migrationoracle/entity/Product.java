package com.flyway.migrationoracle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.List;

@Entity(name = "PRODUCT")
@Getter
@Setter
@EqualsAndHashCode(of = "name")
public class Product implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @SequenceGenerator(sequenceName = "PRODUCT_SEQ", allocationSize = 1, name = "PRODUCT_SEQ")
    private Long id;

    @Column(name = "PRODUCT_NAME", length = 50)
    private String name;

    @Column(name = "PRODUCT_DESCRIPTION", length = 80)
    private String description;

    @Column(name = "PRODUCT_COST", length = 30)
    private Double cost;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;

}
