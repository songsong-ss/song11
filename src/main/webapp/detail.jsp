<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 宋宋
  Date: 2020/12/8
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<h3>欢迎您，${username}!</h3><br/>
    <form action="${pageContext.request.contextPath}/searchServlet" method="post">
        <label>id</label><input type="text" name="id" value="0"/>
        <input class="btn btn-primary" type="submit" value="提交"/>
    </form>
    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
    </div>
    <table border="1px solid">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>电话</th>
            <th></th>
        </tr>
        <c:forEach items="${key_list}" var="usr" varStatus="idx">
            <tr>
                <td>${usr.id}</td>
                <td>${usr.name}</td>
                <td>${usr.age}</td>
                <td>${usr.phone}</td>
                <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/deleteUserServlet?id=${usr.id}">删除联系人</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/updateServlet?id=${usr.id}">修改联系人</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
