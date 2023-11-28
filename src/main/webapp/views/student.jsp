<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2023
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="student">
    <input type="submit" name="action" value="sort">
</form>
<form action="student">
    <input type="text" name="search" value="${searchName}">
    <input type="submit" name="action" value="search">
</form>
<a href="student?action=add">Them hoc sinh</a>
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>email</th>
        <th>birthday</th>
        <th>address</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
   <c:forEach items="${listStudent}" var="item" >
       <tr>
           <td>${item.id}</td>
           <td>${item.name}</td>
           <td>${item.email}</td>
           <td>${item.birthday}</td>
           <td>${item.address}</td>
           <td><a href="/student?action=edit&id=${item.id}">Edit</a></td>
           <td><a href="/student?action=delete&id=${item.id}">Delete</a></td>
       </tr>
   </c:forEach>
    </tbody>
</table>
</body>
</html>
