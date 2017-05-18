package org.kisio.NavitiaSDK;

public class NavitiaConfiguration {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private String token = "";
    private String baseUrl = "https://api.navitia.io/v1";

    public NavitiaConfiguration(String token) {
        this.token = token;
    }
}
