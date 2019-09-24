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
	<form action="PvP" method="get">
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<th>이름</th>
							<th>공격력</th>
							<th>방어력</th>
							<th>공격확률</th>
							<th>방어확률</th>
							<th>HP</th>
						</tr>
						${selected_user_1}
					</table>
				</td>
				<td>
					<table>
						<tr>
							<th>이름</th>
							<th>공격력</th>
							<th>방어력</th>
							<th>공격확률</th>
							<th>방어확률</th>
							<th>HP</th>
						</tr>
						${selected_user_2}
					</table>
				</td>
			</tr>
		</table>
		<input type="submit" class="btn" value="턴 진행" />
	</form>
	<p>
	<div id="resultArea">${battle_proceeding}</div>
	
</body>

</html>
