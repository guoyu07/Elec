<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电费输入</title>
    
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
  <form name="form1" method="post" action="elecRegistPastAction">
    <table width="500" border="0" align="center">
      <tr>
        <td width="250" style="font-size: x-large;">日期</td>
        <td width="226"><input type="text" name="date" style="font-size: xx-large;" value="2013"></td>
        
      </tr>
      <tr>
        <td width="250" style="font-size: x-large;">电量</td>
        <td width="226"><input type="text" name="elecnum" style="font-size: xx-large;"></td>
        <td colspan="2" align="center"><input type="submit" value="好" style="font-size: x-large;"></td>
      </tr>
    </table>
  </form>
  <a href="/Elec/index.jsp" style="font-size: x-large;">返回首页</a><br>
  </body>
</html>
