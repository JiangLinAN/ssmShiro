<%--
  Created by IntelliJ IDEA.
  User: NoRe
  Date: 2019/11/1
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <!--1引入bootstrap的css-->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!--2jquery-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js" type="text/javascript"></script>
    <!--3bootstrap.js-->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <!--4 validate-->
    <script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
    <!--5 中文库-->
    <script src="${pageContext.request.contextPath}/js/messages_zh.js" type="text/javascript"></script>
</head>
<body>
<h2>展示班级</h2>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered table-hover table-condensed">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>班级名称</th>
                    <th>创建时间</th>
                    <shiro:hasRole name="teacher">
                        <th>操作</th>
                    </shiro:hasRole>
                </tr>
                </thead>
                <c:forEach var="claz" items="${requestScope.allClaz}">
                <tbody>
                <tr>
                    <td>${claz.id}</td>
                    <td>${claz.clazName}</td>
                    <td>
                        <fmt:formatDate value="${claz.createTime}" pattern="yyyy-MM-dd"/>
                    </td>
                    <shiro:hasRole name="teacher">
                        <td>
                            <a href="${pageContext.request.contextPath}/user/allUser?clazId=${claz.id}">查看学生</a>
                            <a href="${pageContext.request.contextPath}/claz/queryClazById?id=${claz.id}">修改</a>
                            <a href="${pageContext.request.contextPath}/claz/insertClaz">添加</a>
                        </td>
                    </shiro:hasRole>
                </tr>
                </c:forEach>
                </tbody>
            </table>
           </div>
    </div>
</div>
</body>
</html>
