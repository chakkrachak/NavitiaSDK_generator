package org.kisio.NavitiaSDK;

import org.junit.Test;

import static org.junit.Assert.*;

public class NavitiaConfigurationTest {
    @Test
    public void shouldInstantiateGivenNotEmptyToken() throws Exception {
        NavitiaConfiguration navitiaConfiguration = new NavitiaConfiguration("toktok");

        assertEquals("https://api.navitia.io/v1", navitiaConfiguration.getBaseUrl());
        assertEquals("toktok", navitiaConfiguration.getToken());
    }
}