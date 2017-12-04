package servlet;

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
public class InsertOneContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码设置
        req.setCharacterEncoding("utf-8");
        //接受参数
        String command_id = req.getParameter("command_id");
        String content = req.getParameter("content");
        CommandContent commandContent = new CommandContent();
        commandContent.setCommandId(Integer.valueOf(command_id));
        commandContent.setContent(content);
        //业务处理
        MaintainService maintainService = new MaintainService();
        maintainService.insertOneContent(commandContent);
        req.setAttribute("command_id",command_id);
       req.getRequestDispatcher("/servlet/QueryContentByCommand").forward(req, resp);

        //跳转页面
     //   resp.sendRedirect("/servlet/QueryContentByCommand?command_id="+command_id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
