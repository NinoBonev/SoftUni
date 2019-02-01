package main.java.app.entities;

import main.java.app.constants.Messages;
import main.java.app.contracts.HttpRequest;
import main.java.app.contracts.HttpResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 22.1.2019 г., 9:34
 */
public class HttpResponseImpl implements HttpResponse {
    private HttpRequest httpRequest;
    private int statusCode;

    public HttpResponseImpl(List<String> requestContent) {
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.setStatusCode(Integer.parseInt(requestContent.get(1)
                .split("\\r\\n")[0]
                .split("\\s+")[0]));
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.httpRequest.getHeaders();
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public byte[] getContent() {
        return new byte[0];
    }

    @Override
    public byte[] getBytes() {
        return new byte[0];
    }

    @Override
    public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
    }

    @Override
    public void setContent(byte[] content) {

    }

    @Override
    public void addHeader(String header, String value) {

    }
}
