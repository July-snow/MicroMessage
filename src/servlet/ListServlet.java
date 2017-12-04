package servlet;

import bean.Command;
import bean.Message;
import emtity.Page;
import service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: Silence
 * @Date: Create in 14:51 2017/11/29
 * @Description: 列表的初始化
 */
public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //接收前端页面参数
        String name = req.getParameter("command_name");
        String description = req.getParameter("description");
        String currentPage = req.getParameter("currentPage");
        System.out.println(description);
        System.out.println(currentPage);
        //创建分页对象
        Page page = new Page();
        Pattern pattern = Pattern.compile("[0-9]{1,9}");
        if(currentPage==null||!pattern.matcher(currentPage).matches()){
            page.setCurrentPage(1);
        }else {
            page.setCurrentPage(Integer.valueOf(currentPage));
        }
        QueryService queryService = new QueryService();
        List<Command> commandList = null;
        List<Message> messageList = null;
        try {
            commandList = queryService.queryCommandListByPage(name,description,page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("commandList",commandList);
        req.setAttribute("name",name);
        req.setAttribute("description",description);
        req.setAttribute("page",page);

        req.getRequestDispatcher(req.getContextPath()+"/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
