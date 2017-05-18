
package org.kisio.NavitiaSDK.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Place {

    @SerializedName("embedded_type")
    @Expose
    private String embeddedType;
    @SerializedName("quality")
    @Expose
    private Integer quality;
    @SerializedName("administrative_region")
    @Expose
    private AdministrativeRegion administrativeRegion;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getEmbeddedType() {
        return embeddedType;
    }

    public void setEmbeddedType(String embeddedType) {
        this.embeddedType = embeddedType;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public AdministrativeRegion getAdministrativeRegion() {
        return administrativeRegion;
    }

    public void setAdministrativeRegion(AdministrativeRegion administrativeRegion) {
        this.administrativeRegion = administrativeRegion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(embeddedType).append(quality).append(administrativeRegion).append(id).append(name).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Place) == false) {
            return false;
        }
        Place rhs = ((Place) other);
        return new EqualsBuilder().append(embeddedType, rhs.embeddedType).append(quality, rhs.quality).append(administrativeRegion, rhs.administrativeRegion).append(id, rhs.id).append(name, rhs.name).isEquals();
    }

}
