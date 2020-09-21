<%--
  Created by IntelliJ IDEA.
  User: yunzimo
  Date: 20-9-10
  Time: 下午5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>成员的详细信息</title>
    <style type="text/css">
        div{
            margin: auto;
        }
        .top{
            width: 500px;
            height: 150px;
            box-shadow: 0px 0px 10px 3px lightblue;
        }
        .box{
            margin-top: 15px;
            width: 500px;
            height: 500px;
            /* border: 2px solid black; */
            box-shadow: 0px 0px 10px 3px lightblue;

        }
        img{
            margin-top: 15px;
            margin-left: 15px;
            width: 120px;
            height: 120px;
            /* border-radius: 50%; */
            object-fit: cover;
        }
        #name-box{
            margin-top: -130px;
            width: 130px;
            height: 130px;
            /* border: 3px solid black; */
            margin-right: 15px;
            align-content: center;
        }
        #name-ta{
            width: 150px;
        }
        #detail{
            padding-top: 100px;
            margin: auto;
        }
        #detail tr td{
            padding-top: 20px;
        }
    </style>
</head>
<body>

<div class="top">
    <img src="http://localhost:8080/face/${s.pic}" >
    <div id="name-box">
        <table border="0px" cellspacing="" cellpadding="10" align="center">
            <tr><th id="name-ta">${s.name}</th></tr>
            <br>
            <tr align="center"><td>${s.age}岁</td></tr>
        </table>
    </div>
</div>
<div class="box">
    <table id="detail">
        <tr>
            <td>性别：</td>
            <td>${s.age}</td>
        </tr>
        <tr>
            <td>生日：</td>
            <td>
                <fmt:parseDate value="${s.birthday}" pattern="yyyy-MM-dd" var="data"/>
                <fmt:formatDate value="${data}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr>
            <td>学历：</td>
            <td>${s.degree}</td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td>${s.hobby}</td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>${s.mark}</td>
        </tr>

    </table>
</div>


</body>
</html>
