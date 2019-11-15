$(document).on('click','#insertBtn',function(event) {	
	$.ajax({
		url:'/Spring1010/insert',
		data: {},
		success:function(data){
			console.log("성공")
		}
	});	
});
	
	


