<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
<%
//1. 로그인세션제어(관리자는 제외)
String id = (String) session.getAttribute("id");//다운캐스팅
int isAdmin = (int) session.getAttribute("isAdmin");
if(id == null || isAdmin != 2){ //순서바뀌면 에러발생하므로 항상 null 먼저 비교할 것
	response.sendRedirect("/demo/member/main");
}
%>
<h2 style="text-align: center;">회원목록</h2>
<table border="1" style="border-collapse: collapse">
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>회원여부</td>
		<td>회원가입일</td>
		<td>최근회원정보수정일</td>
	</tr>
	<c:forEach items="${memberList }" var="mb">	
		<tr>
			<td><c:out value="${mb.userid }"></c:out></td>
			<td><c:out value="${mb.userpw }"></c:out></td>
			<td><c:out value="${mb.username }"></c:out></td>
			<td><c:out value="${mb.useremail }"></c:out></td>
			<td><c:out value="${mb.adminCk}"></c:out></td>
			<td><c:out value="${mb.regdate }"></c:out></td>
			<td><c:out value="${mb.updatedate }"></c:out></td>
		</tr>
	</c:forEach>
</table>
<input type="button" value="메인으로" class="btn" onclick="location.href='/demo/member/main'">

</body>