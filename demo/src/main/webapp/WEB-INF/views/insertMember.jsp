<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>회원가입 페이지</h1>

<fieldset>
    <legend>회원가입</legend>
    <form action="/demo/member/insert" method="post">
        ID : <input type="text" name="userid"> <br>
        PW : <input type="password" name="userpw"> <br>
        NAME : <input type="text" name="username"> <br>
        EMAILE : <input type="text" name="useremail"><br>
        <input type="radio" name="adminCk" value="1" checked="checked"> user
        <input type="radio" name="adminCk" value="2" > admin <br>
        <input type="submit" value="회원가입">

    </form>
</fieldset>