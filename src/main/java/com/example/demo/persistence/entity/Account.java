package com.example.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Integer idAccount;

    @Column(nullable = false, length = 20)
    private Double balance;

    @JoinColumn(name = "id_customer", referencedColumnName = "document")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name = "id_bank_branch", referencedColumnName = "id_bank_branch")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BankBranch bankBranch;

    @JoinColumn(name = "id_account_type", referencedColumnName = "id_account_type")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AccountType accountType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Transaction> transactionsList;

}
