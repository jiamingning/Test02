<%@ page language="java" import="java.util.*,dao.*,dao.impl.*,entity.*,java.text.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doReply.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<%
//接受参数
request.setCharacterEncoding("gbk");
int boardId=Integer.parseInt(request.getParameter("boardId"));
int topicId=Integer.parseInt(request.getParameter("topicId"));
String title=request.getParameter("title");
int uid=0;
User loginedUser=(User)session.getAttribute("loginedUser");
if(loginedUser!=null){
   	uid=loginedUser.getUID();
}
String content=request.getParameter("content");

//业务逻辑处理
ReplyDao rd=new ReplyDaoImpl();
String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
Reply reply=new Reply(title,content,time,time,uid,topicId);
int num=rd.addReply(reply);


//页面跳转
if(num>0){
   response.sendRedirect("../detail.jsp?p1=1&topicId="+topicId+"&boardId="+boardId);
}
 %>
  </body>
</html>
