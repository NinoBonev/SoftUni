package metube.web.filters;

import metube.domain.models.binding.TubeCreateBindingModel;
import metube.util.ValidationUtilImpl;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nino Bonev - 7.2.2019 г., 19:38
 */

@WebFilter("/tubes/create")
public class TubesCreateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getMethod().toLowerCase().equals("post")){
            TubeCreateBindingModel tcbm = new TubeCreateBindingModel();
            tcbm.setName(req.getParameter("name"));
            tcbm.setDescription(req.getParameter("description"));
            tcbm.setUploader(req.getParameter("uploader"));
            tcbm.setYouTubeLink(req.getParameter("youTubeLink"));

            req.setAttribute("tubeCreateBindingModel", tcbm);
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
