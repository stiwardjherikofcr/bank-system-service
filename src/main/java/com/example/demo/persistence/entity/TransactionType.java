package com.example.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_transaction_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionType implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction_type")
    private Integer idTransactionType;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionType")
    private List<Transaction> transactionsList;

}
