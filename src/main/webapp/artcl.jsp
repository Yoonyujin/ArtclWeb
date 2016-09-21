<%@page import="java.util.List"%>
<%@page import="net.delight.vo.ArtclVO"%>
<%@page import="net.delight.dao.ArtclDaoImpl"%>
<%@page import="net.delight.dao.ArtclDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArtclDao dao = new ArtclDaoImpl();
	List<ArtclVO> artcls = dao.getArtclList();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ARTCL</h1>
	<hr/>
	
	
		<table style="width: 100%; border-collapse: collapse; border: 1px solid #000000; background-color: #CCCCCC;">
			<tr style="text-align: center;">
				<td>ARTCL_ID</td>
				<td>Subject</td>
				<td>Content</td>
				<td>CreateDate</td>
			</tr>

<%
	int artclsSize = artcls.size();
	ArtclVO artclVO = null;
	for(int i = 0; i< artclsSize; i++) {
		artclVO = artcls.get(i);
%>		
		
			<tr>
				<td><%= artclVO.getArtclId() %></td>
				<td><%= artclVO.getSubject() %></td>
				<td><%= artclVO.getContent() %></td>
				<td><%= artclVO.getCreateDate() %></td>
			</tr>
<% } %>
	</table>
	
</body>
</html>