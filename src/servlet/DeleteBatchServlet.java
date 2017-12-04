package servlet;

import service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Silence
 * @Date: Create in 10:20 2017/11/30
 * @Description:
 */
public class DeleteBatchServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码设置
        req.setCharacterEncoding("utf-8");
        //接受参数
        String[] ids = req.getParameterValues("id");
        //业务处理
        MaintainService maintainService = new MaintainService();
        maintainService.deleteBatch(ids);
        //跳转页面
        req.getRequestDispatcher("/servlet/ListServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
