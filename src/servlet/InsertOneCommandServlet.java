package servlet;

import bean.Command;
import bean.Message;
import service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Silence
 * @Date: Create in 16:45 2017/12/1
 * @Description:
 */
public class InsertOneCommandServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码设置
        req.setCharacterEncoding("utf-8");
        //接受参数
        String name = req.getParameter("command_name");
        String description = req.getParameter("command_description");
        Command command = new Command();
        command.setName(name);
        command.setDescription(description);
        //业务处理
        MaintainService maintainService = new MaintainService();
        maintainService.insertOneCommand(command);
        //跳转页面
        resp.sendRedirect("/servlet/ListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
