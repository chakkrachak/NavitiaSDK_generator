
package org.kisio.NavitiaSDK.Models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdministrativeRegion {

    @SerializedName("insee")
    @Expose
    private String insee;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("administrative_regions")
    @Expose
    private List<Object> administrativeRegions = new ArrayList<Object>();
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("label")
    @Expose
    private String label;

    public String getInsee() {
        return insee;
    }

    public void setInsee(String insee) {
        this.insee = insee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getAdministrativeRegions() {
        return administrativeRegions;
    }

    public void setAdministrativeRegions(List<Object> administrativeRegions) {
        this.administrativeRegions = administrativeRegions;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(insee).append(name).append(administrativeRegions).append(level).append(zipCode).append(id).append(coord).append(label).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdministrativeRegion) == false) {
            return false;
        }
        AdministrativeRegion rhs = ((AdministrativeRegion) other);
        return new EqualsBuilder().append(insee, rhs.insee).append(name, rhs.name).append(administrativeRegions, rhs.administrativeRegions).append(level, rhs.level).append(zipCode, rhs.zipCode).append(id, rhs.id).append(coord, rhs.coord).append(label, rhs.label).isEquals();
    }

}
