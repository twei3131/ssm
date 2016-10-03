<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border=1>
<tr>
	<td>用户编号</td>
	<td>用户姓名</td>
	<td>生日</td>
	<td>性别</td>
	<td>地址</td>
</tr>
<c:forEach items="${userVo }" var="users">
<tr>
	<td>${users.id}</td>
	<td>${users.username}</td>
	<td>${users.birthday }</td>
	<td>${users.sex }</td>
	<td>${users.address }</td>
</tr>
</c:forEach>

</table>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script type="text/javascript">
	var baseurl = '${pageContext.request.contextPath }';
	$.post(baseurl+"/items/getUsers.action",function(data){
		var objs = JSON.parse(data);
		var i = 0;
		$.each(objs,function(){
			if(objs[i].sex == 1){
				objs.sex = 'male';
			}else{
				objs[i].sex = 'female';
			}
			i++;
		});
		alert(JSON.stringify(objs));
	});
</script>
</body>
</html>