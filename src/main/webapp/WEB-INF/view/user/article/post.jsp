<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
    
   
	<script
	src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js"></script>

	
	    
    新建文章   
<form>
  
  <div class="form-group">
    <label for="title">标题</label>
    <input type="text" class="form-control" id="title" name="title"  placeholder="请输入文章标题">
  </div>
  
  <div class="form-group">
    <label for="channel">栏目</label>
    <select class="form-control" id="channel" name="channelId">
      <option value="0">请选择</option>
      <c:forEach items="${channels}" var="cat">
      		<option value="${cat.id}">${cat.name}</option>
      </c:forEach>
      
      
    </select>
  </div>
  
  <div class="form-group">
    <label for="category">分类</label>
    <select class="form-control" id="category" name="categoryId">
    </select>
  </div>
  
 <div class="form-group">
    <label for="exampleFormControlFile1">文章图片</label>
    <input type="file" class="form-control-file" id="file" name="file">
  </div>
  
  <div class="form-group">
    <label for="content1">文章内容</label>
    <textarea class="form-control" id="content1" name="content1" rows="20" cols="300"></textarea>
  </div>
  
  <div class="form-group">
  	<input type="button" class="btn btn-primary mb-2" value="提交">
  </div> 
</form>
<script>
	$("#channel").change(function(){
		console.log("选中的数据是 " + $("#channel").val())
		$.post("/user/getCategoris",{cid:$("#channel").val()},
				function(data){
					$("#category").empty();
					for ( var i in data) {
						$("#category").append("<option value='"+ data[i].id+"'>"+data[i].name+"</option>")	
					}
		})
	})
	
	
</script>

<script>
		KindEditor.ready(function(K) {
			window.editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/resource/kindeditor/plugins/code/prettify.css',
				uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		function query(){
		alert(editor1.html())
			//alert( $("[name='content1']").attr("src"))
		} 
		
	</script>
