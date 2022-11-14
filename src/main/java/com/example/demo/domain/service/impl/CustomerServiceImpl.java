package com.example.demo.domain.service.impl;

import com.example.demo.domain.dto.CustomerDto;
import com.example.demo.domain.dto.DocumentTypeDto;
import com.example.demo.domain.service.CustomerService;
import com.example.demo.persistence.entity.Customer;
import com.example.demo.persistence.entity.DocumentType;
import com.example.demo.persistence.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> findAll() throws Exception {
        try {
            List<Customer> customerEntityList = customerRepository.findAll();
            List<CustomerDto> customerDtoList = new ArrayList<>();
            for (Customer customerEntity : customerEntityList) {
                customerDtoList.add(modelMapper.map(customerEntity, CustomerDto.class));
            }
            return customerDtoList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public CustomerDto findById(Long id) throws Exception {
        try {
            return customerRepository.findById(id)
                    .map(customerEntity -> modelMapper.map(customerEntity, CustomerDto.class))
                    .orElseThrow(() -> new Exception("No se encontro el customer"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public CustomerDto create(CustomerDto customer) throws Exception {
        try {
            Customer customerEntity = modelMapper.map(customer, Customer.class);
            customerEntity = customerRepository.save(customerEntity);
            return modelMapper.map(customerEntity, CustomerDto.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public CustomerDto update(CustomerDto customer) throws Exception {
        try {
            Customer customerEntity = modelMapper.map(customer, Customer.class);
            customerEntity = customerRepository.save(customerEntity);
            return modelMapper.map(customerEntity, CustomerDto.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public CustomerDto delete(Long id) throws Exception {
        try {
            Customer customerEntity = customerRepository.findById(id)
                    .orElseThrow(() -> new Exception("No se encontro el customer"));
            customerRepository.delete(customerEntity);
            return modelMapper.map(customerEntity, CustomerDto.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<CustomerDto> findByDocumentType(DocumentTypeDto documentType) throws Exception {
        try {
            DocumentType documentTypeEntity = modelMapper.map(documentType, DocumentType.class);
            List<Customer> customerEntityList = customerRepository.findByDocumentType(documentTypeEntity);
            List<CustomerDto> customerDtoList = new ArrayList<>();
            for (Customer customer : customerEntityList) {
                customerDtoList.add(modelMapper.map(customer, CustomerDto.class));
            }
            return customerDtoList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
