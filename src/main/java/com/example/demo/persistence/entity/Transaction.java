package com.example.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_transaccions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long idTransaccion;

    @Column(nullable = false, length = 20)
    private Double amount;

    @JoinColumn(name = "id_account", referencedColumnName = "id_account")
    @ManyToOne(optional = false)
    private Account account;

    @JoinColumn(name = "id_transaction_type", referencedColumnName = "id_transaction_type")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TransactionType transactionType;

}
