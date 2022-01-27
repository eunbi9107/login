<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 로그인 처리 -> 로그인 x (로그인페이지 이동)
String id = (String) session.getAttribute("id");
if( id == null ){
	 response.sendRedirect("/demo/member/main");
}
%> 
<fieldset>
	<legend>회원탈퇴</legend>
	<form action="/demo/member/delete" method="post">
	<!-- input타입중 hidden은 화면에 있는 해당 input태그를 숨겨서 정보 전달   -->
		아이디 : <input type="text" name="userid" value="<%=id %>" readonly><br>
		비밀번호 : <input type="password" name="userpw"><br>
		<input type="submit" class="btn" value="탈퇴하기">
		<input type="button" class="btn" value="뒤로가기" onclick="location.href='/demo/member/main'">
	</form>
</fieldset>