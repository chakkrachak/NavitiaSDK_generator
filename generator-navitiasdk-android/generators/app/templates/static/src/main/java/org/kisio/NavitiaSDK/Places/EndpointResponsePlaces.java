
package org.kisio.NavitiaSDK.Places;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.kisio.NavitiaSDK.Models.Place;
import org.kisio.NavitiaSDK.Models.Warning;

public class EndpointResponsePlaces {

    @SerializedName("links")
    @Expose
    private List<Object> links = new ArrayList<Object>();
    @SerializedName("places")
    @Expose
    private List<Place> places = new ArrayList<Place>();
    @SerializedName("warnings")
    @Expose
    private List<Warning> warnings = new ArrayList<Warning>();

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Warning> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Warning> warnings) {
        this.warnings = warnings;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(links).append(places).append(warnings).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EndpointResponsePlaces) == false) {
            return false;
        }
        EndpointResponsePlaces rhs = ((EndpointResponsePlaces) other);
        return new EqualsBuilder().append(links, rhs.links).append(places, rhs.places).append(warnings, rhs.warnings).isEquals();
    }

}
