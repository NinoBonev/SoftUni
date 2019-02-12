package chushka.web.servlets;

import chushka.domains.entities.Type;
import chushka.domains.models.view.ProductDetailsViewModel;
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
 * Created by Nino Bonev - 7.2.2019 г., 14:50
 */

@WebServlet("/products/details")
public class ProductDetailsServlet extends HttpServlet {

    private final static String PRODUCT_DETAILS_HTML_PATH = "C:\\Nino\\Projects\\SoftUni\\JavaWebJanuary2019\\Java Web Development\\Exercises\\05. JAVA EE SERVLET API 4.0 - EXERCISES\\Chushka1.1\\src\\main\\resources\\views\\detailsProduct.html";

    private final ProductService productService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    @Inject
    public ProductDetailsServlet(ProductService productService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.productService = productService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDetailsViewModel productDetailsViewModel = this.modelMapper
                .map(this.productService.getProductByName(req.getQueryString().split("=")[1].replaceAll("%20", " ")), ProductDetailsViewModel.class);

        String htmlFileContent = this.htmlReader
                .readHtmlFile(PRODUCT_DETAILS_HTML_PATH)
                .replace("{{productName}}", productDetailsViewModel.getName())
                .replace("{{productDescription}}", productDetailsViewModel.getDescription())
                .replace("{{productType}}", productDetailsViewModel.getType().name());


        resp.getWriter().println(htmlFileContent);

    }
}

