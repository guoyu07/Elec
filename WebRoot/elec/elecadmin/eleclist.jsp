<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>�����б�</title>

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
	function aler() {
		
		var date = document.getElementById("elecs");
		document.write(date.value);
		alert("ȷ��Ҫɾ����"+date.value);
	}
</script>
<body>

	<table width="500" border="1" align="center"
		style="font-size: x-large;">
		<tr>
			
			<td width="100">��</td>
			<td width="100">��</td>
			<td width="100">��</td>
			<td width="350">ʣ�����</td>
			<td width="200">��������</td>
			<td width="200">���ճ�ֵ</td>
		</tr>
		<s:iterator value="elecs">
			<tr>
				<td width="100"><s:property value="year" />
				</td>
				<td width="100"><s:property value="month" />
				</td>
				<td width="100"><s:property value="day" />
				</td>
				<td width="350"><s:property value="elecnum" />��
				</td>
				<td width="350"><s:property value="used" />
				</td>
				<td width="350"><s:property value="inputelec" />��
				</td>
				<td width="200"><a
					href="<s:url action="elecDeleteAction"> 
    		<s:param name="date" value="date"/>
    	</s:url>" onclick="aler()">ɾ��</a>
				</td>
			</tr>
		</s:iterator>
		<a href="/Elec/index.jsp" style="font-size: x-large;">������ҳ</a>
		<br>
	</table>
	<s:debug></s:debug>
</body>
</html>
