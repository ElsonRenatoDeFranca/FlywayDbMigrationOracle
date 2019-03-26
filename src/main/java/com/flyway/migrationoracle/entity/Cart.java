package com.flyway.migrationoracle.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "CART")
@Getter
@Setter
@EqualsAndHashCode
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ")
    @SequenceGenerator(sequenceName = "CART_SEQ", allocationSize = 1, name = "CART_SEQ")
    private Long id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName="ID")})
    private List<Product> products = new ArrayList<>();



}
