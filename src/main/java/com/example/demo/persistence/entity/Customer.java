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
@Table(name = "tbl_customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long document;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false, length = 50)
	private String address;

	@Column(nullable = false, length = 10)
	private String phone;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@JoinColumn(name = "id_document_type", referencedColumnName = "id_document_type")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private DocumentType documentType;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Account> accountsList;

}
