<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="blogPost.DbManagement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="blogPost.Library"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="readLibrary" method="get">

<input type="submit" value="click">
</form>
<%
	
	DbManagement db = new DbManagement();
	Connection conn = db.getConnection();
	
	
	if(conn == null){
		out.print("connection failed");
	} else {
		
Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from libraries");
    	ArrayList libraryList = new ArrayList();
    	while(rs.next())
    		{
        		Library lb= new Library();
        
        		lb.setId(rs.getInt(1));
        		lb.setAddress(rs.getString(2));
        		lb.setName(rs.getString(3));
        		lb.setPhone(rs.getString(4));
        
        		libraryList.add(lb);
        		
 
        		
        		//out.println(lb.getAddress() +" "+ lb.getName()+ " "+ lb.getPhone()+"<br>");
			}
    	
	}
		
		
%>
</body>
</html>