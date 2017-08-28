/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Organization {

    private int organizationID;
    private String organizationType;
    private String organizationName;
    private String organizationDescription;
    private String organizationContact;
    List<Location> locationList;
    List<SuperSomeone> memberList;

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationContact() {
        return organizationContact;
    }

    public void setOrganizationContact(String organizationContact) {
        this.organizationContact = organizationContact;

    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<SuperSomeone> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<SuperSomeone> memberList) {
        this.memberList = memberList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.organizationID;
        hash = 11 * hash + Objects.hashCode(this.organizationType);
        hash = 11 * hash + Objects.hashCode(this.organizationName);
        hash = 11 * hash + Objects.hashCode(this.organizationDescription);
        hash = 11 * hash + Objects.hashCode(this.organizationContact);
        hash = 11 * hash + Objects.hashCode(this.locationList);
        hash = 11 * hash + Objects.hashCode(this.memberList);
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
        final Organization other = (Organization) obj;
        if (this.organizationID != other.organizationID) {
            return false;
        }
        if (!Objects.equals(this.organizationType, other.organizationType)) {
            return false;
        }
        if (!Objects.equals(this.organizationName, other.organizationName)) {
            return false;
        }
        if (!Objects.equals(this.organizationDescription, other.organizationDescription)) {
            return false;
        }
        if (!Objects.equals(this.organizationContact, other.organizationContact)) {
            return false;
        }
        if (!Objects.equals(this.locationList, other.locationList)) {
            return false;
        }
        if (!Objects.equals(this.memberList, other.memberList)) {
            return false;
        }
        return true;
    }

}
