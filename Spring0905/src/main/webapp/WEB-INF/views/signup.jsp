<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome!!!</title>
 <meta name="viewport" content="width=device-width,initial-scale=1.0">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/list.css" />
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script src="${pageContext.request.contextPath}/resources/sign_up.js"></script>
</head>
<body>
<div id="wrap">
    <div class="sign_up_section" >
		ID<br>
		<input type = "text" name ="id" /><br>
		PASSWORD<br>
		<input type="password" name ="password" /><br><br>
		<input type="button" value="가입하기" id="sign_up" />
	</div>
 

</body>
</html>