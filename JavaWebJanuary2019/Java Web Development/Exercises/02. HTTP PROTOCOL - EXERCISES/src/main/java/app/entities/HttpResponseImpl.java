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
public class HttpResponseImpl implements HttpRequest {

    @Override
    public HashMap<String, String> getHeaders() {
        return null;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return null;
    }

    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public void setMethod(String method) {

    }

    @Override
    public String getRequestUrl() {
        return null;
    }

    @Override
    public void setRequestUrl(String requestUrl) {

    }

    @Override
    public void addHeader(String header, String value) {

    }

    @Override
    public void addBodyParameter(String parameter, String value) {

    }

    @Override
    public boolean isResource() {
        return false;
    }
}
