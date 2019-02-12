package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.utils.HtmlReader;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Nino Bonev - 1.2.2019 г., 15:57
 */

@WebServlet("/cats/profile")
public class CatProfileServelet extends HttpServlet {

    private final HtmlReader htmlReader;
    private final static String CAT_HTML_PROFILE_PATH = "C:\\Nino\\Projects\\SoftUni\\JavaWebJanuary2019\\Java Web Development\\Exercises\\04. INTRODUCTION TO JAVA EE - EXERCISES\\FluffyDuffyMunchkinCats\\src\\main\\resources\\views\\showCat.html";

    @Inject
    public CatProfileServelet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // TODO: on empty session map, redirect to error page
        String catName = req.getQueryString().split("=")[1];;
        Cat cat = ((Map<String, Cat>) req.getSession().getAttribute("cats"))
                .get(catName);


        String htmlFileContent;
        if (cat == null){
            htmlFileContent = this.htmlReader
                    .readHtmlFile("C:\\testing\\FluffyDuffyMunchkinCats\\src\\main\\resources\\views\\error.html")
                    .replace("{{catName}}", catName);

        } else {
            htmlFileContent = this.htmlReader
                    .readHtmlFile(CAT_HTML_PROFILE_PATH)
                    .replace("{{catName}}", cat.getName())
                    .replace("{{catColour}}", cat.getColor())
                    .replace("{{catBreed}}", cat.getBreed())
                    .replace("{{catAge}}", cat.getAge().toString());

        }

        resp.getWriter().println(htmlFileContent);

    }
}
