<%--
  Created by IntelliJ IDEA.
  User: NoRe
  Date: 2019/11/1
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<html>
<head>
    <title>老师注册</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/regist2">
    <table>
        <tr><td>用户名:<input type="text" id="username" name="username"></td> </tr>
        <tr><td>密码:<input type="password" id="password" name="password"> </td></tr>
        <tr><td>性别:<input type="text" name="gender" id="gender">
        </td></tr>
        <tr>
            <td><input type="button" onclick="registUser()" value="提交" /></td>
        </tr>
    </table>
</form>
</body>
<script>
    function registUser() {
        $.ajax({
            type: 'post',
            url: "http://localhost:8080/student04_jla_war_exploded/user/regist2",
            contentType: 'application/json',
            data: JSON.stringify({
                "username": $("#username").val(),
                "password": $("#password").val(),
                "gender": $("#gender").val()
            }),
            success: function (status) {
                alert(status.msg)
                if (status.msg == "注册成功") {
                    location.href = "http://localhost:8080/student04_jla_war_exploded/login.jsp"
                }
            },
            error: function () {
                alert("注册错误")
            }
        })
    }
</script>
</html>
