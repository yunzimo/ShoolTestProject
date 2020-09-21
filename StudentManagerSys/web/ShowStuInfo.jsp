<%@ page import="com.offcn.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: yunzimo
  Date: 20-9-9
  Time: 下午7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
<head>
    <title>所有学员的信息</title>
</head>
<script src="js/jquery-3.5.1.min.js"></script>
<body>

<form action="StudentServlet?method=ShowAllStudentInfo" method="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="querykey"></td>
            <td><input type="submit" value="查询"></td>
        </tr>
    </table>
</form>
<table border="1" align="center">

    <tr>
        <th>姓名：</th>
        <th>年龄：</th>
        <th>性别：</th>
        <th>生日：</th>
        <th>学历：</th>
        <th>爱好：</th>
        <th>头像：</th>
        <th>备注：</th>
        <th colspan="3">操作：</th>
    </tr>

    <c:forEach items="${list}" var="s">
    <tr>
        <td>${s.name}</td>
        <td>${s.age}</td>
        <td>${s.sex}</td>
        <td>
            <fmt:parseDate value="${s.birthday}" pattern="yyyy-MM-dd" var="data"/>
            <fmt:formatDate value="${data}" pattern="yyyy-MM-dd"/>
        </td>
        <td>${s.degree}</td>
        <td>${s.hobby}</td>
        <td>
            <img src="http://localhost:8080/face/${s.pic}" alt="" width="30px" height="30px">
        </td>
        <td>${s.mark}</td>
        <td><button value="${s.id}" class="delete">删除</button></td>
        <td><a href="StudentServlet?method=ShowStudentInfoById&&id=${s.id}">详情</a></td>
        <td><a href="StudentServlet?method=ShowStudentInfoModify&&id=${s.id}">修改</a></td>
    </tr>

    </c:forEach>
    <tr align="center">
        <td colspan="11">
            <a href="StudentServlet?method=ShowAllStudentInfo&currentPage=1&querykey=${querykey}">首页</a>
            <a href="StudentServlet?method=ShowAllStudentInfo&currentPage=${limit.prePage}&querykey=${querykey}">上一页</a>
            <a href="StudentServlet?method=ShowAllStudentInfo&currentPage=${limit.nextPage}&querykey=${querykey}">下一页</a>
            <a href="StudentServlet?method=ShowAllStudentInfo&currentPage=${limit.totalPages}&querykey=${querykey}">尾页</a>
            共${limit.totalPages}页，当前是${limit.currentPage}/${limit.totalPages}页
        </td>
    </tr>
</table>
</body>
</html>
<script type="text/javascript">
    $(".delete").click(function () {
        var b = confirm("确认删除");
        if(b==true){
            window.location.href="StudentServlet?method=DeleteStudentById&&id="+$(".delete").val();
        }
    })
</script>