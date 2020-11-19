<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/smartEditorFolder/workspace/static/js/service/HuskyEZCreator.js"
	charset="utf-8">
</script>

<title>Insert title here</title>
</head>
<body>
	<script>
$(function(){

	$.ajax({
		type:"post"		
		,url:"ajax"		
		,dataType:"json" })
		.done(function(args){	
			 for(var i=0; i < args.length; i++) {
				 $("#tag").append("<option value='"+args[i].no+"'>"+args[i].name+"</option>");
			 }
 			})
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
 
});


function subTagDelete(tag){
	var data = $("#tag").val(); 
		
	$.ajax({
		type:"post"		
		,url: "subAjax"	
		,data:"subTag="+data
		,dataType:"json" })
		.done(function(args){	
			 for(var i=0; i < args.length; i++) {
				 $("#subTag").append("<option value='"+args[i].no+"'>"+args[i].sub_name+"</option>");
			 }
				})
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
	}
</script>
	<form action="estimatIinsert" method="post" name="write_b" enctype="Multipart/form-data">
		<select id="tag" onchange="subTagDelete()" name="tag">
			<option value="">대메뉴명 선택</option>
		</select> <select id="subTag" name="sub_tag">
			<option value="">서브메뉴선택</option>
		</select> <br> <input type="text" placeholder="제목입력" name="title"><br>
		<input type="text" placeholder="짧은설명" name="description">

		<textarea name="content" id="ir1" rows="10" cols="100"></textarea>
		<input type="text" placeholder="예산금액입력" name="budget"> <img
			src=""> 파일첨부 : <input type="file" name="report"> <br>
			마감일 선택:<input type="date" name="work_time">
		<input type="submit" value="저장" id="save">
	</form>

</body>

<script>
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
 sSkinURI: "<%=request.getContextPath()%>/smartEditorFolder/workspace/static/SmartEditor2Skin.html",
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : true,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : true,
						fOnBeforeUnload : function() {

						}
					},
					fOnAppLoad : function() {
						//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
						oEditors.getById["ir1"].exec("PASTE_HTML", [ "" ]);
					},
					fCreator : "createSEditor2"
				});

		//저장버튼 클릭시 form 전송
		$("#save").click(function() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			/* $("#write_b").submit(); */
		});
	});
</script>

</html>