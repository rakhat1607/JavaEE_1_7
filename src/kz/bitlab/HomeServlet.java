package kz.bitlab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/homeservlet")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,  ServletException {
        ArrayList<Item> items = DBManager.getAllItems();
        request.setAttribute("gadjet" ,items);
        request.getRequestDispatcher("/main.jsp").forward(request,response);
    }
}
