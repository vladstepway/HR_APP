package com.company.dao;


import java.util.List;

public interface GenericDao<T, M> {

    int create(T object);

    T getByPK(M key);

    int update(T object);

    int delete(M key);

    List<T> getAll();


}
