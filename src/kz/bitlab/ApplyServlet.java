package kz.bitlab;




import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/apply")
public class ApplyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("HELLO APPLY");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = 6;
        String name = request.getParameter("item_name");
        double price = Double.parseDouble(request.getParameter("item_price"));
        int amount = Integer.parseInt(request.getParameter("item_amount"));

        Item items = new Item();
        items.setId(id);
        items.setName(name);
        items.setPrice(price);
        items.setAmount(amount);
        DBManager.addItem(items);
        response.sendRedirect("/homeservlet");
    }
}
