/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author apprentice
 */
public class SuperSomeone {
    private int superSomeoneID;
    private String superSomeoneType;
    private String superSomeoneName;
    private String superSomeoneAlias;
    private String superSomeoneDescription;
    private List<SuperPower> superPowerList;

    
    
    public int getSuperSomeoneID() {
        return superSomeoneID;
    }

    public String getSuperSomeoneType() {
        return superSomeoneType;
    }

    public String getSuperSomeoneName() {
        return superSomeoneName;
    }

    public String getSuperSomeoneAlias() {
        return superSomeoneAlias;
    }

    public String getSuperSomeoneDescription() {
        return superSomeoneDescription;
    }

    public List<SuperPower> getSuperPowerList() {
        return superPowerList;
    }

    public void setSuperPowerList(List<SuperPower> superPowerList) {
        this.superPowerList = superPowerList;
    }

    public void setSuperSomeoneID(int superSomeoneID) {
        this.superSomeoneID = superSomeoneID;
    }

    public void setSuperSomeoneType(String superSomeoneType) {
        this.superSomeoneType = superSomeoneType;
    }

    public void setSuperSomeoneName(String superSomeoneName) {
        this.superSomeoneName = superSomeoneName;
    }

    public void setSuperSomeoneAlias(String superSomeoneAlias) {
        this.superSomeoneAlias = superSomeoneAlias;
    }

    public void setSuperSomeoneDescription(String superSomeoneDescription) {
        this.superSomeoneDescription = superSomeoneDescription;
    }


    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.superSomeoneID;
        hash = 97 * hash + Objects.hashCode(this.superSomeoneType);
        hash = 97 * hash + Objects.hashCode(this.superSomeoneName);
        hash = 97 * hash + Objects.hashCode(this.superSomeoneAlias);
        hash = 97 * hash + Objects.hashCode(this.superSomeoneDescription);
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
        final SuperSomeone other = (SuperSomeone) obj;
        if (this.superSomeoneID != other.superSomeoneID) {
            return false;
        }
        if (!Objects.equals(this.superSomeoneType, other.superSomeoneType)) {
            return false;
        }
        if (!Objects.equals(this.superSomeoneName, other.superSomeoneName)) {
            return false;
        }
        if (!Objects.equals(this.superSomeoneAlias, other.superSomeoneAlias)) {
            return false;
        }
        if (!Objects.equals(this.superSomeoneDescription, other.superSomeoneDescription)) {
            return false;
        }
        return true;
    }
    
    
    
}
