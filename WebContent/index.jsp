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

$(function(){
	query();
})

function query(){
$.ajax({
	async:false,
	cache:false,
	type:"post",
	url:"aja?opt=query",
	dataType:"json",
	error:function()
	{
         alert("请求失败！");
	},
	success:function(data)
	{
		var trs="<tr><th>学生编号</th><th>学生姓名</th><th>密码</th><th>学号</th>";
		$.each(data,function(i,v){
			trs+="<td>"+ v.stuid +"</td>";
			trs+="<td>"+ v.name +"</td>";
			trs+="<td>"+ v.pwd +"</td>";
			trs+="<td>"+ v.code +"</td>";
			trs+="</tr>";
		});
		$("#stu").append(trs);
	}
});
}

</script>


<body>
   <table id="stu" border="1"> 
   </table> 
   <a href="add.jsp">添加</a>
</body>
</html>