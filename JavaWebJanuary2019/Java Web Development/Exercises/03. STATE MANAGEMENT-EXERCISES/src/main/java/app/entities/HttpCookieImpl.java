package main.java.app.entities;

import main.java.app.contracts.HttpCookie;

/**
 * Created by Nino Bonev - 25.1.2019 г., 10:54
 */
public class HttpCookieImpl implements HttpCookie {

    private String key;
    private String value;

    public HttpCookieImpl(String key, String value) {
        this.setKey(key);
        this.setValue(value);
    }

    @Override
    public String getKey() {
        return this.key;
    }

    private void setKey(String key) {
        this.key = key;
    }

    private void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
