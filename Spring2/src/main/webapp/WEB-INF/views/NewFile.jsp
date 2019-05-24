<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>	
	form {margin: 0 auto; padding:10px; background:#eee;}
	label {display: inline-block; width:200px; text-align: center;}
	input {display: inline-block; width:300px;}
	form span{display: block; padding:10px;}
	input[type="submit"] {display: inline-block; margin: 5px 0px 0px 140px;}
</style>
<body>
	<form action="/spring2/input_data" method="get">
		<span><label>이름 </label><input type="text" name="name"> <br /></span>
		<span><label>중간고사 점수 </label><input type="number" name="middle_score"> <br /></span>
		<span><label>기말고사 점수 </label><input type="number" name="final_score"> <br /></span>
		<input type ="submit" value="데이터 전송">
	</form>
</body>
<script src="http://code.jquery.com/jquery-latest.min.js"> </script>
<script>

</script>
</html>


