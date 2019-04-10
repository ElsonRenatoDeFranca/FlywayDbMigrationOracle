package com.flyway.migrationoracle.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "CUSTOMER")
@Getter
@Setter
@EqualsAndHashCode
public class Customer {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "CUST_SEQ", allocationSize = 1, name = "CUST_SEQ")
    private Long id;

    @Column(name = "CUST_ID")
    private Long custId;

    @Column(name = "CUST_FIRST_NAME", length = 30)
    private String firstName;

    @Column(name = "CUST_MIDDLE_NAME", length = 30)
    private String middleName;

    @Column(name = "CUST_LAST_NAME", length = 30)
    private String lastName;

}
