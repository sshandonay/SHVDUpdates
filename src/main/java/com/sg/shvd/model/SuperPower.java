/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class SuperPower {
    private int superPowerID;
    private String superPowerName;
    private String superPowerDescription;

    public int getSuperPowerID() {
        return superPowerID;
    }

    public void setSuperPowerID(int superPowerID) {
        this.superPowerID = superPowerID;
    }

    public String getSuperPowerName() {
        return superPowerName;
    }

    public void setSuperPowerName(String superPowerName) {
        this.superPowerName = superPowerName;
    }

    public String getSuperPowerDescription() {
        return superPowerDescription;
    }

    public void setSuperPowerDescription(String superPowerDescription) {
        this.superPowerDescription = superPowerDescription;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.superPowerID;
        hash = 47 * hash + Objects.hashCode(this.superPowerName);
        hash = 47 * hash + Objects.hashCode(this.superPowerDescription);
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
        final SuperPower other = (SuperPower) obj;
        if (this.superPowerID != other.superPowerID) {
            return false;
        }
        if (!Objects.equals(this.superPowerName, other.superPowerName)) {
            return false;
        }
        if (!Objects.equals(this.superPowerDescription, other.superPowerDescription)) {
            return false;
        }
        return true;
    }
    
    
}
