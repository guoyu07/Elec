<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<%-- 日期: <s:property value="elec.date"/><br>
    	电费: <s:property value="elec.elecnum"/><br>
    	当天耗電: <s:property value="elec.used"/><br>
    	当天充值: <s:property value="elec.inputelec"/><br> --%>
    	<s:property value="result"/>
    <a href="/Elec/index.jsp" style="font-size: x-large;">返回首页</a><br>
    <s:debug></s:debug>
  </body>
</html>
