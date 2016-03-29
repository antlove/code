package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("============================== parameters starts ... ==============================");
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = request.getParameter(name);
            System.out.println(name+":"+value);
        }

        System.out.println("============================== parameters end ... ==============================");

        BufferedReader br = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = null;
        while((line=br.readLine())!=null){
            sb.append(line).append("\n");
        }
        br.close();
        System.out.println(sb);
        PrintWriter pw = response.getWriter();
        pw.write(sb.toString());
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
