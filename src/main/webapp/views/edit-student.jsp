<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2023
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/student">
    label>id</label>
    <input type="text" name="id" value="${student.id}" readonly>
    <label>Nhap ten</label>
    <input type="text" name="name" value="${student.name}" placeholder="nhap ten">
    <label>email</label>
    <input type="text" name="email" value="${student.email}" placeholder="nhap dia chi emai">
    <label>birthday</label>
    <input type="date" value="${student.birthday}" name="birthday">
    <label>address</label>
    <input type="text" name="address" value="${student.address}" placeholder="nhap dia chi">
    <button value="edit" name="action"  type="submit">Edit</button>
</form>
</body>
</html>
