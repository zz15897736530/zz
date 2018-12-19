<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function add(){
$.ajax({
	async:false,
	cache:false,
	type:"post",
	url:"aja?opt=add",
	data:$('#form').serialize(),
	dataType:"text",
	error:function(){
		alert("请求失败！");
	},
	success:function(data){
		alert(data);
		if(data=="true"){
			location.href='index.jsp';
		}else{
			alert("添加失败");
		}
	}
});
}



</script>


<body>
<form id="form">
学生姓名：<input type="text" name="name">
密码：<input type="text" name="pwd">
学号：<input type="text" name="code">
<input type="submit" onclick="add()" value="提交">

</form>
</body>
</html>