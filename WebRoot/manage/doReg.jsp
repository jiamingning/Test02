<%@ page language="java" import="java.util.*,dao.*,dao.impl.*,entity.*,java.text.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doRege.jsp' starting page</title>
    
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
    String uName=request.getParameter("uName");
    String uPass=request.getParameter("uPass");
    int gender=Integer.parseInt(request.getParameter("gender"));
    String head=request.getParameter("head");
    
    //业务逻辑处理
    UserDao ud=new UserDaoImpl();
    String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    
    User user=new User(uName,uPass,gender,head,time);
    int num=ud.addUser(user);
    
    
    //页面跳转
    if(num>0){
        response.sendRedirect("../login.jsp");
    }
    else{
        response.sendRedirect("../reg.jsp");
    }
     %>
  </body>
</html>
