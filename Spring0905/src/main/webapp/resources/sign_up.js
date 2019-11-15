$(document).on('click','#sign_up',function(event) {
	var id = $(this).parents('div').find('input').eq(0).val();
	var password = $(this).parents('div').find('input').eq(1).val();
	var admin = 1;

	  console.log(id);
	  $.ajax({
			url:'/Spring0905/user_insert',
			data: {'id' : id, 'password': password, 'admin': admin},
			success:function(data){
				alert("회원가입완료!")
			}
		});
	})