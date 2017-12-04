<%--
  Created by IntelliJ IDEA.
  User: Silence 
  Time: 21:07 2017/12/1
  Description:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%=basePath%>resources/js/contentList.js"></script>
</head>
<body  style="background-color: #e1e9eb">
<form id="mainForm" action="<%=basePath%>servlet/UpdateOneServlet">
    <input type="hidden" name="command_id" id="command_id" value="${commandList.id}"/>
    <div class="right">
        <div class="current">当前位置：<a href="#">内容管理</a> &gt; 更新信息</div>
        <div class="rightCont">
            <p class="g_title fix">更新信息：</p>
            <table class="tab1" align="center" width="60%" style="border-collapse:separate; border-spacing:0px 10px;">
                <tbody>
                <tr >
                    <td width="90" align="center">指令名称</td>
                    <td>
                        <input name="command_name" style="height: 30px; font-size: 14px;" type="text" class="allInput" value="${commandList.name}"/>
                    </td>
                    <td width="90" align="center">描    述</td>
                    <td>
                        <input name="command_description" style="height: 30px; font-size: 14px;width: 240px" type="text" class="allInput" value="${commandList.description}"/>
                    </td>
                    <td>
                        <a class="btn03" href="javascript:insertContent();">新建信息</a>
                    </td>

                </tr>
                <tr id="newContent">
                    <td width="90" align="center">内    容</td>

                    <td colspan="3">
                        <textarea id="content"  name="content" style="width: 100%; height: 80px; font-size: 14px; line-height:23px; border:1px solid #c3ced0;">${content.content}</textarea>
                        <br/>
                        <a class="btn03" style="margin-top:10px;float: right" href="javascript:insertOneContent('<%=basePath%>')">保    存</a>
                    </td>
                </tr>

                <c:forEach items="${commandList.contentList}" var="content" varStatus="status">
                    <input type="hidden" name="content_id" id="con${content.id}" value="${content.id}"/>
                    <tr>
                        <td width="90" align="center">内    容</td>

                        <td colspan="3">
                            <textarea class="contentList" readonly="readonly" name="contents" id="content${content.id}" style="width: 100%; height: 80px; font-size: 14px; line-height:23px; border:1px solid #c3ced0;">${content.content}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td  colspan="4" width="90" align="right">
                            <a class="btn03" href="javascript:modifyContent('${content.id}')">修    改</a> &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="btn03" href="javascript:updateOneContent('<%=basePath%>','${content.id}')">保    存</a> &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="btn03" href="<%=basePath%>servlet/DeleteOneContentServlet?command_id=${commandList.id}&content_id=${content.id}">删    除</a> &nbsp;&nbsp;&nbsp;&nbsp;
                            <%--<a class="tabSub" href="<%=basePath%>servlet/UpdateOneContentServlet?command_id=${commandList.id}&content_id=${content.id}&content=${content.content}">更    新</a> &nbsp;&nbsp;&nbsp;&nbsp;--%>
                            <%--<button type="submit" class="tabSub">确    认</button> &nbsp;&nbsp;&nbsp;&nbsp;--%>
                            <%--<button class="tabSub" href="#">取    消</button>--%>

                        </td>
                    </tr>
                </c:forEach>
                <%--倒序出数据，当顺序序号中间存在空缺时，按这样顺序排列会错乱--%>
                <%--
                <c:set var="startIndex" value="${fn:length(commandList.contentList)-1}"></c:set>
                <c:forEach items="${commandList.contentList}" var="content" varStatus="status">
                    <input type="text" name="content_id" id="content_id" value="${content.id}"/>
                <tr>
                    <td width="90" align="center">内    容</td>

                    <td colspan="3">
                        <textarea  name="content" style="width: 100%; height: 80px; font-size: 14px; line-height:23px; border:1px solid #c3ced0;">${commandList.contentList[startIndex-status.index].content}</textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" width="90" align="right">
                        <a class="btn03" href="<%=basePath%>servlet/DeleteOneContentServlet?command_id=${commandList.id}&content_id=${content.id}">删    除</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="tabSub" href="<%=basePath%>servlet/DeleteOnContentServlet">更    新</button> &nbsp;&nbsp;&nbsp;&nbsp;
                        &lt;%&ndash;<button type="submit" class="tabSub">确    认</button> &nbsp;&nbsp;&nbsp;&nbsp;&ndash;%&gt;
                        &lt;%&ndash;<button class="tabSub" href="#">取    消</button>&ndash;%&gt;

                    </td>
                </tr>
                </c:forEach>
--%>


                </tbody>
            </table>
        </div>
    </div>
</form>
</body>
</html>
