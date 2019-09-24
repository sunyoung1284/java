var oEditors = [];
$(function(){
  $.ajax({
    url:'/Spring0823/posts_details',
    data:{'idx': idx},
    success:function(data){
      $('h3').text(data['title']);
      $('#idx').val(idx);
      $('#title').val(data['title']);
      $('#de').html(data['description']);
      nhn.husky.EZCreator.createInIFrame({
       oAppRef: oEditors,
       elPlaceHolder: "de",
       sSkinURI: "resources/smarteditor/SmartEditor2Skin.html",
       fCreator: "createSEditor2"
      });
     
      //  console.log(data);
    }
  });
});


$(document).on('click','.submit_button',function(event) {
	 oEditors.getById["de"].exec("UPDATE_CONTENTS_FIELD", []);
//	 var title = $('h3').text();
//	 var description = $('#de').val();
//	 $.ajax({
//			url:'/Spring0823/posts_mod',
//			data: {'idx': idx, 'title' : title, 'description': description},
//			success:function(data){
//				location.href="/Spring0823/posts"
//				
//			}
//		});	
	 $('.details_section').submit()
});


