package com.ra.model.dao;

import com.ra.model.entity.Student;
import com.ra.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
        Connection connection = null;
        List<Student> studentList = new ArrayList<>();
        try {
            connection = ConnectDB.openConnection();
            CallableStatement call = connection.prepareCall("{CALL PROC_SELECT_STUDENT}");
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday"));
                student.setAddress(resultSet.getString("address"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return studentList;
    }

    @Override
    public boolean saveOfUpdate(Student student) {
        Connection connection = null;
        try {
            connection = ConnectDB.openConnection();
            int check;
            if (student.getId() == 0) {
                connection = ConnectDB.openConnection();
                CallableStatement call = connection.prepareCall("{CALL PROC_CREATE_STUDENT (?,?,?,?)}");
                call.setString(1, student.getName());
                call.setString(2, student.getEmail());
                call.setDate(3, student.getBirthday());
                call.setString(4, student.getAddress());
                check = call.executeUpdate();
            } else {
                CallableStatement call = connection.prepareCall("{CALL PROC_UPDATE_STUDENT(?,?,?,?,?)}");
                call.setInt(1, student.getId());
                call.setString(2, student.getName());
                call.setString(3, student.getEmail());
                call.setDate(4, student.getBirthday());
                call.setString(5, student.getAddress());

                check = call.executeUpdate();
            }
            if (check > 0) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Student findById(Integer id) {
        Connection connection = null;
        Student student = new Student();
        try {
            connection = ConnectDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student where id=?");
            pstm.setInt(1,id);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday"));
                student.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return  student;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection=null;
        try {
            connection=ConnectDB.openConnection();
            CallableStatement call=connection.prepareCall ("{CALL PROC_DELETE_STUDENT(?)}");
            call.setInt(1,integer);
            int check=call.executeUpdate();
            if (check==0){
                System.out.println(integer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(connection);
        }
    }

    @Override
    public List<Student> findByName(String name) {
        Connection connection=null;
        List<Student>students=new ArrayList<>();
        connection=ConnectDB.openConnection();
        try {
            CallableStatement call=connection.prepareCall("CALL PROC_SEARCH_STUDENT_BY_NAME(?)");
                call.setString(1,name);
                ResultSet rs=call.executeQuery();
                while (rs.next()){
                    Student student=new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setBirthday(rs.getDate("birthday"));
                    student.setAddress(rs.getString("address"));
                    students.add(student);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(connection);
        }
        return students;
    }

    @Override
    public List<Student> sortName(String name) {
        Connection connection=null;
        List<Student>students=new ArrayList<>();
        connection=ConnectDB.openConnection();
        try {
            CallableStatement call=connection.prepareCall("CALL PROC_SORT_STUDENT_BY_NAME");
            ResultSet rs=call.executeQuery();
            while (rs.next()){
                Student student=new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddress(rs.getString("address"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(connection);
        }
        return students;
    }
}
