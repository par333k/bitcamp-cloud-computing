<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="top">
		    <a href="${conPath }/member/insertForm.do">회원가입</a>
			<a href="${conPath }/member/memberlogin.do">로그인</a>
			<a href="${conPath }/member/Logout.do">로그아웃</a>
		</div>
		<div id="left"></div>
		<div id="right"></div>
	</div>
</body>
</html>