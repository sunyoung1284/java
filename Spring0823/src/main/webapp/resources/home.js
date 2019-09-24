//$(function(){
//	alert(1);
//});

//$(document).on('click','.info',function(event){
//	$.ajax({
//		url:'/Spring0823/info',
//		success:function(data){
//			$('p').html(data['version']);
////			$('p').html(JSON.stringify(data));
//		}
//	});
//});
$(document).on('click','.info',function(event){
	$.ajax({
		url:'/Spring0823/user_list',
		success:function(data){
//			$('p').html(data['version']);
			$('p').html(JSON.stringify(data));
		}
	});
});