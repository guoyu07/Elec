<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
  <script type="text/javascript">
  	function test() {
  		
  		var num = document.getElementById("elecnum").value;
  		alert("Hello"+num);
  	}
  </script>
  <body>
  <form name="form1" method="post" action="elecRegistAction">
    <table width="500" border="0" align="center">
      <tr>
        <td width="250" style="font-size: x-large;">今日电量</td>
        <td width="226"><input type="text" name="elecnum" style="font-size: xx-large;" onblur="test()"></td>
        <td colspan="2" align="center"><input type="submit" value="好" style="font-size: x-large;"></td>
        
      </tr>
      <tr>
        <td width="250" style="font-size: x-large;">今日充值</td>
        <td width="226"><input type="text" name="inputelec" style="font-size: xx-large;" ></td>
      </tr>
    </table>
  </form>
  <a href="/Elec/index.jsp" style="font-size: x-large;">返回首页</a><br>
  <s:debug></s:debug>
  </body>
</html>
