/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.service;

import com.sg.shvd.model.Location;
import com.sg.shvd.model.Organization;
import com.sg.shvd.model.SightingData;
import com.sg.shvd.model.SuperPower;
import com.sg.shvd.model.SuperSomeone;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Spennyboy
 */
public interface SHVDService {

    public void addSuperSomeone(SuperSomeone superSomeone);

    public void deleteSuperSomeone(int superSomeoneID);

    public void updateSuperSomeone(SuperSomeone superSomeone);

    public SuperSomeone getSuperSomeoneByID(int superSomeoneID);

    public void updateSuperSomeoneSuperPowers(SuperSomeone superSomeone, List<Integer> superPowerIDs);

    public List<SuperSomeone> getAllSuperSomeones();

    public List<SuperSomeone> getSuperSomeonesByIDs(String[] superSomeoneIDs);

//
    public void addSuperPower(SuperPower superPower);

    public void deleteSuperPower(int superPowerID);

    public void updateSuperPower(SuperPower superPower);

    public SuperPower getSuperPowerByID(int superPowerID);

    public List<SuperPower> getAllSuperPowers();

    public List<SuperPower> getSuperPowersByIDs(String[] superPowerIDs);

//
    public void addOrganization(Organization organization);

    public void deleteOrganization(int organizationID);

    public void updateOrganization(Organization organization);

    public Organization getOrganizationByID(int OrganizationID);

    public List<Organization> getAllOrganizations();

    public List<Organization> getOrganizationsBySuperSomeone(int superSomeoneID);

//
    public void addSightingData(SightingData sightingData);

    public void deleteSightingData(int superSomeoneSightingDataID);

    public void updateSightingData(SightingData sightingData);
    
    public SightingData getSightingDataByID (int sightingDataID);

    public List<SightingData> getAllSuperSomeoneSightings();

//
    public void addLocation(Location location);

    public void deleteLocation(int locationID);

    public void updateLocation(Location location);

    public Location getLocationByID(int locationID);

    public List<Location> getAllLocations();

  //

    public List<Location> getLocationsByIDs(String[] locationIDs);
    
    public List<SightingData> showTopSightings();

}
