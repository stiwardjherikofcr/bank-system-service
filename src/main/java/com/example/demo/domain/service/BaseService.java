package com.example.demo.domain.service;

import java.util.List;

public interface BaseService<T> {

    public List<T> findAll() throws Exception;

    public T findById(Long id) throws Exception;

    public T create(T t) throws Exception;

    public T update(T t) throws Exception;

    public T delete(Long id) throws Exception;

}
