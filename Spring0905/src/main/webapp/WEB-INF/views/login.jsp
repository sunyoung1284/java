<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
 <meta name="viewport" content="width=device-width,initial-scale=1.0">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/list.css" />
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script src="${pageContext.request.contextPath}/resources/login.js"></script>
</head>
<body>
	<div class="image">
          <img src="${pageContext.request.contextPath}/resources/flower.jpg" alt="#" ">
    </div>
    
    
	<form action = "input_password" method="post" class="loginpage" >
		ID<br>
		<input type = "text" name ="id" /><br>
		PASSWORD<br>
		<input type="password" name ="password" /><br><br>
		<input type="submit" value="로그인" />
		<input type="button" value="회원가입" id="sign_up" />
	</form>
	
	

</body>
</html>