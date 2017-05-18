package org.kisio.NavitiaSDK.Places;

import org.json.simple.parser.ParseException;
import org.kisio.NavitiaSDK.BaseNavitiaRequestBuilder;
import org.kisio.NavitiaSDK.NavitiaConfiguration;
import org.kisio.NavitiaSDK.ResourceRequestError;

import java.io.IOException;

public class EndpointRequestBuilderPlaces extends BaseNavitiaRequestBuilder {
    public EndpointRequestBuilderPlaces(NavitiaConfiguration navitiaConfiguration) {
        super(navitiaConfiguration, "/places", EndpointResponsePlaces.class);
    }

    public EndpointRequestBuilderPlaces withQ(String q) {
        this.addQueryParameter("q", q);
        return this;
    }

    public EndpointRequestBuilderPlaces withCount(int count) {
        this.addQueryParameter("count", String.valueOf(count));
        return this;
    }

    public interface PlacesRequestCallback {
        void callback(EndpointResponsePlaces endpointResponsePlaces);
    }

    public void get(final PlacesRequestCallback placesRequestCallback, final ErrorRequestCallback errorRequestCallback) throws IOException, ParseException {
        get(
                new ModelRequestCallback<EndpointResponsePlaces>() {
                    @Override
                    public void callback(EndpointResponsePlaces endpointResponsePlaces) {
                        placesRequestCallback.callback(endpointResponsePlaces);
                    }
                },
                new ErrorRequestCallback() {
                    @Override
                    public void callback(ResourceRequestError resourceRequestError) {
                        errorRequestCallback.callback(resourceRequestError);
                    }
                }
        );
    }
}
