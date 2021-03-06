package fdmc.web.servlets;

import fdmc.utils.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nino Bonev - 1.2.2019 г., 13:09
 */

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private final static String INDEX_HTML_FILE_PATH = "C:\\Nino\\Projects\\SoftUni\\JavaWebJanuary2019\\Java Web Development\\Exercises\\04. INTRODUCTION TO JAVA EE - EXERCISES\\FluffyDuffyMunchkinCats\\src\\main\\resources\\views\\index.html";
    private final HtmlReader htmlReader;

    @Inject
    public IndexServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println(this.htmlReader.readHtmlFile(INDEX_HTML_FILE_PATH));
    }
}
