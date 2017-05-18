package org.kisio.NavitiaSDK;

import org.kisio.NavitiaSDK.Places.EndpointPlaces;

public class NavitiaFeatures {
    private NavitiaConfiguration navitiaConfiguration;
    private EndpointPlaces autoComplete;

    public EndpointPlaces getAutoComplete() {
        return autoComplete;
    }

    public NavitiaFeatures(NavitiaConfiguration navitiaConfiguration) {
        this.navitiaConfiguration = navitiaConfiguration;
        this.autoComplete = new EndpointPlaces(this.navitiaConfiguration);
    }
}
