<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script type="text/javascript">
        function refreshCode() {
            var img=document.getElementById("imgObj");
            img.src="${pageContext.request.contextPath}/getCode?time="+new Date().getTime();
        }
    </script>
</head>
<body>
${er}
<form action="loginServlet" method="post">
    <label>请输入用户名：</label>
    <input type="text" name="username" placeholder="请输入用户名"/><br/>
    <label>请输入密码：</label>
    <input type="password" name="password" placeholder="请输入密码"/><br/>
    <label>请输入验证码：</label>
    <input type="text" name="verifyCode"/><img id="imgObj" alt="验证码" src="${pageContext.request.contextPath}/getCode"><a href="javascript:refreshCode();" >换一张</a>${verifyCheck}<br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>