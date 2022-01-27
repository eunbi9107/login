<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" />
</head>
<body>
<h1>main</h1>
<%
String id = (String) session.getAttribute("id");
int isAdmin = (int) session.getAttribute("isAdmin");
if(id == null) response.sendRedirect("/demo/member/login");
%>
jsp표현식 세션 : <%= id %> <br>
el표현식 세션: ${id } <br>
그냥 : ${username } , ${useremail } <br>
mvo그냥 : ${mvo.username } , ${mvo.useremail } <br>
<hr>

<input type="button" value="회원정보조회" class="btn" onclick="location.href='/demo/member/info'">
<input type="button" value="회원정보수정" class="btn" onclick="location.href='/demo/member/update'">
<input type="button" value="로그아웃" class="btn" onclick="location.href='/demo/member/logout'">
<input type="button" value="회원탈퇴" class="btn" onclick="location.href='/demo/member/delete'">

<!-- 관리자일때만 메뉴확인가능 -->
<% 
if(id != null){
 if(id.equals("admin") || isAdmin == 2){ %>
  <input type="button" value="회원전체목록(관리자용)" class="btn" onclick="location.href='/demo/member/memberList'">
  <input type="button" value="상품전체목록(관리자용)" class="btn" onclick="location.href='/demo/member/adminGoodsList'">
  <input type="button" value="주문전체목록(관리자용)" class="btn" onclick="location.href='/demo/member/adminOrderList'">  
<%
 }
}
%>