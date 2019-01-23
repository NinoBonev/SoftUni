package main.java.app.contracts;

import java.util.HashMap;

/**
 * Created by Nino Bonev - 22.1.2019 г., 9:34
 */
public interface HttpResponse {

    HashMap<String, String> getHeaders();

    int getStatusCode();

    byte[] getContent();

    byte[] getBytes();

    void setStatusCode(int statusCode);

    void setContent(byte[] content);

    void addHeader(String header, String value);
}
