package com.ra.model.service;

import java.util.List;

public interface IGenericService <T,ID>{
    List<T> findAll();
    boolean saveOfUpdate(T t);

     T findByID(ID id);
     void delete(ID id);
}
