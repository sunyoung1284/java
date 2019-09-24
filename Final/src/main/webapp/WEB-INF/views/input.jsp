<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<title>rune</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/input.css" />
</head>

<body>
  <div class="wrap">
    <div class="input_content">
      <div class="logo_sec">
        <h3>데이터입력</h3>
      </div>
      <form class="input_sec" action="inputData">
        <label>이름</label>
        <input type="text" placeholder="이름" name="name"/>
        <label>중간고사점수</label>
        <input type="number" placeholder="중간고사점수" name="middleScore"/>
        <label>기말고사점수</label>
        <input type="number" placeholder="기말고사점수"  name="finalScore"/>
        <input type="submit" class="input_btn" value="입력완료" />
      </form>
    </div>
  </div>
</body>

</html>