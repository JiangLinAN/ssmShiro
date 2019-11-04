<%--
  Created by IntelliJ IDEA.
  User: NoRe
  Date: 2019/11/1
  Time: 20:21
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
    <title>学生管理</title>
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
<h3>学生管理</h3>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered table-hover table-condensed">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>注册时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach var="user" items="${requestScope.pageInfo.list}">
                <tbody>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.gender}</td>
                    <td>
                        <fmt:formatDate value="${user.registTime}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/user/queryUserById?id=${user.id}">修改</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/regist.jsp">添加学生</a>
            <a class="btn btn-default"
               href="${pageContext.request.contextPath}/user/allUser?clazId=${requestScope.clazId}&num=1">首页</a>
            <a class="btn btn-default"
               href="${pageContext.request.contextPath}/user/allUser?clazId=${requestScope.clazId}&num=${pageInfo.pageNum-1>1?pageInfo.pageNum-1:1}">上一页</a>
            <c:forEach begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}" var="pn">
                <a class="btn btn-default"
                   href="${pageContext.request.contextPath}/user/allUser?clazId=${requestScope.clazId}&num=${pn}">${pn}</a>
            </c:forEach>
            <a class="btn btn-default"
               href="${pageContext.request.contextPath}/user/allUser?clazId=${requestScope.clazId}&num=${pageInfo.pageNum+1<pageInfo.pages?pageInfo.pageNum+1:pageInfo.pages}">下一页</a>
            <a class="btn btn-default"
               href="${pageContext.request.contextPath}/user/allUser?clazId=${requestScope.clazId}&num=${pageInfo.pages}">尾页</a>
        </div>
    </div>
</div>
</body>
</html>
