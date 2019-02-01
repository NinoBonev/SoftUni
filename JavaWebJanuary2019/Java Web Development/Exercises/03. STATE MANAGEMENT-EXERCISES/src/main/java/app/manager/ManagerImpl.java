package main.java.app.manager;

import main.java.app.constants.Constants;
import main.java.app.constants.Messages;
import main.java.app.entities.HttpRequestImpl;

import java.util.*;

/**
 * Created by Nino Bonev - 22.1.2019 г., 21:09
 */
public class ManagerImpl {
    private List<String> validUrls;
    private HttpRequestImpl httpRequest;

    public ManagerImpl(List<String> request) {
        this.validUrls = new ArrayList<>();
        this.httpRequest = new HttpRequestImpl(request);
    }

    public List<String> getValidUrls() {
        return this.validUrls;
    }

    public void setValidUrls(String urls) {
        this.validUrls = Arrays.asList(urls.split("\\s+"));
    }

    public HttpRequestImpl getHttpRequest() {
        return this.httpRequest;
    }

    public String printCookies(){
        StringBuilder sb = new StringBuilder();

        this.httpRequest.getCookies().stream().forEach(httpCookie -> {
            sb.append(httpCookie.getKey() + " <-> " + httpCookie.getValue())
                    .append(System.lineSeparator());
        });

        return sb.toString();
    }

    public String validateRequest(){
        String error = "";
        if (this.validUrls.contains(httpRequest.getRequestUrl())){
            if (!httpRequest.getHeaders().keySet().contains(Constants.AUTHORIZATION)) {
                error = Messages.ERROR_AUTHORIZATION;
                return printErrorRequest(error);
            } else if (httpRequest.getBodyParameters().size() == 0){
                error = Messages.ERROR_NO_BODY;
                return printErrorRequest(error);
            }
            else {
                return printRequest();
            }
        } else {
            error = Messages.ERROR_URL;
            return printErrorRequest(error);
        }
    }

    private String printRequest() {
        StringBuilder sb = new StringBuilder();
        byte[] decode = Base64.getDecoder()
                .decode(httpRequest.getHeaders()
                        .get(Constants.AUTHORIZATION)
                        .split("\\s")[1]);
        String username = new String(decode);

        sb.append(Messages.OK_MESSAGE)
                .append(System.lineSeparator())
                .append(printRequestHeaders())
                .append(getGreetingMessage(username));

        return sb.toString();
    }

    private String getGreetingMessage(String username) {
        StringBuilder sb = new StringBuilder();

        switch (this.httpRequest.getMethod()){
            case "POST" : sb.append(String.format(Messages.GREETINGS_BEGINNING_MESSAGE,
                    username,
                    getBodyParameter()));
            break;
            case "GET" : sb.append(String.format(Messages.GREETINGS_GET_MESSAGE, username));
            break;
        }
        return sb.toString();
    }

    private String getBodyParameter() {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (Map.Entry<String, String> entry : httpRequest.getBodyParameters().entrySet()) {
            switch (count){
                case 0 : sb.append(String.format(Messages.BODY_FIRST_PARAM, entry.getValue()));
                    count++;
                    break;
                case 1 : sb.append(String.format(Messages.BODY_SECOND_PARAM, entry.getKey(), entry.getValue()));
                    count++;
                    break;
                case 2 : sb.append(String.format(Messages.BODY_THIRD_PARAM, entry.getKey(), entry.getValue()));
                    count++;
                    break;
            }
        }

        return sb.toString();
    }

    private String printErrorRequest(String error) {
        StringBuilder sb = new StringBuilder();
        switch (error) {
            case Messages.ERROR_URL : sb.append(Messages.NOT_FOUND_RESPONSE)
                    .append(System.lineSeparator())
                    .append(printRequestHeaders())
                    .append(Messages.NOT_FOUND_MESSAGE);
                break;
            case Messages.ERROR_AUTHORIZATION : sb.append(Messages.NOT_AUTHORIZED_RESPONSE)
                    .append(System.lineSeparator())
                    .append(printRequestHeaders())
                    .append(Messages.NOT_AUTHORIZED_MESSAGE);
                break;
            case Messages.ERROR_NO_BODY : sb.append(Messages.BAD_REQUEST_RESPONSE)
                    .append(System.lineSeparator())
                    .append(printRequestHeaders())
                    .append(Messages.BAD_REQUEST_MESSAGE);
                break;
        }

        return sb.toString();
    }

    private String printRequestHeaders() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
            if ((entry.getKey().equals(Constants.DATE) || entry.getKey().equals(Constants.HOST))
                    || entry.getKey().equals(Constants.CONTENT_TYPE)) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(System.lineSeparator());
            }
        }

        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
