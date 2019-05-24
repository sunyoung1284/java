<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<P>  Query result is ${query_result}. </P>
	<input type="text" placeholder="중간고사">
	<input type="text" placeholder="기말고사">
	<input type="button" value="입력">
	
</body>
</html>
