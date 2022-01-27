<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>/main.jsp</h1>
<%
String id = (String) session.getAttribute("id");
if(id == null) response.sendRedirect("/demo/member/login");
%>
jsp표현식 세션 : <%= id %> <br>
el표현식 세션: ${id } <br>
그냥 : ${username } , ${useremail } <br>
mvo그냥 : ${mvo.username } , ${mvo.useremail } <br>

<hr>
<input type="button" onclick="location.href='/demo/member/logout'" value="로그아웃">