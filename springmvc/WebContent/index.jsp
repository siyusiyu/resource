<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

function getjson(){
	
	
	
	$.ajax({
		url:"json",
		dataType:"text",
		success:function(result){
			$("#content").html(result);
		},
		error:function(msg){
			alert(msg);
		},
		complete:function(){
			//alert("执行结束");
		}
		
	}); 
};



</script>


</head>
<body>

<a href="helloworld">hello world</a>
<a href ="views/html/index.html" >访问静态资源</a>
<a href = "resource/index.html ";>自定义资源位置</a>
<a href = "views/jsp/index1.html ";>页面1</a>
<a href = "resource/index1.html ";>页面2</a>
<a hreft="script:void(0)" onclick="getjson()" >ajax请求</a>
<div id = "content">


</div>

</body>
</html>