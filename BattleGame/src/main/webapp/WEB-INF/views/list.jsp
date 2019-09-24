<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>DataBase Sample</title>

<link href="${pageContext.request.contextPath}/resources/list.css"
	rel="stylesheet" />
</head>

<body>
	<a href="/battle/input">캐릭터 생성하기</a>
	<form action="game_start" method="get">
		<input type="submit" class="btn" value="게임스타트" />
		<table>
			<tr>
				<th>선택</th>
				<th>idx</th>
				<th>이름</th>
				<th>공격력</th>
				<th>방어력</th>
				<th>공격확률</th>
				<th>방어확률</th>
				<th>HP</th>
				<th></th>
				<th></th>
			</tr>
			${select_result}
		</table>
	</form>
</body>

</html>
