<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
	String imgPath=request.getScheme()+"://"+request.getServerName()+":"+
			request.getServerPort()+"/Hospital_pic/";
	pageContext.setAttribute("imgPath",imgPath);
%>
<!DOCTYPE html>
<html>
<base href="<%=this.getServletContext().getContextPath() %>/medicine/">
<head>
    <title>药品查询</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

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
	
    </script>
</head>
<body>

<form action="${path}MedicineServlet?method=QueryMedicineByKey" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover definewidth m10">
	    <tr>
	        <td width="10%" class="tableleft">药品名称：</td>
	        <td><input type="text" id="name" name="name" value="${name}"/></td>
			
	        <td width="10%" class="tableleft">药品类型：</td>
	        <td>
		        <select name="type" id="type">
		        	<option value="0" >==请选择==</option>
					<option value="1" <c:if test="${type=='1'}">selected="selected"</c:if> >处方药</option>
			        <option value="2" <c:if test="${type=='2'}">selected="selected"</c:if>>中药</option>
			        <option value="3" <c:if test="${type=='3'}">selected="selected"</c:if>>西药</option>
		        </select>
	        </td>
	    </tr>
	    <tr>
			  <td colspan="4">
				<center>
					<input id="find" name="find" type="submit" class="btn btn-primary" value="查询"/>
			  		<input id="ret" name="ret" type="button" class="btn btn-primary" value="清空"/> 
				</center>
	        </td>
	    </tr>
	</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall"></th>
        <th>药品编号</th>
        <th>药品名称</th>
        <th>图片</th>
        <th>药品类型</th>
        <th>简单描述</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    	<c:forEach items="${medicines}" var="mc">
			<tr>
				<td><input type="checkbox" name="chk" value="${mc.mid}"></td>
				<td>${mc.mid}</td>
				<td>${mc.name}</td>
				<td>
					<img src="${imgPath}${mc.picture}" alt="" width="50px" height="50px">
				</td>
				<td>
					<c:if test="${mc.type=='1'}">处方药</c:if>
					<c:if test="${mc.type=='2'}">中药</c:if>
					<c:if test="${mc.type=='3'}">西药</c:if>
				</td>
				<td>${mc.descs}</td>
				<td>
					<a href="${path}MedicineServlet?method=QueryMedicineById&mid=${mc.mid}">详情</a>
					<a href="${path}MedicineServlet?method=ModifyMedicineShow&mid=${mc.mid}">修改</a>
				</td>
			</tr>
		</c:forEach>
     </tbody>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  
  			<div class="inline pull-right page">
	          <a href="${path}MedicineServlet?method=QueryMedicineByKey&currentPage=1&name=${name}&type=${type}" >首页</a>
	          <a href="${path}MedicineServlet?method=QueryMedicineByKey&currentPage=${tool.prePage}&name=${name}&type=${type}">上一页</a>
	          <a href="${path}MedicineServlet?method=QueryMedicineByKey&currentPage=${tool.nextPage}&name=${name}&type=${type}" >下一页</a>
	          <a href="${path}MedicineServlet?method=QueryMedicineByKey&currentPage=${tool.totalPages}&name=${name}&type=${type}" >尾页</a>
			  &nbsp;&nbsp;&nbsp;
			     共<span class='current'>${tool.totalCount}</span>条记录
			  <span class='current'>${tool.currentPage}/${tool.totalPages}</span>页
		  </div>
		 <div>
			<button type="button" class="btn btn-success" id="newNav">添加新药</button>	
			<button type="button" class="btn btn-success" id="delete">批量删除</button>
		 </div>
		 
		 </th></tr>
  </table>
  
</body>
</html>
<script type="text/javascript">
	$("#newNav").click(function () {
		window.location="${path}medicine/add.jsp";
	});
	$("#checkall").click(function () {
		$("[name='chk']").prop("checked",$(this).prop("checked"));
	});
	$("#delete").click(function () {
		var chks=$("[name='chk']:checked");
		var mids="";
		for(var i=0;i<chks.length;i++){
			mids+="'"+chks[i].value+"',";
		}
		mids=mids.substring(0,mids.length-1);
		alert(mids);

		if(mids==""){
			alert("请点选想要删除的药品");
			return;
		}
		if(confirm("确认删除")){
			window.location="${path}MedicineServlet?method=DeleteMedicineByMids&mids="+mids;
		}
	})
</script>