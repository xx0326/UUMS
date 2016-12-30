<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdn.bootcss.com/layer/3.0.1/layer.min.js"></script>

<script type="text/javascript">
function edit(i) {
	layer.open({
		  type: 2,
		  title: '编辑部门名称',
		  shadeClose: true,
		  shade: 0.2,
		  area: ['400px', '100px'],
		  content: 'preSave.do?id='+i,
		  end: function(index){ 
			  location.reload();
			}
		}); 
}
</script>

</head>
<body>
<div class="panel panel-default">
  <div class="panel-heading">${actionName}</div>
  <div class="panel-body">
    
  

<div>
	<table class="table table-hover table-striped" style="margin-bottom: 0px;">
		<thead>
		<tr>
	  	<th>部门编号</th>
	  	<th>部门名称</th>
	  	<th>操作</th>
	  	</tr>
	  	</thead>
	  	
	  	<c:forEach var="item" items="${depaList }" varStatus="status">
	  	<tr>
		  	<td>${item.id}</td>
		  	<td>${item.name}</td>
		  	<td> 
			  	<button type="button" class="btn btn-primary btn-xs" onclick="edit(${item.id});">编辑</button>
		  	</td>
	  	</tr>
	  	</c:forEach>
	</table>
</div>

	</div>
</div>
</body>
</html>