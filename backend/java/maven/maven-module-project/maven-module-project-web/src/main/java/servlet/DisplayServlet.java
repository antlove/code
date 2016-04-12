package servlet;

import service.MavenService;
import service.impl.MavenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/4/12.
 */
public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MavenService mavenService = new MavenServiceImpl();
        mavenService.action();

        PrintWriter pw = response.getWriter();
        pw.write("hello everyone ...");
        pw.close();

    }
}
