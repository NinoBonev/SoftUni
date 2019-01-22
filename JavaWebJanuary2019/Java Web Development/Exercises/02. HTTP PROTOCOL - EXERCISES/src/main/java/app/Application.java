package main.java.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nino Bonev - 20.1.2019 г., 15:06
 */
public class Application {

    private static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<String> validUrls = getValidUrls();
        List<String> request = getRequest();

        String method = getMethod(request.get(0));
        String url = getUrl(request.get(0));

        Map<String, String> headers = getHeaders(request);
        Map<String, String> body = getBody(request);

        System.out.println(validateRequest(validUrls, url, headers, body, method));
    }

    private static List<String> getRequest() throws IOException {
        List<String> request = new ArrayList<>();

        String line = null;

        while ((line = reader.readLine()) != null && line.length() > 0){
            request.add(line);
        }

        request.add(System.lineSeparator());

        if ((line = reader.readLine()) != null && line.length() > 0){
            request.add(line);
        }

        return request;

    }

    private static List<String> getValidUrls() throws IOException {
        return Arrays.asList(reader.readLine().split("\\s+"));
    }

    private static String getMethod(String line) {
        return line.split("\\s+")[0];
    }

    private static String getUrl(String line) {
        return line.split("\\s+")[1];
    }

    private static Map<String, String> getHeaders(List<String> request) {
        Map<String, String> headers = new LinkedHashMap<>();

        request.stream()
                .skip(1)
                .filter(h -> h.contains(": "))
                .map(h -> h.split(": "))
                .forEach(headerKVP -> {
                    headers.put(headerKVP[0], headerKVP[1]);
                });

        return headers;
    }

    private static Map<String, String> getBody(List<String> request) {
        Map<String, String> body = new LinkedHashMap<>();
        String line = request.get(request.size() - 1);

        if (line.equals(System.lineSeparator())){
            return body;
        }

        Arrays.stream(line
                .split("&"))
                .map(bodyPM ->
                        bodyPM.split("="))
                .forEach(bpKVP -> {
                    body.put(bpKVP[0], bpKVP[1]);
                });

        return body;
    }

    private static String validateRequest(List<String> urls, String url, Map<String, String> headers,
                                          Map<String, String> body, String method){
        String error = "";
        if (urls.contains(url)){
            if (!headers.keySet().contains("Authorization")) {
                error = "errorAuthorization";
                return printErrorRequest(headers, error);
            } else if (body.size() == 0){
                error = "noBody";
                return printErrorRequest(headers, error);
            }
              else {
                return printRequest(headers, body, method);
            }
        } else {
            error = "errorUrl";
            return printErrorRequest(headers, error);
        }
    }

    private static String printRequest(Map<String,String> headers, Map<String, String> body, String method) {
        StringBuilder sb = new StringBuilder();
        byte[] decode = Base64.getDecoder().decode(headers.get("Authorization").split("\\s")[1]);
        String username = new String(decode);

        sb.append("HTTP/1.1 200 OK")
                .append(System.lineSeparator())
                .append(printRequestHeaders(headers))
                .append(printGreetingMessage(username, body, method));

        return sb.toString();
    }

    private static String printGreetingMessage(String username, Map<String, String> body, String method) {
        StringBuilder sb = new StringBuilder();
        switch (method) {
            case "POST" : sb.append(String.format("Greetings %s! You have successfully created %s.", username, getBodyParameter(body))); break;
            case "GET" : sb.append(String.format("Greetings %s!", username)); break;
        }

        return sb.toString();
    }

    private static String getBodyParameter(Map<String, String> body) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (Map.Entry<String, String> entry : body.entrySet()) {
            switch (count){
                case 0 : sb.append(String.format("%s with ", entry.getValue()));
                count++;
                break;
                case 1 : sb.append(String.format("%s - %s, ", entry.getKey(), entry.getValue()));
                count++;
                break;
                case 2 : sb.append(String.format("%s - %s", entry.getKey(), entry.getValue()));
                count++;
                break;
            }
        }

        return sb.toString();
    }

    private static String printErrorRequest(Map<String, String> headers, String error) {
        StringBuilder sb = new StringBuilder();
        switch (error) {
            case "errorUrl" : sb.append("HTTP/1.1 404 Not Found")
                    .append(System.lineSeparator())
                    .append(printRequestHeaders(headers))
                    .append("The requested functionality was not found.");
                    break;
            case "errorAuthorization" : sb.append("HTTP/1.1 401 Unauthorized")
                    .append(System.lineSeparator())
                    .append(printRequestHeaders(headers))
                    .append("You are not authorized to access the requested functionality.");
                    break;
            case "noBody" : sb.append("HTTP/1.1 400 Bad Request")
                    .append(System.lineSeparator())
                    .append(printRequestHeaders(headers))
                    .append("There was an error with the requested functionality due to malformed request.");
                    break;
        }

        return sb.toString();
    }

    private static String printRequestHeaders(Map<String, String> headers) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            if ((entry.getKey().equals("Date") || entry.getKey().equals("Host")) || entry.getKey().equals("Content-Type")) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(System.lineSeparator());
            }
        }

        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
