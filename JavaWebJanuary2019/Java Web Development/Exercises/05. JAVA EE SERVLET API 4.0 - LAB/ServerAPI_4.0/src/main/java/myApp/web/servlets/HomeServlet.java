package myApp.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nino Bonev - 6.2.2019 г., 17:14
 */

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    public HomeServlet() {
        int b = 5;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("It works");
    }
}
