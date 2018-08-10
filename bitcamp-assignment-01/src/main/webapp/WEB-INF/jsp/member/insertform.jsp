<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 등록</title>

</head>
<body>

<h1>멤버 등록</h1>
<form action="${conPath }/member/insert.do" method="post">
<table border='1'>
<tr>
    <th>아이디</th><td><input type="text" name="id"></td>
</tr>
<tr>
    <th>나이</th><td><input type="number" name="age"></td>
</tr>
<tr>
    <th>이메일</th><td><input type="email" name="email"></td>
</tr>
<tr>
    <th>암호</th><td><input type="password" name="password"></td>
</tr>

</table>
<button>등록</button>

</form>

</body>
</html>