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
	<form action="input_data" method="get">
		<label>이름</label><input type="text" placeholder="이름" name="name" />
		<label>공격력</label><input type="text" placeholder="공격력" name="attack" />
		<label>방어력</label><input type="text" placeholder="방어력" name="shield" />
		<label>공격확률</label><input type="text" placeholder="공격확률" name="att_prob" />
		<label>방어확률</label><input type="text" placeholder="방어확률" name="shld_prob" />
		<label>HP</label><input type="text" placeholder="HP" name="hp" />
		<input type="submit" value="캐릭터 생성" />
	</form>
</body>

</html>
