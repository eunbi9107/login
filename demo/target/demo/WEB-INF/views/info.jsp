<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
/info.jsp
<h2>마이페이지</h2>
<table border="1">
	<tr>
		<td>아이디</td>
		<td>${memVO.userid }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${memVO.userpw }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${memVO.username }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${memVO.useremail }</td>
	</tr>
	<tr>
		<td>가입일자</td>
		<td>${memVO.regdate }</td>
	</tr>
</table>
<input type="button" value="메인으로" class="btn" onclick="location.href='/demo/member/main'">
</body>