package com.ra.model.dao;

import java.util.List;

public interface IGenericDao <T,ID>{
    List<T> findAll();

    boolean saveOfUpdate(T ID);

    T findById(ID id);
    void delete (ID id);


}
