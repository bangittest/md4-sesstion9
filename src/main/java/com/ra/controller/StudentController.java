package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;
import com.ra.model.service.StudentSeviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "studentController",value = "/student")
public class StudentController extends HttpServlet {
    StudentService studentService=new StudentSeviceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "add":
                formAdd(req,resp);
                break;
            case "edit":
                formEdit(req,resp);
                break;
            case "delete":
                Delete(req,resp);
                break;
            case "search":
                formSearch(req,resp);
                break;
            case "sort":
                formSort(req,resp);
                break;
            default:
                showListStudent(req,resp);
                break;
        }
    }

    private void formSort(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String name = req.getParameter("sort");
        List<Student> listSearch = studentService.sortName(name);
        req.setAttribute("listStudent", listSearch);
            req.getRequestDispatcher("views/student.jsp").forward(req, resp);
    }

    private void formSearch(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("search");
        List<Student> listSearch = studentService.findByName(name);
        req.setAttribute("listStudent", listSearch);
        req.setAttribute("searchName", name);
        try {
            req.getRequestDispatcher("views/student.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
     int idEdit= Integer.parseInt(req.getParameter("id"));
     studentService.findByID(idEdit);
     studentService.delete(idEdit);
     showListStudent(req,resp);
    }

    private void formEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        int idEdit= Integer.parseInt(req.getParameter("id"));
        Student student=studentService.findByID(idEdit);
        req.setAttribute("student",student);
        req.getRequestDispatcher("views/edit-student.jsp").forward(req,resp);
    }

    private void formAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        resp.sendRedirect("views/add-student.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "add":
                actionAdd(req,resp);
                break;
            case "edit":
                actionEdit(req,resp);
                break;
            default:
                showListStudent(req,resp);
                break;
        }
    }

    private void actionEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int idEdit= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        Date birthday= Date.valueOf((req.getParameter("birthday")));
        String address=(req.getParameter("address"));
        Student student=new Student(idEdit,name,email,birthday,address);
        studentService.saveOfUpdate(student);
        showListStudent(req,resp);
    }

    private void actionAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Student student=new Student();
        student.setName(req.getParameter("name"));
        student.setEmail(req.getParameter("email"));
        student.setBirthday(Date.valueOf(req.getParameter("birthday")));
        student.setAddress(req.getParameter("address"));
        studentService.saveOfUpdate(student);
        showListStudent(req,resp);
    }

    private void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student>listStudent=studentService.findAll();
        req.setAttribute("listStudent",listStudent);
        req.getRequestDispatcher("views/student.jsp").forward(req,resp);
    }
}
