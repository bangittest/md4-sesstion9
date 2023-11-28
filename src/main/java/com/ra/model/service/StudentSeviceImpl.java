package com.ra.model.service;

import com.ra.model.dao.StudentDao;
import com.ra.model.dao.StudentDaoImpl;
import com.ra.model.entity.Student;

import java.util.List;

public class StudentSeviceImpl implements StudentService{
    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public boolean saveOfUpdate(Student student) {
        return studentDao.saveOfUpdate(student);
    }

    @Override
    public Student findByID(Integer integer) {
        return studentDao.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        studentDao.delete(integer);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public List<Student> sortName(String name) {
        return studentDao.sortName(name);
    }
}
