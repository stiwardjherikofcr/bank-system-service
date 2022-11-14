package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long document;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private Date createAt;
    private DocumentTypeDto documentType;

}
