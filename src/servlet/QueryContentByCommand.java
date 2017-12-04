package servlet;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Silence
 * @Date: Create in 21:40 2017/12/1
 * @Description:
 */
public class QueryContentByCommand extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码设置
        req.setCharacterEncoding("utf-8");
        //接受参数
        String command_id= req.getParameter("command_id");
        System.out.println(command_id);
        //业务处理
        MaintainService maintainService = new MaintainService();
        Command commandList = maintainService.queryContentByCommand(command_id);

        req.setAttribute("commandList",commandList);
        //跳转页面
        req.getRequestDispatcher(req.getContextPath()+"/WEB-INF/jsp/back/contentList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
