<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test1</title>
</head>
<body>
<h1>test1.jsp 실행</h1>
</body>
</html>
<%
// 다른 도메인에서 이 JSP의 결과를 가져가도록 허락한다
response.setHeader("Access-Control-Allow-Origin", "*");
%>