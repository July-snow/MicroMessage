package servlet;

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
public class DeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码设置
        req.setCharacterEncoding("utf-8");
        //接受参数
        String id = req.getParameter("id");
        //业务处理
        MaintainService maintainService = new MaintainService();
        maintainService.deleteOne(id);
        //跳转页面
        resp.sendRedirect("/servlet/ListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
