<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2023
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/student">
  <label>Nhap ten</label>
  <input type="text" name="name" placeholder="nhap ten">
  <label>email</label>
  <input type="text" name="email" placeholder="nhap dia chi emai">
  <label>birthday</label>
  <input type="date" name="birthday">
  <label>address</label>
  <input type="text" name="address" placeholder="nhap dia chi">
  <button value="add" name="action" type="submit">ADD</button>
</form>
</body>
</html>
