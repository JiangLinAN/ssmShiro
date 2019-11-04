<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: NoRe
  Date: 2019/11/1
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<html>
<head>
    <title>欢迎注册</title>
</head>
<body>
    <table>
        <tr>
            <td>用户名:<input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码:<input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td>性别:
                <input type="text" name="gender" id="gender">
            </td>
        </tr>
        <tr>
            <td>班级号:<input type="text" name="clazId" id="clazId"></td>
        </tr>
        <tr>
            <td><input type="button" onclick="registUser()" value="提交"/></td>
        </tr>
    </table>
</body>
<script>
    function registUser() {
        $.ajax({
            type: 'post',
            url: "http://localhost:8080/student04_jla_war_exploded/user/regist",
            contentType: 'application/json',
            data: JSON.stringify({
                "username": $("#username").val(),
                "password": $("#password").val(),
                "gender": $("#gender").val(),
                "clazId": $("#clazId").val()
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
