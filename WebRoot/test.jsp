<%@ page language="java" pageEncoding="UTF-8"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <title>利用jquery给指定的table添加一行、删除一行</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <script type="text/javascript"
   src="PluginUnit/jquery-ui-1.10.3/jquery-1.9.1.js"></script>
  <script type="text/javascript">
  ////////添加一行、删除一行封装方法///////
  /**
   * 为table指定行添加一行
   *
   * tab 表id
   * row 行数，如：0->第一行 1->第二行 -2->倒数第二行 -1->最后一行
   * trHtml 添加行的html代码
   *
   */
  function addTr(tab, row, trHtml){
     //获取table最后一行 $("#tab tr:last")
     //获取table第一行 $("#tab tr").eq(0)
     //获取table倒数第二行 $("#tab tr").eq(-2)
     var $tr=$("#"+tab+" tr").eq(row);
     if($tr.size()==0){
        alert("指定的table id或行数不存在！");
        return;
     }
     $tr.after(trHtml);
  }
   
  function delTr(ckb){
     //获取选中的复选框，然后循环遍历删除
     var ckbs=$("input[name="+ckb+"]:checked");
     if(ckbs.size()==0){
        alert("要删除指定行，需选中要删除的行！");
        return;
     }
           ckbs.each(function(){
              $(this).parent().parent().remove();
           });
  }
   
  /**
   * 全选
   * 
   * allCkb 全选复选框的id
   * items 复选框的name
   */
  function allCheck(allCkb, items){
   $("#"+allCkb).click(function(){
      $('[name='+items+']:checkbox').attr("checked", this.checked );
   });
  }
   
  ////////添加一行、删除一行测试方法///////
  $(function(){
   //全选
   allCheck("allCkb", "ckb");
  });
   
  function addTr2(tab, row){
    var trHtml="<tr align='center'><td width='30%'><input type='checkbox' name='ckb'/></td><td width='30%'>地理</td><td width='30%'>60</td></tr>";
    addTr(tab, row, trHtml);
  }
   
  function delTr2(){
     delTr('ckb');
  }
  </script>
 </head>
 
 <body>
  <table border="1px #ooo" id="tab" cellpadding="0"
   cellspacing="0" width="30%">
   <tr align="center">
       <td width="30%"><input id="allCkb" type="checkbox"/></td>
    <td width="30%">科目</td>
    <td width="30%">成绩</td>
   </tr>
   <tr align="center">
       <td width="30%"></td>
    <td width="30%">语文</td>
    <td width="30%">80</td> 
   </tr>
  </table>
  <input type="button" onclick="addTr2('tab', -1)" value="添加">
     <input type="button" onclick="delTr2()" value="删除">
 
 </body>
</html>