package com.example.demo.service.base;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;

public interface GenericService<T> {
	List<T> findAll() throws ServiceException;
    Optional<T> findById(long id) throws ServiceException;
    List<T> findByObject(T t) throws ServiceException;
    T save(T t) throws ServiceException;
    T update(T t) throws ServiceException;
    void deleteLogic(Long id) throws ServiceException;
}
