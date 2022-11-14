package com.example.demo.web.controller;

import com.example.demo.domain.dto.CustomerDto;
import com.example.demo.domain.dto.DocumentTypeDto;
import com.example.demo.domain.payload.response.CustomerResponse;
import com.example.demo.domain.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "")
    public ResponseEntity<List<CustomerResponse>> findAll(@RequestParam(name = "documentTypeId", required = false) Long documentTypeId){
        try{
            List<CustomerDto> customerDtoList = new ArrayList<>();
            if(documentTypeId == null){
                customerDtoList = customerService.findAll();
            }else{
                customerDtoList = customerService.findByDocumentType(DocumentTypeDto.builder().idDocumentType(documentTypeId).build());
            }
            List<CustomerResponse> customerResponseList = new ArrayList<>();
            customerDtoList.forEach(customerDto -> {
                customerResponseList.add(modelMapper.map(customerDto, CustomerResponse.class));
            });
            return ResponseEntity.ok(customerResponseList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponse> findById(@RequestParam(name = "id") Long id){
        try{
            CustomerDto customerDto = customerService.findById(id);
            CustomerResponse customerResponse = modelMapper.map(customerDto, CustomerResponse.class);
            return ResponseEntity.ok(customerResponse);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerDto customerDto){
        try{
            CustomerDto customerDtoSaved = customerService.create(customerDto);
            CustomerResponse customerResponse = modelMapper.map(customerDtoSaved, CustomerResponse.class);
            return ResponseEntity.ok(customerResponse);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerResponse> update(@RequestBody CustomerDto customerDto){
        try{
            CustomerDto customerDtoSaved = customerService.update(customerDto);
            CustomerResponse customerResponse = modelMapper.map(customerDtoSaved, CustomerResponse.class);
            return ResponseEntity.ok(customerResponse);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CustomerResponse> delete(@PathVariable(name = "id") Long id){
        try{
            customerService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
