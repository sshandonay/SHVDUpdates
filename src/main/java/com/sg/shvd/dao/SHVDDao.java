/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.dao;

import com.sg.shvd.model.Location;
import com.sg.shvd.model.Organization;
import com.sg.shvd.model.SuperPower;
import com.sg.shvd.model.SuperSomeone;
import com.sg.shvd.model.SightingData;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SHVDDao {

    //Location CRUD
    public void addLocation(Location location);

    public void deleteLocation(int locationID);

    public void updateLocation(Location location);

    public Location getLocationByID(int locationID);

    public List<Location> getAllLocations();

    //Organization CRUD
    public void addOrganization(Organization organization);

    public void deleteOrganization(int organizationID);

    public void updateOrganization(Organization organization);

    public Organization getOrganizationByID(int organizationID);

    public List<Organization> getAllOrganizations();

    public List<Location> findLocationsForOrganization(Organization organization);

    //SuperPower CRUD
    public void addSuperPower(SuperPower superPower);

    public void deleteSuperPower(int superPowerID);

    public void updateSuperPower(SuperPower superPower);

    public SuperPower getSuperPowerByID(int superPowerID);

    public List<SuperPower> getAllSuperPowers();

    //SuperPower CRUD
    public void addSuperSomeone(SuperSomeone superSomeone);

    public void deleteSuperSomeone(int superSomeoneID);

    public void updateSuperSomeone(SuperSomeone superSomeone);

    public SuperSomeone getSuperSomeoneByID(int superSomeoneID);

    public List<SuperSomeone> getAllSuperSomeones();

    //SuperSomeoneSighting CRUD
    public void addSightingData(SightingData sightingData);

    public void deleteSightingData(int superSomeoneSightingDataID);

    public void updateSightingData(SightingData sightingData);

    public SightingData getSightingDataByID(int superSomeoneSightingData);

    public List<SightingData> getAllSightingData();

    public List<SightingData> showTopSightings();

//
    public List<Organization> getOrganizationsBySuperSomeone(int superSomeoneID);

}
