<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问题列表</title>
	<link rel="stylesheet" href="PluginUnit/jquery-ui-1.10.3/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="PluginUnit/jquery-ui-1.10.3/demos/demos.css">
	<script type="text/javascript" src="PluginUnit/jquery-ui-1.10.3/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="PluginUnit/jquery-ui-1.10.3/ui/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css" href="css/overview.css">

  </head>
  
  <body>
    <div class="wrapper">
    	<table class="ui-widget ui-widget-content">
    		<tr class="ui-widget-header">
    			<th style="width:10%">序号</th>
    			<th style="width:60%">问题内容</th>
    			<th style="width:20%">题型</th>
    			<th style="width:10%">查看</th>
    		</tr>
    		<!-- 循环输出问题列表 -->
    		<s:iterator value="overview">
    			<tr>
    				<td>${queId}</td>
    				<td>${content}</td>
    				<td>${question_type}</td>
    				<td><a href="${pageContext.request.contextPath}/output.action?queId=${queId}" target="_Blank"><input type="button" value="查看" /></a></td>
    			</tr>
    		</s:iterator>
    	</table>
    </div>
  </body>
</html>
