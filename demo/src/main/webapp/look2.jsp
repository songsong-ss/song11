<%@ page import="com.example.bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 宋宋
  Date: 2020/12/18
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
            List<User> l=(List)request.getAttribute("key");%>
    <table>
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>电话</th>
        </tr>
        <%
        for (int i = 0; i < l.size(); i++) {
            User u=l.get(i);
        %>
        <tr>
            <td><%=u.getId()%></td>
            <td><%=u.getName()%></td>
            <td><%=u.getAge()%></td>
            <td><%=u.getPhone()%></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
