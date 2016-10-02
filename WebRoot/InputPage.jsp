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
		<title>输入页面</title>
		<!-- link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"-->		
		<!--script src="//code.jquery.com/jquery-1.9.1.js"></script-->
		<!-- script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script-->
		<!--link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css"-->
		<link rel="stylesheet" href="PluginUnit/jquery-ui-1.10.3/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="PluginUnit/jquery-ui-1.10.3/demos/demos.css">
		<link rel="stylesheet" href="css/InputPage.css">
		<script type="text/javascript" src="PluginUnit/jquery-ui-1.10.3/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="PluginUnit/jquery-ui-1.10.3/ui/jquery-ui.js"></script>
		<script type="text/javascript" src="javascript/InputPage.js"></script>
	</head>
	
	<body>
		<div class="wrapper">
		<form id="Input" enctype="multipart/form-data" action="${pageContext.request.contextPath}/input1.action" method="post">
			<table class="wrapper2" id="wrapper2">
				<tr class="labelName">
					<td>题型</td>
				</tr>
				<tr>
					<td>
					<div id="cascadeList">
					<div>
						<div>题目类型
							<div>
								<div>科目
									<div>
										<div id="history">历史</div>
										<div id="geography">地理</div>
									</div>
								</div>
								<div>题型
									<div>
										<div id="choice">选择题</div>
										<div id="qa">问答题</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					</div>
					<div id="selectedLabels">
						<table id="labeltable">
							<tr>
								<td>已选择类型：</td>
								<td><input type="button" value="删除" id="deleteLabel"/></td>
							</tr>
						</table>
					</div>
					</td>
				</tr>
				<tr class="labelName">
					<td>题干</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="5" name="input[0].question.content"></textarea>
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
										<th style="width:5%">选择</th>
										<th style="width:30%">自然语言描述</th>
										<th style="width:40%">形式化语言描述</th>
										<th style="width:10%">类型</th>
										<th style="width:10%">来源</th>
										<th style="width:5%">修改</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</td>
				</tr>
				<tr>
							<td>
								<div>
								<table>
								<tr>
								<td>
								<input id="create_atomKnowledge_0" value="新建原子知识点" type="button" class="button" onclick="return create_atomKnowledge();" />
								</td>
								<td>
								<input id="delete_atomKnowledge_0" value="删除原子知识点" type="button" class="button" onclick="return delete_atomKnowledge();" />
								</td>
								<tr>
								</table>
								</div>
							</td>
				</tr>
				<tr class="labelName">
					<td>自然语言描述解题思路</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="10" name="input[0].solution[0].nlDescription"></textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>形式化语言描述解题思路</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="10"  name="input[0].solution[0].formalDescription"></textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>图片</td>
				</tr>
				<tr>
					<td>
						<input id="image_0" name="input[0].img[0]" type="file" />
					</td>
				</tr>
				<tr class="labelName">
					<td>答案</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="5" name="input[0].question.answer"></textarea>
					</td>
				</tr>
				<tr class="labelName">
					<td>备注</td>
				</tr>
				<tr class="contentArea">
					<td>
						<textarea rows="5" name="input[0].question.remark"></textarea>
					</td>
				</tr>
			</table>
			<input id="add_question" value="添加子问题" type="button" class="button" />
			<input id="submitBtn" value="提交" type="submit" class="button submit" />
		</form>
		</div>
		
		
		<div id="new_atomKnowledge" title="新建原子知识点">
			<p class="validateTips">所有的表单字段都是必填的。</p>
				<fieldset>
					<label for="atom_type">类型</label>
					<select name="atom_type" id="atom_type">
						<option value="9">事实</option>
						<option value="10">概念层次</option>
						<option value="11">同义</option>
						<option value="12">近义</option>
						<option value="13">反义</option>
						<option value="14">常识</option>
						<option value="15">时态知识</option>
						<option value="16">信念知识</option>
						<option value="17">不确定知识</option>
					</select>
					
					<label for="atom_nl">自然语言描述</label> 
					<input type="text" name="atom_nl" id="atom_nl" class="text ui-widget-content ui-corner-all"> 
					
					
					<label for="atom_formal_description">形式化语言描述</label>
					<textarea rows="12" name="atom_formal_description" id="atom_formal_description" class="text ui-widget-content ui-corner-all"></textarea>
					
					<label for="atom_source">来源：zhishi.me、freebase、wordnet、百度百科、课本、领域公理等</label>
					<input type="text" name="atom_source" id="atom_source" class="text ui-widget-content ui-corner-all">
					
				</fieldset>
		</div>
		
		<div id="change_atomKnowledge" title="修改原子知识点">
			<p class="validateTips">所有的表单字段都是必填的。</p>
				<fieldset>
					<label for="change_atom_type">类型</label>
					<select name="change_atom_type" id="change_atom_type">
						<option value="9">事实</option>
						<option value="10">概念层次</option>
						<option value="11">同义</option>
						<option value="12">近义</option>
						<option value="13">反义</option>
						<option value="14">常识</option>
						<option value="15">时态知识</option>
						<option value="16">信念知识</option>
						<option value="17">不确定知识</option>q	nn vcxzZ
					</select>
					
					<label for="change_atom_nl">自然语言描述</label> 
					<input type="text" name="change_atom_nl" id="change_atom_nl" class="text ui-widget-content ui-corner-all"> 
					
					
					<label for="change_atom_formal_description">形式化语言描述</label>
					<textarea rows="12" name="change_atom_formal_description" id="change_atom_formal_description" class="text ui-widget-content ui-corner-all"></textarea>
					
					<label for="change_atom_source">来源：zhishi.me、freebase、wordnet、百度百科、课本、领域公理等</label>
					<input type="text" name="change_atom_source" id="change_atom_source" class="text ui-widget-content ui-corner-all">
					
				</fieldset>
		</div>
		
		
	</body>
	<script type="text/javascript">
	var questionCnt = 0;
	var atomCnt = 0;
	var solutionCnt = 0;
	
		    var atom_nl = $( "#atom_nl" ),
		    	atom_fd = $( "#atom_formal_description" ),
		      	atom_type = $( "#atom_type" ),
		      	atom_source = $( "#atom_source" ),
		      	allFields = $( [] ).add( atom_nl ).add( atom_fd ).add( atom_type ).add( atom_source ),
		      	tips = $( ".validateTips" ),
		      	
		      	change_atom_nl = $( "#change_atom_nl" ),
		    	change_atom_fd = $( "#change_atom_formal_description" ),
		      	change_atom_type = $( "#change_atom_type" ),
		      	change_atom_source = $( "#change_atom_source" ),
		      	change_allFields = $( [] ).add( change_atom_nl ).add( change_atom_fd ).add( change_atom_type ).add( change_atom_source ),
		      	change_tips = $( ".validateTips" );
		 
		    function updateTips( t ) {
		      tips
		        .text( t )
		        .addClass( "ui-state-highlight" );
		      setTimeout(function() {
		        tips.removeClass( "ui-state-highlight", 1500 );
		      }, 500 );
		    }
		 
		    function checkLength( o, n ) {
		    	var temp = o.val().replace(/[ ]/g,"");
		    	temp = temp.replace(/[\r\n]/g,"");
		    	
		      if ( !temp ) {
		        o.addClass( "ui-state-error" );
		        //updateTips(  n + " 不能为空。" );
		        return false;
		      } else {
		        return true;
		      }
		    }
		 
		    //添加原子知识点的模态框
		    $( "#new_atomKnowledge" ).dialog({
		      autoOpen: false,
		      height: 550,
		      width: 620,
		      modal: true,
		      buttons: {
		        "添加": function() {
		          var bValid = true;
		          allFields.removeClass( "ui-state-error" );
		 
		          bValid = bValid && checkLength( atom_nl, "自然语言描述" );
		          bValid = bValid && checkLength( atom_fd, "形式化语言描述" );
		          bValid = bValid && checkLength( atom_type, "原子知识点类型" );
		          bValid = bValid && checkLength( atom_source, "原子知识点来源" );
		 
		          if ( bValid ) {
		            $( "#atomKnowledges"+"_"+questionCnt.toString()+ " tbody" ).append( "<tr id=\"tr["+atomCnt.toString()+"]\">" +
		              "<td style=\"width:5%\">"+"<input type='checkbox' name='ckb' />"+"</td>"+
		              
		              "<td style=\"width:30%\">" + atom_nl.val() + "<input type=\"hidden\" name=\"input[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].nlDescription\" value=\"" + atom_nl.val() + "\"/></td>" +
		              "<td style=\"width:40%\"><pre>" + atom_fd.val() + "</pre><input type=\"hidden\" name=\"input[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].formalDescription\" value=\"" + atom_fd.val() + "\"/></td>" +
		              "<td style=\"width:10%\">" + atom_type.find("option:selected").text() + "<input type=\"hidden\" name=\"input[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].type\" value=\"" + atom_type.find("option:selected").val() + "\"/></td>" +
		              "<td style=\"width:10%\">" + atom_source.val() + "<input type=\"hidden\" name=\"input[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].source\" value=\"" + atom_source.val() + "\"/></td>"  + 
		              
		             
		              "<td style=\"width:5%\" id=\"td["+atomCnt.toString()+"]\">"+ "<input type=\"button\" id=\"btnUpd[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].nlDescription\" class='button' value=\"修改\" onclick=\"change_atomKnowledge()\"/></td>"+
		              
		              "</tr>" 
		             );
		            atomCnt += 1;
		            $( this ).dialog( "close" );
		          }
		        },
		        "取消": function() {
		          $( this ).dialog( "close" );
		        }
		      },
		      close: function() {
		        allFields.val( "" ).removeClass( "ui-state-error" );
		      }
		    });
		    
		    //修改原子知识点
			$( "#change_atomKnowledge" ).dialog({
		      autoOpen: false,
		      height: 550,
		      width: 620,
		      modal: true,
		      buttons: {
		        "修改": function() {
		          var bValid = true;
		          change_allFields.removeClass( "ui-state-error" );
		 
		          bValid = bValid && checkLength( change_atom_nl, "自然语言描述" );
		          bValid = bValid && checkLength( change_atom_fd, "形式化语言描述" );
		          bValid = bValid && checkLength( change_atom_type, "原子知识点类型" );
		          bValid = bValid && checkLength( change_atom_source, "原子知识点来源" );
		 
		          if ( bValid ) {
		            $( "#atomKnowledges"+"_"+questionCnt.toString()+ " tbody" ).append( "<tr id=\"tr["+atomCnt.toString()+"]\">" +
		              "<td style=\"width:5%\">"+"<input type='checkbox' name='ckb' />"+"</td>"+
		              
		              "<td style=\"width:30%\">" + change_atom_nl.val() + "<input type=\"hidden\" name=\"input[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].nlDescription\" value=\"" + change_atom_nl.val() + "\"/></td>" +
		              "<td style=\"width:40%\"><pre>" + change_atom_fd.val() + "</pre><input type=\"hidden\" name=\"input[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].formalDescription\" value=\"" + change_atom_fd.val() + "\"/></td>" +
		              "<td style=\"width:10%\">" + change_atom_type.find("option:selected").text() + "<input type=\"hidden\" name=\"input[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].type\" value=\"" + change_atom_type.find("option:selected").val() + "\"/></td>" +
		              "<td style=\"width:10%\">" + change_atom_source.val() + "<input type=\"hidden\" name=\"input[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].source\" value=\"" + change_atom_source.val() + "\"/></td>"  + 
		              
		             
		              "<td style=\"width:5%\" id=\"td["+atomCnt.toString()+"]\">"+ "<input type=\"button\" id=\"btnUpd[" + questionCnt.toString() + "].atom[" + atomCnt.toString() + "].nlDescription\" class='button' value=\"修改\" onclick=\"change_atomKnowledge()\"/></td>"+
		              
		              "</tr>" 
		             );
		            atomCnt += 1;
		            $( this ).dialog( "close" );
		          }
		        },
		        "取消": function() {
		          $( this ).dialog( "close" );
		        }
		      },
		      close: function() {
		        change_allFields.val( "" ).removeClass( "ui-state-error" );
		      }
		    });
		 
		    //添加原子知识点按钮功能
		   /** $( "#create_atomKnowledge_"+questionCnt.toString() ).click(function() {
		        $( "#new_atomKnowledge" ).dialog( "open" );
		      });**/
		      function create_atomKnowledge(){
		    	  $( "#new_atomKnowledge" ).dialog( "open" ); 
		      }
		      
		      function change_atomKnowledge(){
		    	  $( "#change_atomKnowledge" ).dialog( "open" ); 
		      }
		      
		      function delete_atomKnowledge(){
		    		     //获取选中的复选框，然后循环遍历删除
		    		     var ckbs=$("input[name=ckb]:checked");
		    		     if(ckbs.size()==0){
		    		        alert("要删除指定行，需选中要删除的行！");
		    		        return;
		    		     }
		    		           ckbs.each(function(){
		    		              $(this).parent().parent().remove();
		    		           });
		      }
		    
		    //提交按钮功能
		    /*
		    $("#submitBtn").click(function(){
		    	$("#Input").form("submit",{
		    		url:"${pageContext.request.contextPath}/input1.action",
		    		success:function(){
		    			alert("submit");
		    		}
		    	})
		    });
		    
		    $( "#submitBtn" ).click(function(){
		    	 imgpath="&input[0].img[0]="+$("#image_0").val();
		    	$.ajax({
		    		method : "POST",
					 url : "${pageContext.request.contextPath}/input1.action",
					 dataType : "json",
					 data : $("#Input").serialize() + atomknowledge + typeIdStr,
					 success : function(data){
						 alert("提交成功");
					 }
		    	});
		    	return false;
		    });*/
		    
		    //添加子问题按钮功能
		    $( "#add_question" ).click(function(){
		    	//隐藏上一个问题的添加原子知识点按钮
		    	$( "#create_atomKnowledge_" + questionCnt.toString() ).hide();
		    	//问题计数器+1，原子知识点计数器清零，解题方法计数器清零
		    	questionCnt += 1;
		    	atomCnt = 0;
		    	solutionCnt = 0;
		    	
		    	$( "#wrapper2" ).append("<tr><td><hr size=5 color=#5151A2/></td></tr><tr class=\"labelName\"></td></tr><tr class=\"labelName\"><td>子问题" + questionCnt.toString() + "</td></tr>" +
		    			"<tr class=\"contentArea\"><td><textarea rows=\"5\" name=\"input[" + questionCnt.toString() + "].question.content\"></textarea></td></tr>" + 
		    			"<tr class=\"labelName\"><td>原子知识点</td></tr>" + 
		    			"<tr class=\"contentArea\"><td><div class=\"atomKnowledge-contain\" class=\"ui-widget\">" +
		    			"<table id=\"atomKnowledges_"+ questionCnt.toString() +"\" class=\"ui-widget ui-widget-content\">" +
		    			"<thead><tr class=\"ui-widget-header\"><th style=\"width:30%\">自然语言描述</th><th style=\"width:40%\">形式化语言描述</th><th style=\"width:15%\">类型</th><th style=\"width:15%\">来源</th></tr></thead><tbody></tbody></table></div></td></tr>" +
		    			"<tr><td><input id=\"create_atomKnowledge_"+ questionCnt.toString() +"\" value=\"新建原子知识点\" type=\"button\" class=\"button\" onclick=\"return create_atomKnowledge();\" /></td></tr>" +
		    			"<tr class=\"labelName\"><td>自然语言描述解题思路</td></tr>" +
		    			"<tr class=\"contentArea\"><td><textarea rows=\"10\" name=\"input[" + questionCnt.toString() + "].solution[" + solutionCnt.toString() + "].nlDescription\"></textarea></td></tr>" +
		    			"<tr class=\"labelName\"><td>形式化语言描述解题思路</td></tr>" +
		    			"<tr class=\"contentArea\"><td><textarea rows=\"10\" name=\"input[" + questionCnt.toString() + "].solution[" + solutionCnt.toString() + "].formalDescription\"></textarea></td></tr>" +
		    			"<tr class=\"labelName\"><td>答案</td></tr>" +
		    			"<tr class=\"contentArea\"><td><textarea rows=\"5\" name=\"input[" + questionCnt.toString() + "].question.answer\"></textarea></td></tr>");
		    });
		    
	</script>
</html>