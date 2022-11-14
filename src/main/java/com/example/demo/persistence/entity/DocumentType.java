package com.example.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_document_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentType implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_document_type")
        private Long idDocumentType;

        @Column(nullable = false, length = 50)
        private String name;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentType")
        private List<Customer> customersList;

}
