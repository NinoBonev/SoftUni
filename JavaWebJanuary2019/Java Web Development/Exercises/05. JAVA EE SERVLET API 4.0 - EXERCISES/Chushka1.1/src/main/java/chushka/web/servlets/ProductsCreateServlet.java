package chushka.web.servlets;

import chushka.domains.entities.Type;
import chushka.domains.models.service.ProductServiceModel;
import chushka.service.ProductService;
import chushka.util.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Nino Bonev - 7.2.2019 г., 12:26
 */

@WebServlet("/products/create")
public class ProductsCreateServlet extends HttpServlet {

    private static final String CREATE_PRODUCT_HTML_PATH = "C:\\Nino\\Projects\\SoftUni\\JavaWebJanuary2019\\Java Web Development\\Exercises\\05. JAVA EE SERVLET API 4.0 - EXERCISES\\Chushka1.1\\src\\main\\resources\\views\\createProduct.html";

    private final ProductService productService;
    private final HtmlReader htmlReader;

    @Inject
    public ProductsCreateServlet(ProductService productService, HtmlReader htmlReader) {
        this.productService = productService;
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlFileContent = this.htmlReader
                .readHtmlFile(CREATE_PRODUCT_HTML_PATH)
                .replace("{{typeOptions}}", this.formatTypeOptions());

        resp.getWriter().println(htmlFileContent);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductServiceModel productServiceModel = new ProductServiceModel();
        productServiceModel.setName(req.getParameter("name"));
        productServiceModel.setDescription(req.getParameter("description"));
        productServiceModel.setType(Type.valueOf(req.getParameter("type")));


        this.productService.saveProduct(productServiceModel);

        resp.sendRedirect("/");

    }

    private String formatTypeOptions() {
        StringBuilder options = new StringBuilder();

        Arrays.stream(Type.values()).forEach(type -> {
            options.append(String.format("<option value=\"%s\">%s</option>", type.name(), type.name()))
                    .append(System.lineSeparator());
        });

        return options.toString();
    }
}
