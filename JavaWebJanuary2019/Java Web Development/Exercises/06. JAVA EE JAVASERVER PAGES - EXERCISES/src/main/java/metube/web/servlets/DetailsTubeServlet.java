package metube.web.servlets;

import metube.domain.models.view.TubesDetailsViewModel;
import metube.service.TubeService;
import metube.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by Nino Bonev - 7.2.2019 г., 19:34
 */

@WebServlet("/tubes/details")
public class DetailsTubeServlet extends HttpServlet {

    private final TubeService tubeService;
    private final ModelMapper modelMapper;

    @Inject
    public DetailsTubeServlet(TubeService tubeService, ModelMapper modelMapper) {
        this.tubeService = tubeService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getQueryString()
//                .split("=")[1]
//                .replaceAll("%20", " ");

        String name = URLDecoder.decode(req.getQueryString().split("=")[1], "UTF-8");

        req.setAttribute("tubeDetailsViewModel",
                this.modelMapper.map(this.tubeService.findTubeByName(name), TubesDetailsViewModel.class));

        req.getRequestDispatcher("/jsps/detailsTube.jsp").forward(req, resp);
    }
}
