
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        if(session.getAttribute("username")==null){
            session.setAttribute("msg","用户未登录，请登录");
            response.sendRedirect("login.jsp");
        }
    %>

