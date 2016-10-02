/*
 * 用于弹出输入原子知识点子对话框的函数
 */

 
 
/*
 * 用于设置级联下拉列表样式的函数
 */
	//$(function JqueryNavigate() {
		$(function LoadCss() {
			var jquerynavigate = $("#cascadeList");
			jquerynavigate.children().addClass("navigate");
			jquerynavigate.children().children().addClass("firstmenu");
			jquerynavigate = jquerynavigate.children().children().children();
			if (jquerynavigate.is("div")) {
				jquerynavigate.addClass("firstlist");
				jquerynavigate.children().addClass("menu");
				jquerynavigate = jquerynavigate.children().children();
				while (jquerynavigate.is("div")) {
					jquerynavigate.addClass("list");
					jquerynavigate.children().addClass("menu");
					jquerynavigate = jquerynavigate.children().children();
				}
			}
		});
		$(function LoadEven() {
			$(".firstmenu").mouseover(function() {
				$(this).css("background", "#333333");
				$(this).children().show();
			});
			$(".firstmenu").mouseout(function() {
				$(this).css("background", "#400000");
				$(this).children().hide();
			});
			$(".menu").mouseover(function() {
				$(this).css("background", "#000000");
				$(this).children().show();
			});
			$(".menu").mouseout(function() {
				$(this).css("background", "#333333");
				$(this).children().hide();
			});
		});
//	});

/*
 * 用于动态删除题目类型标签的函数
 */
var typeCnt = 0;
var typeIdArray = [["历史",3,2], ["地理",4,2], ["选择题",6,5], ["问答题",7,5]];
var selectedLabel = new Array();   //存储已经被选择的类型的在typeIdArray中的index值
var typeIdStr = "";

	//找到类型对应的数据库里面的id，假设一定能找到。
	function findTypeId(typeInfo) {
		var id = 0;
		for(var i=0; i<typeIdArray.length; i++) {
			if(typeIdArray[i][0] == typeInfo) {
				id = typeIdArray[i][1];
				break;
			}
		}
		return id;
	}
	
	//判断该typeInfo是否可选。
	function canSelect(typeInfo) {
		var index = 0;
		for(var i=0; i<typeIdArray.length; i++) {
			if(typeIdArray[i][0] == typeInfo) {
				index = i;
				break;
			}
		}
		
		var canselect = true;
		for(var i=0; i<typeCnt; i++) {
			if(typeIdArray[selectedLabel[i]][2] == typeIdArray[index][2]) {
				canselect = false;
				break;
			}	
		}
		return canselect;
	}
	
	$(function(){
		$("#history,#geography,#choice,#qa").click(
			function addLabel() {
				var typeInfo = $(this).text();
				if(canSelect(typeInfo)) {
					var colsNum = $("#labeltable tr").eq(0).children().length; //表格列数
					var row = $("#labeltable tr").eq(0); //获取第一行
					var col = $("<td></td>");
					var typeId = findTypeId(typeInfo);
					col.html("<input type='hidden' name='input[0].question_type[" + (typeCnt) + "]' value=" + typeId + 
							"> <input type='button' value='" + typeInfo + "' disabled>");
					var formerCol = row.children().eq(colsNum-2);  //获取倒数第二列 
					formerCol.after(col);  //插入列
					typeIdStr += "&input[" + questionCnt.toString() + "].question_type[" + typeCnt.toString() + "]=" + typeId;
					//找到该typeInfo在typeIdArray里面的index值，并存储到selectedLabel数组中。
					var index = 0;
					for(var i=0; i<typeIdArray.length; i++) {
						if(typeIdArray[i][0] == typeInfo) {
							index = i;
							break;
						}
					}
					selectedLabel[typeCnt] = index;
					typeCnt ++;
				} else {
					alert("您已选择了与\"" + typeInfo + "\"相同父类型的一个子类型");
				}
			});
			$("#deleteLabel").click(
				function deleteLabel() {
					var tab = $("#labeltable");
					var colsNum = $("#labeltable tr").eq(0).children().length;  //表格列数
					if(colsNum > 2) {
						var row = $("#labeltable tr").eq(0);  //获取第一行
						row.children().eq(colsNum-2).remove();
						var index = typeIdStr.lastIndexOf("&");
						typeIdStr = typeIdStr.substring(0,index);
						typeCnt--;
					}
			});
		});

