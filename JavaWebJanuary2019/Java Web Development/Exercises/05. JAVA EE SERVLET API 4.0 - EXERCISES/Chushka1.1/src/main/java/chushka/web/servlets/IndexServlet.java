package chushka.web.servlets;

import chushka.domains.models.view.AllProductsViewModel;
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
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 2.2.2019 г., 12:10
 */

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private static final String INDEX_HTML_PATH = "C:\\Nino\\Projects\\SoftUni\\JavaWebJanuary2019\\Java Web Development\\Exercises\\05. JAVA EE SERVLET API 4.0 - EXERCISES\\Chushka1.1\\src\\main\\resources\\views\\index.html";

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
        String htmlFile = this.htmlReader
                .readHtmlFile(INDEX_HTML_PATH)
                .replace("{{listItems}}", this.formatListItems());


        resp.getWriter().println(htmlFile);
    }

    private String formatListItems() {
        List<AllProductsViewModel> allProducts = this.productService.getAllProducts()
                .stream()
                .map(productServiceModel -> this.modelMapper.map(productServiceModel, AllProductsViewModel.class))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        allProducts.forEach(p -> {
            sb.append(String.format("<li><a href=\"/products/details?name=%s\">%s</li>", p.getName(), p.getName()))
            .append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
