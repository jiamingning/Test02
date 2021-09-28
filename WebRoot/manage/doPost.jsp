<%@ page language="java" import="java.util.*,dao.*,dao.impl.*,entity.*,java.text.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doPost.jsp' starting page</title>
    
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
    //接收参数
    request.setCharacterEncoding("gbk");
    String title=request.getParameter("title");
    String content=request.getParameter("content");
    User loginedUser=(User)session.getAttribute("loginedUser");
    int uid=0;
	if(loginedUser!=null){
   		 uid=loginedUser.getUID();
    }
    //int topicId=Integer.parseInt(request.getParameter("topicId"));
    int boardId=Integer.parseInt(request.getParameter("boardId"));    
    
    //业务逻辑处理
    TopicDao td=new TopicDaoImpl();
    String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    Topic topic=new Topic(title,content,time,time,uid,boardId);
    int num=td.addTopic(topic);
    
    //根据结果的不同跳转到相应的页面
    if(num>0){
    	response.sendRedirect("../list.jsp?p=1&boardId="+boardId);
    }
     %>
  </body>
</html>
