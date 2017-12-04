package servlet;

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
public class UpdateOneServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码设置
        req.setCharacterEncoding("utf-8");
        //接受参数
        String id= req.getParameter("id");
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        Message message = new Message();
        message.setId(Integer.valueOf(id));
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        //业务处理
        MaintainService maintainService = new MaintainService();
        maintainService.updateOne(message);
        //跳转页面
        resp.sendRedirect("/servlet/ListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
