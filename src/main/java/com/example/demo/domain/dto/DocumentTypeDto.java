package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentTypeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idDocumentType;
    private String name;

}
