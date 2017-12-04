package servlet;

import service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Silence
 * @Date: Create in 11:00 2017/11/30
 * @Description:
 */
public class InitTalkServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码设置
        req.setCharacterEncoding("utf-8");
        //跳转页面
        req.getRequestDispatcher(req.getContextPath()+"/WEB-INF/jsp/front/talk.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
