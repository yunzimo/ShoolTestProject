<%--
  Created by IntelliJ IDEA.
  User: yunzimo
  Date: 20-9-10
  Time: 下午6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>修改学员的信息</title>
    <script src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
<form action="StudentServlet?method=UpdateStudentInfo&&id=${s.id}" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input type="text" value="${s.name}" name="name"></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" value="${s.age}" name="age"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <input type="radio" name="sex" value="男" <c:if test="${s.sex=='男'}">checked="checked"</c:if>>男
                <input type="radio" name="sex" value="女" <c:if test="${s.sex=='女'}">checked="checked"</c:if>>女
            </td>
        </tr>
        <tr>
            <td>生日:</td>
            <fmt:parseDate value="${s.birthday}" pattern="yyyy-MM-dd" var="data"/>
            <td><input type="date" name="birthday" value="<fmt:formatDate value='${data}' pattern='yyyy-MM-dd'/>" class="birthday"></td>
        </tr>
        <tr>
            <td>学历:</td>
            <td>
                <select name="degree" id="">
                    <option value="本科" <c:if test="${s.degree=='本科'}">selected="selected"</c:if> >本科</option>
                    <option value="专科" <c:if test="${s.degree=='专科'}">selected="selected"</c:if> >专科</option>
                    <option value="硕士" <c:if test="${s.degree=='硕士'}">selected="selected"</c:if> >硕士</option>
                    <option value="博士" <c:if test="${s.degree=='博士'}">selected="selected"</c:if> >博士</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>爱好:</td>
            <td>
                <input type="checkbox" name="hobby" value="唱歌" <c:if test="${s.hobby.contains('唱歌')}">checked="checked"</c:if> >唱歌
                <input type="checkbox" name="hobby" value="跳舞" <c:if test="${s.hobby.contains('跳舞')}">checked="checked"</c:if>>跳舞
                <input type="checkbox" name="hobby" value="游泳" <c:if test="${s.hobby.contains('游泳')}">checked="checked"</c:if>>游泳
                <input type="checkbox" name="hobby" value="上网" <c:if test="${s.hobby.contains('上网')}">checked="checked"</c:if>>上网
            </td>
        </tr>
        <tr>
            <td>头像：</td>
            <td>
                <input type="file" name="pic">
                <img src="http://localhost:8080/face/${s.pic}" alt="">
                <input type="hidden" name="oldpic" value="${s.pic}">
            </td>

        </tr>
        <tr>
            <td>备注：</td>
            <td><textarea name="mark" cols="30" rows="5" >${s.mark}</textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改"></td>
        </tr>

    </table>
</form>
</body>
</html>
<script type="text/javascript">
    console.log($(".birthday").val());
</script>