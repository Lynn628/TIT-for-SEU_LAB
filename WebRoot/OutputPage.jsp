<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>输出页面</title>
		<link rel="stylesheet" href="PluginUnit/jquery-ui-1.10.3/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="PluginUnit/jquery-ui-1.10.3/demos/demos.css">
		<link rel="stylesheet" href="css/InputPage.css">
		<script type="text/javascript" src="PluginUnit/jquery-ui-1.10.3/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="PluginUnit/jquery-ui-1.10.3/ui/jquery-ui.js"></script>
		<script type="text/javascript" src="javascript/InputPage.js"></script>
		<script type="text/javascript">
			/*
			*暂时先假设这些数据
			*/
			var questionCnt = 2;
			//var atomCnt = 0;
			//var solutionCnt = 0; 
			var output = new Array(questionCnt);
			output[0] = {
					question_type:[3,6],
					img:["C:\\Users\\Public\\Pictures\\Sample Pictures\\沙漠.jpg"],
					question:{	content:"这是题目内容",
								answer:"这是题目答案",
								relatedQuestionId:"这是题目对应的题干id"},
					atom:[
							{
								nlDescription:"原子知识点1自然语言描述",
								formalDescription:"原子知识点1形式化语言描述",
								type:"原子知识点1类型",
								source:"原子知识点1来源"
							},
							{
								nlDescription:"原子知识点2自然语言描述",
								formalDescription:"原子知识点2形式化语言描述",
								type:"原子知识点2类型",
								source:"原子知识点2来源"
							} 
					   	],
					solution:[
					        {
					        	nlDescription:"解题思路自然语言描述",
					        	formalDescription:"解题思路形式化描述"
					        }
					          ]
			};
			output[1] = {
					question_type:[4,7],
					img:["C:\\Users\\Public\\Pictures\\Sample Pictures\\菊花.jpg"],
					question:{	content:"这是题目内容",
								answer:"这是题目答案",
								relatedQuestionId:"这是题目对应的题干id"},
					atom:[
							{
								nlDescription:"原子知识点3自然语言描述",
								formalDescription:"原子知识点3形式化语言描述",
								type:"原子知识点3类型",
								source:"原子知识点3来源"
							},
							{
								nlDescription:"原子知识点4自然语言描述",
								formalDescription:"原子知识点4形式化语言描述",
								type:"原子知识点4类型",
								source:"原子知识点4来源"
							} 
					   	],
					solution:[
					        {
					        	nlDescription:"解题思路自然语言描述",
					        	formalDescription:"解题思路形式化描述"
					        }
					          ]
			};
		</script>
	</head>
	
	<body>
		<div class="wrapper">
		<form id="Input" enctype="multipart/form-data" action="${pageContext.request.contextPath}/input1.action" method="post">
			<table class="wrapper2" id="wrapper2">
			<s:iterator value="OutModelList">
				<tr class="labelName">
					<td>题型</td>
				</tr>
				<tr>
					<td>${question_type}</td>
				</tr>
				<tr class="labelName">
					<td>题干</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="5" name="output[0].question.content" readonly>${question.content }</textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>原子知识点</td>
				</tr>
				<tr class="contentArea">
					<td>
						<div class="atomKnowledge-contain" class="ui-widget">
							<table id="atomKnowledges_0" class="ui-widget ui-widget-content">
								<thead>
									<tr class="ui-widget-header">
										<th style="width:30%">自然语言描述</th>
										<th style="width:40%">形式化语言描述</th>
										<th style="width:15%">类型</th>
										<th style="width:15%">来源</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td style="width:30%">${atom[0].nlDescription}</td>
										<td style="width:40%"><pre>${atom[0].formalDescription}</pre></td>
										<td style="width:15%">${atom[0].type}</td>
										<td style="width:15%">${atom[0].source}</td>
									</tr>
									<!-- tr>
										<td style="width:30%">${output[0].atom[1].nlDescription}</td>
										<td style="width:40%"><pre>output[0].atom[1].formalDescription</pre></td>
										<td style="width:15%">{$output[0].atom[1].type}</td>
										<td style="width:15%">{$output[0].atom[1].source}</td>
									</tr-->
								</tbody>
							</table>
						</div>
					</td>
				</tr>
				<tr class="labelName">
					<td>自然语言描述解题思路</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="10" name="output[0].solution[0].nlDescription" readonly>${solution[0].nlDescription }</textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>形式化语言描述解题思路</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="10"  name="output[0].solution[0].formalDescription" readonly>${solution[0].formalDescription }</textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>图片</td>
				</tr>
				<tr>
					<td>
						<img id="image_0" src=${output[0].img[0]} />${img[0]}
					</td>
				</tr>
				<tr class="labelName">
					<td>答案</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="5" name="output[0].question.answer" readonly>${question.answer }</textarea>
					</td>
				</tr>
				</s:iterator>
				
				<!-- 
				<tr>
					<td>
						<hr size=5 color=#5151A2/></td></tr><tr class="labelName">
					</td>
				</tr>
				
				<tr class="labelName">
					<td>子问题1</td>
				</tr>
				<tr class="labelName">
					<td>题型</td>
				</tr>
				<tr>
					<td>
					$&nbsp;{output[1].question_type[0] } &nbsp;&nbsp; $&nbsp;{output[1].question_type[1] }
					</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="5" name="output[0].question.content" readonly>$&nbsp;{output[1].question.content }</textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>原子知识点</td>
				</tr>
				<tr class="contentArea">
					<td>
						<div class="atomKnowledge-contain" class="ui-widget">
							<table id="atomKnowledges_0" class="ui-widget ui-widget-content">
								<thead>
									<tr class="ui-widget-header">
										<th style="width:30%">自然语言描述</th>
										<th style="width:40%">形式化语言描述</th>
										<th style="width:15%">类型</th>
										<th style="width:15%">来源</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td style="width:30%">$&nbsp;{output[1].atom[0].nlDescription}</td>
										<td style="width:40%"><pre>$&nbsp;{output[1].atom[0].formalDescription}</pre></td>
										<td style="width:15%">$&nbsp;{output[1].atom[0].type}</td>
										<td style="width:15%">$&nbsp;{output[1].atom[0].source}</td>
									</tr>
									<tr>
										<td style="width:30%">$&nbsp;{output[1].atom[1].nlDescription}</td>
										<td style="width:40%"><pre>$&nbsp;{output[1].atom[1].formalDescription}</pre></td>
										<td style="width:15%">$&nbsp;{output[1].atom[1].type}</td>
										<td style="width:15%">$&nbsp;{output[1].atom[1].source}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</td>
				</tr>
				<tr class="labelName">
					<td>自然语言描述解题思路</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="10" name="output[0].solution[0].nlDescription" readonly>$&nbsp;{output[1].solution[0].nlDescription }</textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>形式化语言描述解题思路</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="10"  name="output[0].solution[0].formalDescription" readonly>$&nbsp;{output[1].solution[0].formalDescription }</textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>图片</td>
				</tr>
				<tr>
					<td>
						<img id="image_0" src=${output[0].img[0]} />$&nbsp;${output[1].img[0]}
					</td>
				</tr>
				<tr class="labelName">
					<td>答案</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="5" name="output[0].question.answer" readonly>$&nbsp;{output[1].question.answer }</textarea>
					</td>
				</tr>
				-->
			</table>
			<a href="overview.action"><input id="submitBtn" value="返回" class="button submit" type="button" /></a>
		</form>
		</div>
		 
	</body>
</html>