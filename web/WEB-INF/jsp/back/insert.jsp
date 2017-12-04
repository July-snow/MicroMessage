<%--
  Created by IntelliJ IDEA.
  User: Silence 
  Time: 16:47 2017/12/1
  Description:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
</head>
<body  style="background-color: #e1e9eb">
    <form action="<%=basePath%>servlet/InsertOneCommandServlet">
        <div class="right">
            <div class="current">当前位置：<a href="#">内容管理</a> &gt; 内容维护</div>
            <div class="rightCont">
                <p class="g_title fix">内容维护：</p>
                <table class="tab1" align="center" width="60%" style="border-collapse:separate; border-spacing:0px 10px;">
                    <tbody>
                    <tr >
                        <td width="90" align="center">指令名称</td>
                        <td>
                            <input name="command_name" style=" font-size: 14px;height: 30px" type="text" class="allInput" value=""/>
                        </td>
                        <td width="90" align="center">描    述</td>
                        <td>
                            <input name="command_description" style=" font-size: 14px;height: 30px;width: 240px" type="text" class="allInput" value=""/>
                        </td>

                    </tr>
                    <tr>
                        <td width="90" align="center">内    容</td>

                        <td colspan="3">
                            <textarea  name="command_content" style="width: 100%; height: 120px; font-size: 14px; line-height:23px; border:1px solid #c3ced0;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" width="90" align="right">

                            <button class="tabSub" href="<%=basePath%>servlet/InsertOneCommandServlet">确    认</button> &nbsp;&nbsp;&nbsp;&nbsp;
                            <button class="tabSub" href="#">取    消</button>

                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
</body>
</html>
