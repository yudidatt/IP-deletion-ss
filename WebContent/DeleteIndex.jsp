<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style>
.box{
    width: 30%;
    float: left;
    padding: 20px;
    background-color: #F2F2F2;
    min-height: 260px;
}
.mid_box{


       border-left: 1px solid #000;
    border-right: 1px solid #000;
    border-bottom: 1px solid #000;
    border-top: 1px solid #000;
     height
}
.clearfixed{
clear:both;
}  
 .foot_left{
      width: 90%;
    float: left;
    background-color: white;
        padding-left: 10%;
    padding-top: 0.5%;
    padding-bottom: 0%;

    }
</style>
</head>


<body style="margin: 0;padding: 0;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #F2F2F2;height: 100% !important;width: 100% !important;">

<div class="clearfixed"></div>
  <div class="foot_left">
  <img src="shieldquare-logo.png" width="183" height="40" border="0" align="left"/><br><br><br>
 </div>
 
<div class="box">
<font color="red" size="5" style="border-bottom-style: dotted;">Module For</font><br><br>
	Delete IP From IP_analysis 
	and subtract the value from 
	rules_summary table in selected column.<br> <br> 
	1-<font color="red">R1,R2...</font>are the column name in rules_summary table<br>
	2-Select only one column
</div>


<div class="box mid_box" >

<table border="0" cellpadding="0" cellspacing="0" height="10" width="10" id="bodyTable" style="border-collapse: collapse;table-layout: fixed;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;margin: 50;padding: 0;background-color: #F2F2F2;height: 100% !important;width: 100% !important;">
<tr>
                	<td align="center" valign="top" id="bodyCell" style="mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;margin: 0;padding: 0;border-top: 5px solid #FFFFFF;height: 100% !important;width: 100% !important;">

<form action="ControllerForDelete" method="post" align="center">
<h1>Welcome To ShieldSquare</h1>
Enter SID<input type="text"  name="sid"><br><br>
Enter IP_Address<input type="text" name="ipaddress"><br><br>


R1(Bad_Bots):<br><input type="checkbox" name="R1" value="1" /><br>
R2(Data_center_bots):<br><input type="checkbox" name="R2" value="1"/><br>
R4(r_aggregator):<br><input type="checkbox" name="R4" value="1"/><br>
R5(Known_UA_Bots):<br><input type="checkbox" name="R5" value="1"/><br><br>
<input type="submit" value="Think Once for Delete" > 

	</form>	
</td>	
	</tr>

</table>
</div>

<!-- -------Right Box---------------->


<div class="box">
	

</div>

</div>

</body>
</html>