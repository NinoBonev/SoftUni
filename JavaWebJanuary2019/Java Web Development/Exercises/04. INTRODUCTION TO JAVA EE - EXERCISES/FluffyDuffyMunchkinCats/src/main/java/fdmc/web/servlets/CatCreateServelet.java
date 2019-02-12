package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.utils.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nino Bonev - 1.2.2019 г., 15:37
 */
@WebServlet("/cats/create")
public class CatCreateServelet extends HttpServlet {

    private final HtmlReader htmlReader;
    private final static String INDEX_CREATE_CAT_PATH = "C:\\Nino\\Projects\\SoftUni\\JavaWebJanuary2019\\Java Web Development\\Exercises\\04. INTRODUCTION TO JAVA EE - EXERCISES\\FluffyDuffyMunchkinCats\\src\\main\\resources\\views\\createCat.html";

    @Inject
    public CatCreateServelet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(this.htmlReader.readHtmlFile(INDEX_CREATE_CAT_PATH));
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = new Cat();

        cat.setName(req.getParameter("name"));
        cat.setBreed(req.getParameter("breed"));
        cat.setColor(req.getParameter("colour"));
        cat.setAge(Integer.parseInt(req.getParameter("age")));

        if (req.getSession().getAttribute("cats") == null) {
            req.getSession().setAttribute("cats", new HashMap<Cat, String>());
        }

        //ArrayList<Cat> cats = (ArrayList<Cat>)req.getSession().getAttribute("cats");
        ((Map<String, Cat>)req.getSession().getAttribute("cats")).putIfAbsent(cat.getName(), cat);

        resp.sendRedirect(String.format("/cats/profile?catName=%s", cat.getName()));
    }
}
