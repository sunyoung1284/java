<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fontawesome-free-5.10.1-web/css/all.min.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin.css?random=98" />
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <script src="${pageContext.request.contextPath}/resources/insert.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>

</head>
<body>
  <header class="top_nav">
	  <a href="/Spring0823"><i class="fas fa-user-check"></i>회원관리</a>
      <a href="/Spring0823/posts">게시판관리</a>
      <a href="gallery.html"><i class="far fa-copy"></i>갤러리관리</a>
  </header>
  <div class="content">
	 <form class="form-horizontal details_section" method="post" action="image_upload" enctype="multipart/form-data" accept-charset="utf-8">
	    <h3 class="title"><input type="text" id="title" name="title" /></h3>
	    <textarea id="de" name="description"></textarea>
	    <input type="file" class="form-control1" id="uploadFile" name="uploadFile" style="border:0px solid black;"/>
	</form>
 
    <div class="button_center_section">
      <a class="submit_button">입력하기</a>
    </div>
  </div>

</body>
</html>
