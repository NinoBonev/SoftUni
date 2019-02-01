package main.java.app.entities;

import main.java.app.contracts.HttpRequest;

import java.util.*;

/**
 * Created by Nino Bonev - 22.1.2019 г., 9:34
 */
public class HttpRequestImpl implements HttpRequest {

    private String method;
    private String requestUrl;
    private HashMap<String, String> headers;
    private HashMap<String, String> bodyParameters;
    private List<HttpCookieImpl> cookies;

    public HttpRequestImpl(List<String> requestContent) {

        this.setMethod(requestContent.get(0));
        this.setRequestUrl(requestContent.get(0));
        this.setHeader(requestContent);
        this.setBodyParameters(requestContent);
        this.isResource();
    }

    private void setHeader(List<String> request) {
        this.headers = new LinkedHashMap<>();
        this.cookies = new ArrayList<>();

        request.stream()
                .filter(h -> h.contains(": "))
                .map(h -> h.split(": "))
                .forEach(headerKVP -> {
                    if (headerKVP[0].equals("Cookie")){
                        Arrays.stream(headerKVP[1]
                                .split("; "))
                                .map(h -> h.split("="))
                                .forEach(cookieKVP -> {

                                    HttpCookieImpl cookie =
                                            new HttpCookieImpl(cookieKVP[0], cookieKVP[1]);
                                    this.cookies.add(cookie);
                                });
                    } else {
                        this.headers.put(headerKVP[0], headerKVP[1]);
                    }
                });

    }

    private void setBodyParameters(List<String> request) {

        this.bodyParameters = new LinkedHashMap<>();

        String line = request.get(request.size() - 1);

        if (!line.equals(System.lineSeparator())) {
            Arrays.stream(line
                    .split("&"))
                    .map(bodyPM ->
                            bodyPM.split("="))
                    .forEach(bpKVP -> {
                        this.bodyParameters.put(bpKVP[0], bpKVP[1]);
                    });
        }

    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return this.bodyParameters;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(String requestContent) {
        this.method = requestContent.split("\\r\\n")[0].split("\\s+")[0];
    }

    public List<HttpCookieImpl> getCookies() {
        return this.cookies;
    }

    @Override
    public String getRequestUrl() {
        return this.requestUrl;
    }

    @Override
    public void setRequestUrl(String requestContent) {
        this.requestUrl = requestContent.split("\\r\\n")[0].split("\\s+")[1];
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParameters.put(parameter, value);
    }

    @Override
    public boolean isResource() {
        return this.requestUrl.contains(".");
    }
}
