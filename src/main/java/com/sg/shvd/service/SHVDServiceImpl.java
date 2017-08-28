/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.service;

import com.sg.shvd.dao.SHVDDao;
import com.sg.shvd.model.Location;
import com.sg.shvd.model.Organization;
import com.sg.shvd.model.SightingData;
import com.sg.shvd.model.SuperPower;
import com.sg.shvd.model.SuperSomeone;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.swing.JOptionPane;

/**
 *
 * @author Spennyboy
 */
public class SHVDServiceImpl implements SHVDService {

    private SHVDDao shvdDao;

    @Inject
    public SHVDServiceImpl(SHVDDao shvdDao) {
        this.shvdDao = shvdDao;
    }

    @Override
    public void addSuperSomeone(SuperSomeone superSomeone) {
        shvdDao.addSuperSomeone(superSomeone);
    }

    @Override
    public void deleteSuperSomeone(int superSomeoneID) {
        shvdDao.deleteSuperSomeone(superSomeoneID);
    }

    @Override
    public void updateSuperSomeone(SuperSomeone superSomeone) {
        shvdDao.updateSuperSomeone(superSomeone);
    }

    @Override
    public SuperSomeone getSuperSomeoneByID(int superSomeoneID) {
        return shvdDao.getSuperSomeoneByID(superSomeoneID);
    }
   
    //
    @Override
    public void updateSuperSomeoneSuperPowers(SuperSomeone superSomeone, List<Integer> superPowerIDs) {
        List<SuperPower> superPowers = new ArrayList<>();
        for (Integer s : superPowerIDs) {
            superPowers.add(shvdDao.getSuperPowerByID(s));
        }
        superSomeone.setSuperPowerList(superPowers);

        shvdDao.updateSuperSomeone(superSomeone);

    }

    @Override
    public List<SuperSomeone> getAllSuperSomeones() {
        return shvdDao.getAllSuperSomeones();
    }



    @Override
    public List<SuperSomeone> getSuperSomeonesByIDs(String[] superSomeoneIDs) {

        List<SuperSomeone> superSomeones = new ArrayList<>();

        for (String superSomeoneID : superSomeoneIDs) {
            superSomeones.add(shvdDao.getSuperSomeoneByID(Integer.parseInt(superSomeoneID)));
        }

        return superSomeones;
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        shvdDao.addSuperPower(superPower);
    }

    @Override
    public void deleteSuperPower(int superPowerID) {
        shvdDao.deleteSuperPower(superPowerID);

    }

    @Override
    public void updateSuperPower(SuperPower superPower) {
        shvdDao.updateSuperPower(superPower);
    }

    @Override
    public SuperPower getSuperPowerByID(int superPowerID) {
        return shvdDao.getSuperPowerByID(superPowerID);
    }

    @Override
    public List<SuperPower> getAllSuperPowers() {
        return shvdDao.getAllSuperPowers();
    }

    @Override
    public List<SuperPower> getSuperPowersByIDs(String[] superPowerIDs) {

        List<SuperPower> superPowers = new ArrayList<>();
        for (String superPowerID : superPowerIDs) {
            superPowers.add(shvdDao.getSuperPowerByID(Integer.parseInt(superPowerID)));
        }
        return superPowers;

    }

    @Override
    public void addOrganization(Organization organization) {
        shvdDao.addOrganization(organization);
    }

    @Override
    public void deleteOrganization(int organizationID) {
        shvdDao.deleteOrganization(organizationID);
    }

    @Override
    public void updateOrganization(Organization organization) {
        shvdDao.updateOrganization(organization);

    }

    @Override
    public Organization getOrganizationByID(int OrganizationID) {
        return shvdDao.getOrganizationByID(OrganizationID);

    }

    @Override
    public List<Organization> getAllOrganizations() {
        return shvdDao.getAllOrganizations();
    }

    @Override
    public List<Organization> getOrganizationsBySuperSomeone(int superSomeoneID) {
        return shvdDao.getOrganizationsBySuperSomeone(superSomeoneID);
    }

    @Override
    public void addSightingData(SightingData sightingData) {
        shvdDao.addSightingData(sightingData);
    }

    @Override
    public void deleteSightingData(int superSomeoneSightingDataID) {
        shvdDao.deleteSightingData(superSomeoneSightingDataID);
    }

    @Override
    public void updateSightingData(SightingData sightingData) {
        shvdDao.updateSightingData(sightingData);
    }

    @Override
    public SightingData getSightingDataByID(int sightingDataID) {
        return shvdDao.getSightingDataByID(sightingDataID);
    }

    @Override
    public List<SightingData> getAllSuperSomeoneSightings() {
        return shvdDao.getAllSightingData();
    }


    @Override
    public void addLocation(Location location) {
        shvdDao.addLocation(location);
    }


    @Override
    public void deleteLocation(int locationID) {
//        boolean deleteCheck = false;
//        List<SightingData> allSightingLocations = shvdDao.getAllSightingData();
//        for (SightingData currentSightingLocation : allSightingLocations) {
//            if (currentSightingLocation.getLocationID() == locationID) {
//           // if (currentSightingLocation.getLocation().getLocationID() == locationID) {
//                deleteCheck = true;
//            }
//        }
//
//        List<Organization> allOrganizations = shvdDao.getAllOrganizations();
//       
//        List<Location> allLocationsOfOrgs = new ArrayList<>();
//        for (Organization currentOrganization : allOrganizations) {
//            allLocationsOfOrgs.addAll(currentOrganization.getLocationList());
//        }
//
//        for (Location currentLocation : allLocationsOfOrgs) {
//            if (currentLocation.getLocationID() == locationID) {
//                deleteCheck = true;
//            }
//        }
//
//        if (deleteCheck) {
//            JOptionPane.showMessageDialog(null, "Location is linked to sighting - cannot delete");
//        } else {
            shvdDao.deleteLocation(locationID);
        //}
    }

    @Override
    public void updateLocation(Location location) {
        shvdDao.updateLocation(location);
    }

    @Override
    public Location getLocationByID(int locationID) {
        return shvdDao.getLocationByID(locationID);
    }

    @Override
    public List<Location> getAllLocations() {
        return shvdDao.getAllLocations();
    }


    @Override
    public List<Location> getLocationsByIDs(String[] locationIDs) {
        List<Location> locations = new ArrayList<>();
        for (String locationID : locationIDs) {
            locations.add(shvdDao.getLocationByID(Integer.parseInt(locationID)));
        }

        return locations;
    }

    @Override
    public List<SightingData> showTopSightings() {
        return shvdDao.showTopSightings();
    }

}
