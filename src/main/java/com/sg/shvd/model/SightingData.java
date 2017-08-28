/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class SightingData {

    private int superSomeoneSightingDataID;
    private int locationID;
    private String superSomeoneSightingDescription;
    private LocalDate superSomeoneSightingDate;
    List<SuperSomeone> superSomeoneList;
    Location location;
    

    public int getSuperSomeoneSightingDataID() {
        return superSomeoneSightingDataID;
    }

    public void setSuperSomeoneSightingDataID(int superSomeoneSightingDataID) {
        this.superSomeoneSightingDataID = superSomeoneSightingDataID;
    }

    public int getLocationID() {
        return locationID;
    }
    
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public LocalDate getSuperSomeoneSightingDate() {
        return superSomeoneSightingDate;
    }

    public void setSuperSomeoneSightingDate(LocalDate superSomeoneSightingDate) {
        this.superSomeoneSightingDate = superSomeoneSightingDate;
    }

    public String getSuperSomeoneSightingDescription() {
        return superSomeoneSightingDescription;
    }

    public void setSuperSomeoneSightingDescription(String superSomeoneSightingDescription) {
        this.superSomeoneSightingDescription = superSomeoneSightingDescription;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<SuperSomeone> getSuperSomeoneList() {
        return superSomeoneList;
    }

    public void setSuperSomeoneList(List<SuperSomeone> superSomeoneList) {
        this.superSomeoneList = superSomeoneList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.superSomeoneSightingDataID;
        hash = 53 * hash + this.locationID;
        hash = 53 * hash + Objects.hashCode(this.superSomeoneSightingDescription);
        hash = 53 * hash + Objects.hashCode(this.superSomeoneSightingDate);
        hash = 53 * hash + Objects.hashCode(this.superSomeoneList);
        hash = 53 * hash + Objects.hashCode(this.location);
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
        final SightingData other = (SightingData) obj;
        if (this.superSomeoneSightingDataID != other.superSomeoneSightingDataID) {
            return false;
        }
        if (this.locationID != other.locationID) {
            return false;
        }
        if (!Objects.equals(this.superSomeoneSightingDescription, other.superSomeoneSightingDescription)) {
            return false;
        }
        if (!Objects.equals(this.superSomeoneSightingDate, other.superSomeoneSightingDate)) {
            return false;
        }
        if (!Objects.equals(this.superSomeoneList, other.superSomeoneList)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

}
