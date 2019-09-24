$(function(){
  $.ajax({
    url:'/Spring0823/posts_list',
    success:function(data){
      for(var i = 0; i < data.length; i++) {
        $html_string = '<tr>';
        $html_string = $html_string + '<td>' + data[i]['idx'] + '</td>';
        $html_string = $html_string + '<td>' + data[i]['title'] + '</td>';
        $html_string = $html_string + '<td>' + data[i]['description'] + '</td>';
        $html_string = $html_string + '<td><a href="/Spring0823/details?idx=' + data[i]['idx']+'"><button class="show_details">상세보기</button></a></td>';
        $html_string = $html_string + '</tr>';
        $('table').append($html_string);
      }
      //  console.log(data);
    }
  });
});

	