package org.kisio.NavitiaSDK;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.kisio.NavitiaSDK.Places.EndpointResponsePlaces;
import org.kisio.NavitiaSDK.Places.EndpointRequestBuilderPlaces;

import javax.xml.ws.http.HTTPException;

import static org.junit.Assert.*;

public class NavitiaSDKTest {
    @Test
    public void shouldInstantiateGivenValidConfiguration() throws Exception {
        NavitiaSDK navitiaSDK = new NavitiaSDK(new NavitiaConfiguration("takotak"));

        assertNotNull(navitiaSDK);
        assertNotNull(navitiaSDK.getConfiguration());
        assertEquals("takotak", navitiaSDK.getConfiguration().getToken());
        assertNotNull(navitiaSDK.getEndpoints());
        assertNotNull(navitiaSDK.getEndpoints().getPlaces());
        assertNotNull(navitiaSDK.getFeatures());
        assertNotNull(navitiaSDK.getFeatures().getAutoComplete());
    }

    @Test
    public void shouldRetrieveEndpointPlacesResultsGivenValidConfiguration() throws Exception {
        NavitiaSDK navitiaSDK = new NavitiaSDK(new NavitiaConfiguration("9e304161-bb97-4210-b13d-c71eaf58961c"));

        final String[] result = new String[1];
        navitiaSDK.getEndpoints().getPlaces()
                .newRequestBuilder().withQ("gare").withCount(10)
                .rawGet(
                        new BaseNavitiaRequestBuilder.BaseRequestCallback() {
                            @Override
                            public void callback(JSONObject jsonObject) {
                                result[0] = (String) ((JSONObject) ((JSONArray) jsonObject.get("places")).get(0)).get("name");
                            }
                        },
                        new BaseNavitiaRequestBuilder.ErrorRequestCallback() {
                            @Override
                            public void callback(ResourceRequestError resourceRequestError) {
                            }
                        }
                );

        assertEquals("Garein", result[0]);
    }

    @Test
    public void shouldLaunchErrorGivenInvalidConfigurationWithRawGet() throws Exception {
        NavitiaSDK navitiaSDK = new NavitiaSDK(new NavitiaConfiguration(""));

        final ResourceRequestError[] resultError = new ResourceRequestError[1];
        navitiaSDK.getEndpoints().getPlaces()
                .newRequestBuilder().withQ("gare").withCount(10)
                .rawGet(
                        new BaseNavitiaRequestBuilder.BaseRequestCallback() {
                            @Override
                            public void callback(JSONObject jsonObject) {
                            }
                        },
                        new BaseNavitiaRequestBuilder.ErrorRequestCallback() {
                            @Override
                            public void callback(ResourceRequestError resourceRequestError) {
                                resultError[0] = resourceRequestError;
                            }
                        });

        assertEquals(401, resultError[0].getHttpStatusCode());
        assertEquals("Invalid http status code 401", resultError[0].getMessage());
        assertNotNull(resultError[0].getInnerException());
        assertEquals(401, ((HTTPException)resultError[0].getInnerException()).getStatusCode());
    }

    @Test
    public void shouldLaunchErrorGivenInvalidConfigurationWithGet() throws Exception {
        NavitiaSDK navitiaSDK = new NavitiaSDK(new NavitiaConfiguration(""));

        final ResourceRequestError[] resultError = new ResourceRequestError[1];
        navitiaSDK.getEndpoints().getPlaces()
                .newRequestBuilder().withQ("gare").withCount(10)
                .get(
                        new EndpointRequestBuilderPlaces.PlacesRequestCallback() {
                            @Override
                            public void callback(EndpointResponsePlaces endpointResponsePlaces) {
                            }
                        },
                        new BaseNavitiaRequestBuilder.ErrorRequestCallback() {
                            @Override
                            public void callback(ResourceRequestError resourceRequestError) {
                                resultError[0] = resourceRequestError;
                            }
                        });

        assertEquals(401, resultError[0].getHttpStatusCode());
        assertEquals("Invalid http status code 401", resultError[0].getMessage());
        assertNotNull(resultError[0].getInnerException());
        assertEquals(401, ((HTTPException)resultError[0].getInnerException()).getStatusCode());
    }

    @Test
    public void shouldRetrieveEndpointPlacesObjectResultsGivenValidConfiguration() throws Exception {
        NavitiaSDK navitiaSDK = new NavitiaSDK(new NavitiaConfiguration("9e304161-bb97-4210-b13d-c71eaf58961c"));

        final String[] result = new String[1];
        navitiaSDK.getEndpoints().getPlaces()
                .newRequestBuilder().withQ("gare").withCount(10)
                .get(
                        new EndpointRequestBuilderPlaces.PlacesRequestCallback() {
                            @Override
                            public void callback(EndpointResponsePlaces endpointResponsePlaces) {
                                result[0] = endpointResponsePlaces.getPlaces().get(0).getName();
                            }
                        },
                        new BaseNavitiaRequestBuilder.ErrorRequestCallback() {
                            @Override
                            public void callback(ResourceRequestError resourceRequestError) {
                            }
                        }
                );

        assertEquals("Garein", result[0]);
    }

    @Test
    public void shouldFormatUrlGivenQueryParametersForEndpointPlaces() throws Exception {
        NavitiaSDK navitiaSDK = new NavitiaSDK(new NavitiaConfiguration("9e304161-bb97-4210-b13d-c71eaf58961c"));

        String url = navitiaSDK.getEndpoints().getPlaces()
                .newRequestBuilder()
                .withQ("gare")
                .withCount(10)
                .getUrl();

        assertEquals("https://api.navitia.io/v1/places?count=10&q=gare&", url);
    }
}