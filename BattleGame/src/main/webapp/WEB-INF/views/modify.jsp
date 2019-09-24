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
	<a href="/battle">목록으로</a>
	<form action="modify_data" method="get">
		<input type="hidden" name="idx" value="${idx}" />
		<label>이름</label> <input type="text" placeholder="이름입력" name="name" value="${name}" />
		<label>공격력</label> <input type="text" placeholder="공격력" name="attack" value="${attack}" />
		<label>방어력</label> <input type="text" placeholder="방어력" name="shield" value="${shield}" />
		<label>공격확률</label> <input type="text" placeholder="공격확률" name="att_prob" value="${att_prob}" />
		<label>방어확률</label> <input type="text" placeholder="방어확률" name="shld_prob" value="${shld_prob}" />
		<label>HP</label> <input type="text" placeholder="HP" name="hp" value="${hp}" />
		<input type="submit" value="수정" />
	</form>
</body>

</html>
