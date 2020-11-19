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

	<form action="auoteInsert" method="post" name="write_b" enctype="Multipart/form-data">
		<input type="hidden" name="post_no" value="${post_no}">
		<textarea name="detail" id="ir1" rows="10" cols="100"></textarea>
		<input type="text" placeholder="금액입력" name="final_price"> 
		<img src=""> <br>
			파일첨부 : <input type="file" name="report"> <br>
	<!-- 	파일첨부 : <input type="file" name="report"> <br>
			파일첨부 : <input type="file" name="report"> <br>
 			웅이 다중파일 업로드랑 합치기로함 2개 주석처리해둠.
		-->
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