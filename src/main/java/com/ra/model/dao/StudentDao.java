package com.ra.model.dao;

import com.ra.model.entity.Student;

import java.util.List;

public interface StudentDao extends IGenericDao<Student,Integer> {
    List<Student> findByName(String name);
    List<Student>sortName(String name);
}
