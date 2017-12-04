<%--
  Created by IntelliJ IDEA.
  User: Silence 
  Time: 14:55 2017/11/29
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
    <title>List</title>
    <link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%=basePath%>resources/js/list.js"></script>
</head>
<body style="background-color: #e1e9eb">
    <form action="<%=basePath%>servlet/ListServlet" id="mainForm" method="get">
        <input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
        <div class="right">
            <div class="current">当前位置：<a href="#">内容管理</a> &gt; 内容列表</div>
            <div class="rightCont">
                <p class="g_title fix">内容列表：<a class="btn03" href="<%=basePath%>servlet/InsertCommandServlet">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="javascript:deleteBatch('<%=basePath%>');">删 除</a></p>
                <table class="tab1">
                    <tbody>
                    <tr>
                        <td width="90" align="right">指令名称</td>
                        <td>
                            <input name="command_name" type="text" class="allInput" value="${name}"/>
                        </td>
                        <td width="90" align="right">描述</td>
                        <td>
                            <input name="description" type="text" class="allInput" value="${description}"/>
                        </td>
                        <td width="90" align="right">
                            <input type="submit" class="tabSub" value="查询"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="zixun fix">
                    <table class="tab2" width="100%">
                        <tr>
                            <th><input type="checkbox" id="all" onclick=""/></th>
                            <th>序号</th>
                            <th>指令名称</th>
                            <th>描述</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${commandList}" var="command" varStatus="status">

                            <tr <c:if test="${status.index%2!=0}">style="background-color:#ECF6EE;"</c:if>>
                                <td><input type="checkbox" name="command_id" value="${command.id}"/></td>
                                <td>${status.index+1}</td>
                                <td><a href="${basePath}QueryContentByCommand?command_id=${command.id}">${command.name}</a></td>
                                <td>${command.description}</td>
                                <td>
                                    <%--<a href="#">修改</a>&nbsp;&nbsp;&nbsp;--%>
                                    <a href="${basePath}DeleteOneCommandServlet?command_id=${command.id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="page fix">
                        共<b>${page.totalNumber}</b>条
                        <c:if test="${page.currentPage!=1}">
                            <a href="javascript:changeCurrentPage('1');" class="first">首页</a>
                            <a href="javascript:changeCurrentPage('${page.currentPage-1}');" class="pre">上一页</a>
                        </c:if>
                        当前第<span>${page.currentPage}/${page.totalPage}</span>页
                        <c:if test="${page.currentPage!=page.totalPage}">
                            <a href="javascript:changeCurrentPage('${page.currentPage+1}');" class="next">下一页</a>
                            <a href="javascript:changeCurrentPage('${page.totalPage}');" class="last">尾页</a>
                        </c:if>
                        跳至&nbsp;<input id="currentPageText" type="text" value='${page.currentPage}' class="allInput w28"/>&nbsp;
                        <a href="javascript:changeCurrentPage($('#currentPageText').val());" class="go">Go</a>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
