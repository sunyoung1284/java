$(function(){
	$.ajax({
		url:'/Spring0905/list_index',
		success:function(data){
			for(var i=0; i<data.length; i++){
				$html_string = '<li>';
				$html_string = $html_string + '<h2>'+ data[i]['idx']+'</h2>'
				$html_string = $html_string + '<h3>'+ data[i]['title']+'</h3>'
				$html_string = $html_string + '<br>'+'<h4>'+data[i]['description']+'</h4>'+'<br>';
				$html_string = $html_string + '<h5>'+'<button class="mod_row">수정하기</button><button class="mod_done">수정완료</button>'+'</h5>'+'</li>';
				
				$('.list').append($html_string);
			}
		}
	
	});
});

$(document).on('click','.top_button',function(event) {
	var html_string = '<li>'+'<input type = "text" id="title">'+'<br>'+'<input type = "text" id="text">'+ '<button class="input_done">입력완료</button>'+ '</li>'
	$('.list').append(html_string); //제일 위에 추가 하는게 prepend 
	'<button class="input_done">입력완료</button>'
});

$(document).on('click','.input_done',function(event) {
	var title = $("#title").val();
	var description = $("#text").val();
	$.ajax({
		url:'/Spring0905/insert',
		data: {'title' : title, 'description': description},
		success:function(data){
			location.reload();
		}
	});	
});
$(document).on('click','.mod_row',function(event) {
	  var row = $(this).parents('li');
	  var h30 = row.find('h3').eq(0);
	  var h40 = row.find('h4').eq(0);

	  var h30_string = h30.text();
	  var h40_string = h40.text();
	
	  var input_tag1 = $('<input type="text" />');
	  h40.html(input_tag1);
	  input_tag1.val(h40_string);

	})
	
$(document).on('click','.mod_done',function(event) {
	var idx =$(this).parents('li').find('h2').eq(0).text();
	console.log(idx)
	var title = $(this).parents('li').find('h3').eq(0).text();
	console.log(title)
	var description = $(this).parents('li').find('h4').eq(0).find('input').val();
	$.ajax({
		url:'/Spring0905/modify',
		data: {'idx': idx, 'title' : title, 'description': description},
		success:function(data){
			location.reload();
		}
	});	
});
	
	


