package com.example.demo.web.controller;

import com.example.demo.domain.dto.DocumentTypeDto;
import com.example.demo.domain.payload.request.DocumentTypeRequest;
import com.example.demo.domain.payload.response.DocumentTypeResponse;
import com.example.demo.domain.service.DocumentTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/document-type")
@Tag(name = "DocumentType", description = "DocumentType API")
public class DocumentTypeController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private DocumentTypeService documentTypeService;

    @GetMapping(value = "")
    public ResponseEntity<List<DocumentTypeResponse>> findAll(){
        try{
            List<DocumentTypeDto> documentTypeDtoList = documentTypeService.findAll();
            List<DocumentTypeResponse> documentTypeResponseList = new ArrayList<>();
            documentTypeDtoList.forEach(tipoDocumentoDto -> {
                documentTypeResponseList.add(modelMapper.map(tipoDocumentoDto, DocumentTypeResponse.class));
            });
            if(documentTypeDtoList.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(documentTypeResponseList);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DocumentTypeResponse> findById(@PathVariable Long id){
        try{
            DocumentTypeDto documentTypeDto = documentTypeService.findById(id);
            if(documentTypeDto == null){
                return ResponseEntity.notFound().build();
            }
            DocumentTypeResponse documentTypeResponse = modelMapper.map(documentTypeDto, DocumentTypeResponse.class);
            return ResponseEntity.ok(documentTypeResponse);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<DocumentTypeResponse> create(@RequestBody DocumentTypeRequest tipoDocumento){
        try{
            DocumentTypeDto documentTypeDto = modelMapper.map(tipoDocumento, DocumentTypeDto.class);
            documentTypeDto = documentTypeService.create(documentTypeDto);
            DocumentTypeResponse documentTypeResponse = modelMapper.map(documentTypeDto, DocumentTypeResponse.class);
            return ResponseEntity.ok(documentTypeResponse);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DocumentTypeResponse> update(@RequestBody DocumentTypeResponse tipoDocumento){
        try{
            DocumentTypeDto documentTypeDto = modelMapper.map(tipoDocumento, DocumentTypeDto.class);
            documentTypeDto = documentTypeService.update(documentTypeDto);
            if(documentTypeDto == null){
                return ResponseEntity.notFound().build();
            }
            DocumentTypeResponse documentTypeResponse = modelMapper.map(documentTypeDto, DocumentTypeResponse.class);
            return ResponseEntity.ok(documentTypeResponse);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DocumentTypeResponse> delete(@PathVariable Long id){
        try{
            DocumentTypeDto documentTypeDto = documentTypeService.findById(id);
            if(documentTypeDto == null){
                return ResponseEntity.notFound().build();
            }
            documentTypeService.delete(id);
            DocumentTypeResponse documentTypeResponse = modelMapper.map(documentTypeDto, DocumentTypeResponse.class);
            return ResponseEntity.ok(documentTypeResponse);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
