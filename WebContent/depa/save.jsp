<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/depa/save.do" method="post">
<span style="display: none;"><input type="text" name="id" value="${depa.id}"/></span>
<p style="text-align: center;"><input type="text" name="name" value="${depa.name}"/><input type="submit"/></p>
</form>
</body>
</html>