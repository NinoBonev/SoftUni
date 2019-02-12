package chushka.web.servlets;

import chushka.service.ProductService;
import chushka.util.HtmlReader;
import chushka.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nino Bonev - 2.2.2019 г., 12:10
 */

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private static final String INDEX_HTML_PATH = "C:\\Nino\\Projects\\SoftUni\\JavaWebJanuary2019\\Java Web Development\\Exercises\\05. JAVA EE SERVLET API 4.0 - EXERCISES\\Chushka\\src\\main\\resources\\views\\index.html";

    private final ProductService productService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    @Inject
    public IndexServlet(ProductService productService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.productService = productService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlFile = this.htmlReader.readHtmlFile(INDEX_HTML_PATH);

        resp.getWriter().println(htmlFile);
    }
}
