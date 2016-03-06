<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.InputStream, java.io.BufferedReader" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fileUploadResult jsp</title>
</head>
<body>

<%
 /*
 InputStream is = request.getInputStream();
 BufferedReader br = new BufferedReader(new InputStreamReader(is));
 
 String buffer = null;
 while(null != (buffer = br.readLine())) {
	 out.print(buffer + "<br>");
 }
 
 br.close();
 */
 %>
 username: ${requestScope.username }<br>
 file1: ${requestScope.file }<br>
 file2: ${requestScope.file2 }

</body>
</html>