package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Customer;
import com.example.demo.persistence.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public List<Customer> findByDocumentType(DocumentType documentType);

}
