<%@ page import="com.example.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 宋宋
  Date: 2020/12/11
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<% User u=(User)request.getAttribute("user");%>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <input type="text" name="id" value="<%=u.getId()%>"/>
        <input type="text" name="name" value="<%=u.getName()%>"/>
        <input type="text" name="age" value="<%=u.getAge()%>"/>
        <input type="text" name="phone" value="<%=u.getPhone()%>"/>
        <input class="btn btn-primary" type="submit" value="提交"/>
        <input class="btn btn-default" type="reset" value="重置"/>
    </form>
</body>
</html>
