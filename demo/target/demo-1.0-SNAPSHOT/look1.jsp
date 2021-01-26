<%@ page import="com.example.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 宋宋
  Date: 2020/12/18
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
            User u=(User)request.getAttribute("user");%>
    <table>
        <td><%=u.getId()%></td>
        <td><%=u.getAge()%></td>
        <td><%=u.getName()%></td>
        <td><%=u.getPhone()%></td>
    </table>
</body>
</html>
