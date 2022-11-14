package com.example.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_bank_branches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankBranch implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_bank_branch")
    private Long idBankBranch;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankBranch")
    private List<Account> accountsList;

}
