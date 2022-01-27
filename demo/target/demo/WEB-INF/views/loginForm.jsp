<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1> 로그인 </h1>

<fieldset>
    <legend> 로그인 </legend>
    <form action="/demo/member/login" method="post">
        ID : <input type="text" name="userid"><br>
        PW : <input type="password" name = "userpw"><br>
        <input type="submit" value="로그인">
        <input type="button" onclick="location.href='/demo/member/insert'" value="회원가입">
    </form>
</fieldset>