<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>데이터 입력</title>
<link href="${pageContext.request.contextPath}/resources/input.css"
	rel="stylesheet" />
</head>

<body>
	<a href="/spring5">목록으로</a>
	
		<label>ID</label> <input type="text" placeholder="ID입력" name="id" />
		<label>PASSWORD</label> <input type="text" placeholder="PASSWORD입력" name="password" />
		<input type="button" value="입력 완료" />
	
	
</body>

</html>
