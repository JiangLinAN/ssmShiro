<%--
  Created by IntelliJ IDEA.
  User: NoRe
  Date: 2019/11/1
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <!--1引入bootstrap的css-->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!--2jquery-->
    <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
    <!--3bootstrap.js-->
    <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <!--4 validate-->
    <script src="js/jquery.validate.js" type="text/javascript"></script>
    <!--5 中文库-->
    <script src="js/messages_zh.js" type="text/javascript"></script>
</head>
<body>
<div class="container" style="margin-top: 100px">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="form-group">
                <label for="username" class="col-sm-7 control-label">账号:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" />
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-7 control-label">密码:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" />
                </div>
            </div>
            <div class="form-group">
                <label for="code" class="col-sm-7 control-label">验证码:</label>
                <div class="col-sm-10">
                    <img id="cap" src="${pageContext.request.contextPath}/captcha">
                    <input  onblur="checkCap()" type="text" class="form-control" id="code" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-10">
                    <button  onclick="loginUser()" style="width: 200px;height: 50px">登 录</button>
                </div>
            </div>
            <a href="regist.jsp">学生注册</a>
            <a href="regist2.jsp">老师注册</a>
        </div>
    </div>
</div>
</div>
</body>
<script type="application/javascript">
    $(function () {
        $("#cap").click(function () {
            //刷新验证码
            path = $(this).attr("src") + "?" + new Date().getTime();
            $(this).attr("src", path);
        });
    });

    var codeCount=1;
    function checkCap() {
        $.ajax({
            type:"post",
            url:"http://localhost:8080/student04_jla_war_exploded/user/checkCode",
            contentType:"application/Json",

            data:JSON.stringify({
                "code=":$("#code").val()
            }),

            success: function (R) {
                if (R.msg=="验证码ok"){
                    codeCount=0;
                }
            },
            error: function () {
                alert("验证码错误")
            }
        })
    }

    function loginUser() {
        console.log("login  "+codeCount)
        if (codeCount==0){
            $.ajax({
                type: 'post',
                url: "http://localhost:8080/student04_jla_war_exploded/user/login",
                contentType: 'application/json',
                data: JSON.stringify({
                    "username": $("#username").val(),
                    "password": $("#password").val()
                }),
                success: function (status) {
                    alert(status.msg)
                    if (status.msg=="登录成功"){
                        location.href="http://localhost:8080/student04_jla_war_exploded/claz/list"
                    }
                },
                error: function () {
                    alert("登录错误")
                }
            })
        }else {
            alert("请输入正确的验证码")
        }
    }

</script>
</html>
