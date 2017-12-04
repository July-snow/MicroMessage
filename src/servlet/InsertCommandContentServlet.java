package servlet;

import bean.Command;
import bean.CommandContent;
import service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Author: Silence
 * @Date: Create in 22:28 2017/11/29
 * @Description:
 */
public class InsertCommandContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码设置
        req.setCharacterEncoding("utf-8");
        //接受参数
        String command_name = req.getParameter("command_name");
        String command_description = req.getParameter("command_description");
        String content = req.getParameter("command_content");
        Command command = new Command();
        command.setName(command_name);
        command.setDescription(command_description);
        //业务处理
        MaintainService maintainService = new MaintainService();
        maintainService.insertOneCommand(command);

        CommandContent commandContent = new CommandContent();
        commandContent.setCommandId(2);
        commandContent.setContent(content);

        req.setAttribute("command_id",2);


       req.getRequestDispatcher("/servlet/QueryContentByCommand").forward(req, resp);

        //跳转页面
     //   resp.sendRedirect("/servlet/QueryContentByCommand?command_id="+command_id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
