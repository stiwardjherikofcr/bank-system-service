package com.example.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_account_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountType implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_type")
    private Integer idAccountType;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false, length = 20)
    private Double interest;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountType")
    private List<Account> accountsList;

}
