<%@ page language="java" pageEncoding="UTF-8"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <title>����jquery��ָ����table���һ�С�ɾ��һ��</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <script type="text/javascript"
   src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
  <script type="text/javascript">
  ////////���һ�С�ɾ��һ�з�װ����///////
  /**
   * Ϊtableָ�������һ��
   *
   * tab ��id
   * row �������磺0->��һ�� 1->�ڶ��� -2->�����ڶ��� -1->���һ��
   * trHtml ����е�html����
   *
   */
  function addTr(tab, row, trHtml){
     //��ȡtable���һ�� $("#tab tr:last")
     //��ȡtable��һ�� $("#tab tr").eq(0)
     //��ȡtable�����ڶ��� $("#tab tr").eq(-2)
     var $tr=$("#"+tab+" tr").eq(row);
     if($tr.size()==0){
        alert("ָ����table id�����������ڣ�");
        return;
     }
     $tr.after(trHtml);
  }
   
  function delTr(ckb){
     //��ȡѡ�еĸ�ѡ��Ȼ��ѭ������ɾ��
     var ckbs=$("input[name="+ckb+"]:checked");
     if(ckbs.size()==0){
        alert("Ҫɾ��ָ���У���ѡ��Ҫɾ�����У�");
        return;
     }
           ckbs.each(function(){
              $(this).parent().parent().remove();
           });
  }
   
  /**
   * ȫѡ
   * 
   * allCkb ȫѡ��ѡ���id
   * items ��ѡ���name
   */
  function allCheck(allCkb, items){
   $("#"+allCkb).click(function(){
      $('[name='+items+']:checkbox').attr("checked", this.checked );
   });
  }
   
  ////////���һ�С�ɾ��һ�в��Է���///////
  $(function(){
   //ȫѡ
   allCheck("allCkb", "ckb");
  });
   
  function addTr2(tab, row){
    var trHtml="<tr align='center'><td width='30%'><input type='checkbox' name='ckb'/></td><td width='30%'>����</td><td width='30%'>60</td></tr>";
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
    <td width="30%">��Ŀ</td>
    <td width="30%">�ɼ�</td>
   </tr>
   <tr align="center">
       <td width="30%"></td>
    <td width="30%">����</td>
    <td width="30%">80</td> 
   </tr>
  </table>
  <input type="button" onclick="addTr2('tab', -1)" value="���">
     <input type="button" onclick="delTr2()" value="ɾ��">
 
 </body>
</html>
