<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${conPath }/member/login.do" method="post">
<table>
<tr>
    <th>아이디</th><td><input type="text" name="id" value="${id}"></td>
</tr>
<tr>
    <th>비밀번호</th><td><input type="password" name="password" value="${password}"></td>
</tr>
</table>
<button>로그인</button>
</form>

</body>
</html>