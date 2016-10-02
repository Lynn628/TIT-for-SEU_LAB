<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 导入Struts2标签库 -->
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎页面</title>
	<script type="text/javascript">
		//$(function(){
			//window.location.href = "./CountAction.do";
			//window.location.href = "count.action";
		//})
	</script>

  </head>
  
  <body>
  	<div style="text-align:center;"><h1>推理平台测试实例库</h1></div>
  	<table align="center" width="50%" border="1">
  		<tr>
  			<td>
  			&nbsp;&nbsp;&nbsp;&nbsp;该测试实例库用于存储历年高考题及每道题对应的解题思路。
  			目前该测试实例库共录入了：<i><b><s:property value="countModel.countTotal"/></b></i>道题目，<!-- ${countModel.countTotal }-->
	   		其中包括：<i><b>${countModel.countHistory }</b></i>道历史题目，<!-- s:property value="outModel.atom[0].id"/-->
	    	<i><b>${countModel.countGeo }</b></i>道地理题目。<!-- s:property value="outModel.solution[0].id"/-->
	    	</td>
	    </tr>
	    <tr align="center">
	    	<td>
	    		<a href="InputPage.jsp" target="_Blank">录入高考题及其解题思路</a>&nbsp;&nbsp;&nbsp;&nbsp;
	    		<a href="overview.action" target="_Blank">查看已录入题目</a>
	    	</td>
	    </tr>
    </table>
  </body>
</html>
