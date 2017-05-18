package org.kisio.NavitiaSDK;

public class NavitiaSDK {
    private NavitiaConfiguration configuration;
    private NavitiaEndpoints endpoints;
    private NavitiaFeatures features;

    public NavitiaConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(NavitiaConfiguration configuration) {
        this.configuration = configuration;
    }

    public NavitiaEndpoints getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(NavitiaEndpoints endpoints) {
        this.endpoints = endpoints;
    }

    public NavitiaFeatures getFeatures() {
        return features;
    }

    public void setFeatures(NavitiaFeatures features) {
        this.features = features;
    }

    public NavitiaSDK(NavitiaConfiguration configuration) {
        this.configuration = configuration;
        this.endpoints = new NavitiaEndpoints(this.configuration);
        this.features = new NavitiaFeatures(this.configuration);
    }
}
