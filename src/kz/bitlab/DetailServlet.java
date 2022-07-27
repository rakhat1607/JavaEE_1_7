package kz.bitlab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/details")
public class DetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,  ServletException {
        Long id = Long.parseLong(request.getParameter("id"));
        Item item   = DBUtil.getItem(id);
        request.setAttribute("item",item);
        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }
}
