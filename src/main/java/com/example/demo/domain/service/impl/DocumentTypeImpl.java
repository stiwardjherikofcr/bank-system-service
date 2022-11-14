package com.example.demo.domain.service.impl;

import com.example.demo.domain.dto.DocumentTypeDto;
import com.example.demo.domain.service.DocumentTypeService;
import com.example.demo.persistence.entity.DocumentType;
import com.example.demo.persistence.repository.DocumentTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentTypeImpl implements DocumentTypeService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Override
    public List<DocumentTypeDto> findAll() throws Exception {
        try {
            List<DocumentType> documentTypeEntityList = documentTypeRepository.findAll();
            List<DocumentTypeDto> documentTypeDtoList = new ArrayList<>();
            for (DocumentType documentTypeEntity : documentTypeEntityList) {
                documentTypeDtoList.add(modelMapper.map(documentTypeEntity, DocumentTypeDto.class));
            }
            return documentTypeDtoList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DocumentTypeDto findById(Long id) throws Exception {
        try {
            return documentTypeRepository.findById(id)
                    .map(tipoDocumentoEntity -> modelMapper.map(tipoDocumentoEntity, DocumentTypeDto.class))
                    .orElseThrow(() -> new Exception("No se encontro el tipo de documento"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DocumentTypeDto create(DocumentTypeDto tipoDocumento) throws Exception {
        try {
            DocumentType documentTypeEntity = modelMapper.map(tipoDocumento, DocumentType.class);
            documentTypeEntity = documentTypeRepository.save(documentTypeEntity);
            return modelMapper.map(documentTypeEntity, DocumentTypeDto.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DocumentTypeDto update(DocumentTypeDto tipoDocumento) throws Exception {
        try {
            DocumentType documentTypeEntity = modelMapper.map(tipoDocumento, DocumentType.class);
            documentTypeEntity = documentTypeRepository.save(documentTypeEntity);
            return modelMapper.map(documentTypeEntity, DocumentTypeDto.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DocumentTypeDto delete(Long id) throws Exception {
        try {
            return documentTypeRepository.findById(id)
                    .map(tipoDocumentoEntity -> {
                        documentTypeRepository.delete(tipoDocumentoEntity);
                        return modelMapper.map(tipoDocumentoEntity, DocumentTypeDto.class);
                    })
                    .orElseThrow(() -> new Exception("No se encontro el tipo de documento"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
