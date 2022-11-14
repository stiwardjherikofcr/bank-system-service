package com.example.demo.domain.service;

import com.example.demo.domain.dto.CustomerDto;
import com.example.demo.domain.dto.DocumentTypeDto;

import java.util.List;

public interface CustomerService extends BaseService<CustomerDto> {

    public List<CustomerDto> findByDocumentType(DocumentTypeDto documentType) throws Exception;

}
