package main.java.app.contracts;

import java.util.HashMap;

/**
 * Created by Nino Bonev - 22.1.2019 г., 9:34
 */
public interface HttpRequest {

    HashMap<String, String> getHeaders();

    HashMap<String, String> getBodyParameters();

    String getMethod();

    void setMethod(String method);

    String getRequestUrl();

    void setRequestUrl(String requestUrl);

    void addHeader(String header, String value);

    void addBodyParameter(String parameter, String value);

    boolean isResource();

}
