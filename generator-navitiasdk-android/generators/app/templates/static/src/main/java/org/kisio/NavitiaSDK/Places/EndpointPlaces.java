package org.kisio.NavitiaSDK.Places;

import org.kisio.NavitiaSDK.NavitiaConfiguration;

public class EndpointPlaces {
    private NavitiaConfiguration navitiaConfiguration;

    public EndpointPlaces(NavitiaConfiguration navitiaConfiguration) {
        this.navitiaConfiguration = navitiaConfiguration;
    }

    public EndpointRequestBuilderPlaces newRequestBuilder() {
        return new EndpointRequestBuilderPlaces(this.navitiaConfiguration);
    }
}