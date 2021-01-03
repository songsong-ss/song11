<%--
  Created by IntelliJ IDEA.
  User: 宋宋
  Date: 2020/12/9
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>添加联系人</title>
    <style type="text/css">
        input{
            border: 1px solid;
            margin: 2px;
        }
    </style>
</head>
<body>
    <h3>添加联系人页面</h3>
    <form action="addUserServlet" method="post">
        <label>id</label>
        <input type="text" name="id" /><br/>
        <label>姓名</label>
        <input type="text" name="name" /><br/>
        <label>年龄</label>
        <input type="text" name="age" /><br/>
        <label>电话</label>
        <input type="text" name="phone" /><br/>
        <input class="btn btn-primary" type="submit" value="提交"/>
        <input class="btn btn-default" type="reset" value="重置"/>
        <input class="btn btn-default" type="button" value="返回"/>

    </form>

</body>
</html>
