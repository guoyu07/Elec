<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看图表</title>
    
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
<form name="form1" method="post" action="elecMakeChartAction" >
    <table width="399" border="0" align="center">
      <tr>
        <td width="163"style="font-size: x-large;">月份：</td>
        <td width="226"><input type="text" name="month"style="font-size: x-large;"></td>
        <td colspan="2" align="center"><input type="submit" value="好"style="font-size: x-large;"></td>
      </tr>
      <tr>
        
      </tr>
    </table>
  </form>
  <a href="/Elec/index.jsp" style="font-size: x-large;">返回首页</a><br>
</body>
</html>
