/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Location {

    private int locationID;
    private String locationName;
    private String locationDescription;
    private String locationStreet;
    private String locationCity;
    private String locationState;
    private String locationCountry;
    private BigDecimal locationLatitude;
    private BigDecimal locationLongitude;


    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationStreet() {
        return locationStreet;
    }

    public void setLocationStreet(String locationStreet) {
        this.locationStreet = locationStreet;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public BigDecimal getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(BigDecimal locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public BigDecimal getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(BigDecimal locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

//    public List<SuperSomeone> getSuperSomeoneList() {
//        return superSomeoneList;
//    }
//
//    public void setSuperSomeoneList(List<SuperSomeone> superSomeoneList) {
//        this.superSomeoneList = superSomeoneList;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.locationID;
        hash = 41 * hash + Objects.hashCode(this.locationName);
        hash = 41 * hash + Objects.hashCode(this.locationDescription);
        hash = 41 * hash + Objects.hashCode(this.locationStreet);
        hash = 41 * hash + Objects.hashCode(this.locationCity);
        hash = 41 * hash + Objects.hashCode(this.locationState);
        hash = 41 * hash + Objects.hashCode(this.locationCountry);
        hash = 41 * hash + Objects.hashCode(this.locationLatitude);
        hash = 41 * hash + Objects.hashCode(this.locationLongitude);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.locationID != other.locationID) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.locationStreet, other.locationStreet)) {
            return false;
        }
        if (!Objects.equals(this.locationCity, other.locationCity)) {
            return false;
        }
        if (!Objects.equals(this.locationState, other.locationState)) {
            return false;
        }
        if (!Objects.equals(this.locationCountry, other.locationCountry)) {
            return false;
        }
        if (!Objects.equals(this.locationLatitude, other.locationLatitude)) {
            return false;
        }
        if (!Objects.equals(this.locationLongitude, other.locationLongitude)) {
            return false;
        }
        return true;
    }

}
