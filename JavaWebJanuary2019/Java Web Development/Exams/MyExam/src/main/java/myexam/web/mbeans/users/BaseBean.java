package myexam.web.mbeans.users;

import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Nino Bonev - 16.4.2019 г., 16:46
 */
public abstract class BaseBean {
    protected void redirect(String url) {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect("/views" + url + ".jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
