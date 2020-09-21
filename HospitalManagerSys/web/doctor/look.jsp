<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>查看医生</title>
    <base href="<%=this.getServletContext().getContextPath() %>/doctor/">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />

    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>

    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
    <script type="text/javascript" src="../Js/ckeditor/ckeditor.js"></script>
 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
			 //祖传方法
			 window.history.back(-1);
		 });
    });
    </script>
</head>
<body>
<table class="table table-bordered table-hover definewidth m10">
<%--    private int did;
    private String name;
    private String cardno;
    private String phone;
    private int sex;
    private int age;
    private String birthday;
    private String email;
    private int department;
    private int education;
    private String remark;--%>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>${dc.name}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td>${dc.cardno}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">手机</td>
        <td>${dc.phone}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>
            <c:if test="${dc.sex== 0}">男</c:if>
            <c:if test="${dc.sex== 1}">女</c:if>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td>${dc.age}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">出生年月</td>
        <td>${dc.birthday}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电子邮箱</td>
        <td>${dc.email}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所属科室</td>
        <td>
        	<c:if test="${dc.department==1}">急诊科</c:if>
            <c:if test="${dc.department==2}">儿科</c:if>
            <c:if test="${dc.department==3}">妇科</c:if>
            <c:if test="${dc.department==4}">皮肤科</c:if>
            <c:if test="${dc.department==5}">内分泌科</c:if>
            <c:if test="${dc.department==6}">牙科</c:if>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">学历</td>
        <td>
        	<c:if test="${dc.education==1}">专科</c:if>
            <c:if test="${dc.education==2}">本科</c:if>
            <c:if test="${dc.education==3}">研究生</c:if>
            <c:if test="${dc.education==4}">博士</c:if>
        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>${dc.remark}</td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</body>
</html>