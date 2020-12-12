package com.persistence.interfaces;

public interface CrudRepository<T> {
    Long save(T object);
    T getById(Long id);
    //others method, right now just testing
}
