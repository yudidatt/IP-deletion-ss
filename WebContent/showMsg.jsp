<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.shieldsquare.model.IPDelete"%>
    <%@page language="java" import="java.util.*"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<% ArrayList<IPDelete> ipDList= (ArrayList<IPDelete>)request.getAttribute("ip_delete");
	String str="Empty";
	
	for (IPDelete ipD : ipDList) {	
		if(ipD!=null){
	%>
	
<h3><%out.print("Total Request is__"+ipD.getTotal_count());%></h3>
<h3><%out.print(ipD.getUpdateMsg());%></h3>	
	


<%}} %>

</body>
</html>