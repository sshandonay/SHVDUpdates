/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.controller;

import com.sg.shvd.model.Location;
import com.sg.shvd.model.Organization;
import com.sg.shvd.model.SightingData;
import com.sg.shvd.model.SuperPower;
import com.sg.shvd.model.SuperSomeone;
import com.sg.shvd.service.SHVDService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class SHVDController {

    private SHVDService service;

    @Inject
    public SHVDController(SHVDService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        List<SightingData> topSightingList = service.showTopSightings();
        model.addAttribute("topSightingList", topSightingList);

        return "home";

    }

    @RequestMapping(value = "/displaySuperSomeonesPage", method = RequestMethod.GET)
    public String displaySuperSomeonesPage(Model model) {
        List<SuperPower> superPowerList = service.getAllSuperPowers();
        List<SuperSomeone> superSomeoneList = service.getAllSuperSomeones();
        model.addAttribute("superSomeoneList", superSomeoneList);
        model.addAttribute("superPowerList", superPowerList);
        return "superSomeones";

    }

    @RequestMapping(value = "/createSuperSomeone", method = RequestMethod.POST)
    public String createSuperSomeone(HttpServletRequest request) {

        SuperSomeone superSomeone = new SuperSomeone();

        superSomeone.setSuperSomeoneName(request.getParameter("superSomeoneName"));
        superSomeone.setSuperSomeoneType(request.getParameter("superSomeoneType"));
        superSomeone.setSuperSomeoneAlias(request.getParameter("superSomeoneAlias"));
        superSomeone.setSuperSomeoneDescription(request.getParameter("superSomeoneDescription"));

        List<SuperPower> superSomeoneSuperPowers = new ArrayList<SuperPower>();

        String[] superPowers = request.getParameterValues("superSomeoneSuperPower");
        int superPowerString;

        for (String currentString : superPowers) {
            try {
                superPowerString = Integer.parseInt(currentString);
                if (superPowerString >= 0) {
                    superSomeoneSuperPowers.add(service.getSuperPowerByID(superPowerString));
                    superSomeone.setSuperPowerList(superSomeoneSuperPowers);

                }
            } catch (NumberFormatException e) {
                superSomeone.setSuperPowerList(null);
            }

        }

        service.addSuperSomeone(superSomeone);

        return "redirect:displaySuperSomeonesPage";
    }

    @RequestMapping(value = "/displaySuperSomeoneDetails", method = RequestMethod.GET)
    public String displaySuperSomeoneDetails(HttpServletRequest request, Model model) {
        String superSomeoneIDParameter = request.getParameter("superSomeoneID");
        int superSomeoneID = Integer.parseInt(superSomeoneIDParameter);

        SuperSomeone superSomeone = service.getSuperSomeoneByID(superSomeoneID);

        model.addAttribute("superSomeone", superSomeone);

        return "superSomeoneDetails";
    }

    @RequestMapping(value = "/displaySuperSomeoneEdit", method = RequestMethod.GET)
    public String displaySuperSomeoneEdit(HttpServletRequest request, Model model) {
        String superSomeoneIDParameter = request.getParameter("superSomeoneID");
        int superSomeoneID = Integer.parseInt(superSomeoneIDParameter);

        SuperSomeone superSomeone = service.getSuperSomeoneByID(superSomeoneID);

        List<SuperPower> notSuperPowers = service.getAllSuperPowers();
        List<SuperPower> superPowers = superSomeone.getSuperPowerList();
        notSuperPowers.removeAll(superPowers);

        model.addAttribute("superSomeone", superSomeone);
        model.addAttribute("notSuperPowers", notSuperPowers);
        model.addAttribute("superPowers", superPowers);
        return "superSomeoneEdit";
    }

    @RequestMapping(value = "/editSuperSomeone", method = RequestMethod.POST)
    public String editSuperSomeone(HttpServletRequest request, @ModelAttribute("superSomeone") SuperSomeone superSomeone) {

        List<SuperPower> superPowerList = new ArrayList<SuperPower>();

        superSomeone.setSuperSomeoneType(request.getParameter("superSomeoneType"));
        superSomeone.setSuperSomeoneName(request.getParameter("superSomeoneName"));
        superSomeone.setSuperSomeoneAlias(request.getParameter("superSomeoneAlias"));
        superSomeone.setSuperSomeoneDescription(request.getParameter("superSomeoneDescription"));

        String[] superPowersFromForm = request.getParameterValues("superPowers"); //followup, taken from Model
        int intToString;

        for (String currentSuperPower : superPowersFromForm) {
            intToString = Integer.parseInt(currentSuperPower);
            superPowerList.add(service.getSuperPowerByID(intToString));

        }
        superSomeone.setSuperPowerList(superPowerList);

        service.updateSuperSomeone(superSomeone);

        return "redirect:displaySuperSomeonesPage";

    }

    @RequestMapping(value = "/deleteSuperSomeone", method = RequestMethod.GET)
    public String deleteSuperSomeone(HttpServletRequest request) {
        String superSomeoneIDParameter = request.getParameter("superSomeoneID");
        int superSomeoneID = Integer.parseInt(superSomeoneIDParameter);

        service.deleteSuperSomeone(superSomeoneID);

        return "redirect:displaySuperSomeonesPage";
    }

    @RequestMapping(value = "/displaySightingsPage", method = RequestMethod.GET)
    public String displaySightingsPage(Model model) {
        List<SuperSomeone> superSomeoneList = service.getAllSuperSomeones();
        List<Location> locationList = service.getAllLocations();
        List<SightingData> sightingDataList = service.getAllSuperSomeoneSightings();
        model.addAttribute("sightingDataList", sightingDataList);
        model.addAttribute("superSomeoneList", superSomeoneList);
        model.addAttribute("locationList", locationList);

        return "sightings";
    }

    @RequestMapping(value = "/createSighting", method = RequestMethod.POST)
    public String createSighting(HttpServletRequest request) {

        Location location = service.getLocationByID(Integer.parseInt(request.getParameter("sightingLocation")));

        List<SuperSomeone> superSomeones = new ArrayList<SuperSomeone>();

        String[] superSomeonesSighted = request.getParameterValues("superSomeonesSighted");
        int sightingString;
        for (String currentString : superSomeonesSighted) {
            sightingString = Integer.parseInt(currentString);
            superSomeones.add(service.getSuperSomeoneByID(sightingString));
        }

        SightingData sightingData = new SightingData();
        sightingData.setSuperSomeoneSightingDescription(request.getParameter("sightingDescription"));

        sightingData.setLocationID(Integer.parseInt(request.getParameter("sightingLocation")));

        String sightingDateString = request.getParameter("sightingDate");
        LocalDate sightingDate = LocalDate.parse(sightingDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        sightingData.setSuperSomeoneSightingDate(sightingDate);

        sightingData.setLocation(location);
        sightingData.setSuperSomeoneList(superSomeones);

        service.addSightingData(sightingData);

        return "redirect:displaySightingsPage";
    }

    @RequestMapping(value = "/displaySightingDetails", method = RequestMethod.GET)
    public String displaySightingDetails(HttpServletRequest request, Model model) {
        String sightingDataIDParameter = request.getParameter("sightingDataID");
        int sightingDataID = Integer.parseInt(sightingDataIDParameter);

        SightingData sightingData = service.getSightingDataByID(sightingDataID);

        Location sightingLocation = service.getLocationByID(sightingData.getLocationID());

        model.addAttribute("sightingData", sightingData);
        model.addAttribute("sightingLocation", sightingLocation);

        return "sightingDetails";
    }

    @RequestMapping(value = "/displaySightingEdit", method = RequestMethod.GET)
    public String displaySightingEdit(HttpServletRequest request, Model model) {
        String sightingDataIDParameter = request.getParameter("sightingDataID");
        int sightingDataID = Integer.parseInt(sightingDataIDParameter);

        SightingData sightingData = service.getSightingDataByID(sightingDataID);

        List<SuperSomeone> notSighted = service.getAllSuperSomeones();
        List<SuperSomeone> sighted = sightingData.getSuperSomeoneList();
        notSighted.removeAll(sighted);

        List<Location> notLocations = service.getAllLocations();
        Location location = sightingData.getLocation();
        List<Location> sightingLocations = new ArrayList<>();

        sightingLocations.add(location);
        notLocations.removeAll(sightingLocations);

        model.addAttribute("sightingData", sightingData);
        model.addAttribute("sighted", sighted);
        model.addAttribute("notSighted", notSighted);
        model.addAttribute("sightingLocations", sightingLocations);
        model.addAttribute("notLocations", notLocations);

        return "sightingEdit";

    }

    @RequestMapping(value = "/editSightingData", method = RequestMethod.POST)
    public String editSightingData(HttpServletRequest request, @ModelAttribute("sightingData") SightingData sightingData, BindingResult result) {

        List<SuperSomeone> superSomeones = new ArrayList<SuperSomeone>();

        String locationID = request.getParameter("location");
        int locationIDInt = Integer.parseInt(locationID);

        sightingData.setLocation(service.getLocationByID(locationIDInt));
        sightingData.setLocationID(locationIDInt);

        String[] superSomeonesFromRequest = request.getParameterValues("superSomeonesSighted");

        int superSomeoneIDInt;
        for (String currentSuperSomeone : superSomeonesFromRequest) {
            superSomeoneIDInt = Integer.parseInt(currentSuperSomeone);
            superSomeones.add(service.getSuperSomeoneByID(superSomeoneIDInt));
        }
        sightingData.setSuperSomeoneList(superSomeones);

        String sightingDateString = request.getParameter("superSomeoneSightingDate");
        LocalDate sightingDate = LocalDate.parse(sightingDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // LocalDate sightingDate = LocalDate.parse(sightingDateString, DateTimeFormatter.ofPattern("MM/dd/YY"));
        sightingData.setSuperSomeoneSightingDate(sightingDate);

        service.updateSightingData(sightingData);

        return "redirect:displaySightingsPage";

    }

    @RequestMapping(value = "/deleteSighting", method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        String sightingDataIDParameter = request.getParameter("sightingDataID");
        int sightingDataID = Integer.parseInt(sightingDataIDParameter);

        service.deleteSightingData(sightingDataID);

        return "redirect:displaySightingsPage";
    }

    @RequestMapping(value = "/displayOrganizationDetails", method = RequestMethod.GET)
    public String displayOrganizationDetails(HttpServletRequest request, Model model) {
        String organizationIDParameter = request.getParameter("organizationID");
        int organizationID = Integer.parseInt(organizationIDParameter);

        Organization organization = service.getOrganizationByID(organizationID);

        model.addAttribute("organization", organization);

        return "organizationDetails";
    }

    @RequestMapping(value = "/displayOrganizationsPage", method = RequestMethod.GET)
    public String displayOrganizationsPage(Model model) {
        List<SuperSomeone> memberList = service.getAllSuperSomeones();
        List<Location> locationList = service.getAllLocations();
        List<Organization> organizationList = service.getAllOrganizations();
        model.addAttribute("organizationList", organizationList);
        model.addAttribute("locationList", locationList);
        model.addAttribute("memberList", memberList);
        return "organizations";
    }

    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public String createOrganization(HttpServletRequest request) {

        Organization organization = new Organization();
        organization.setOrganizationType(request.getParameter("organizationType"));
        organization.setOrganizationName(request.getParameter("organizationName"));
        organization.setOrganizationDescription(request.getParameter("organizationDescription"));
        organization.setOrganizationContact(request.getParameter("organizationContact"));

        List<SuperSomeone> superSomeoneList = new ArrayList<SuperSomeone>();

        String[] membersSelected = request.getParameterValues("organizationMember");
        int orgString;

        for (String currentString : membersSelected) {
            orgString = Integer.parseInt(currentString);
            superSomeoneList.add(service.getSuperSomeoneByID(orgString));
        }

        organization.setMemberList(superSomeoneList);

        List<Location> locationList = new ArrayList<Location>();

        String[] locationsSelected = request.getParameterValues("organizationLocation");

        for (String currentLocation : locationsSelected) {
            orgString = Integer.parseInt(currentLocation);
            locationList.add(service.getLocationByID(orgString));
        }

        organization.setLocationList(locationList);
        service.addOrganization(organization);

        return "redirect:displayOrganizationsPage";

    }

    @RequestMapping(value = "/displayOrganizationEdit", method = RequestMethod.GET)
    public String displayOrganizationEdit(HttpServletRequest request, Model model) {
        String organizationIDParameter = request.getParameter("organizationID");
        int organizationID = Integer.parseInt(organizationIDParameter);

        Organization organization = service.getOrganizationByID(organizationID);

        List<SuperSomeone> notMembers = service.getAllSuperSomeones();
        List<SuperSomeone> members = organization.getMemberList();
        notMembers.removeAll(members);

        List<Location> notLocations = service.getAllLocations();
        List<Location> locations = organization.getLocationList();

        notLocations.removeAll(locations);

        model.addAttribute("organization", organization);
        model.addAttribute("members", members);
        model.addAttribute("notMembers", notMembers);
        model.addAttribute("locations", locations);
        model.addAttribute("notLocations", notLocations);

        return "organizationEdit";

    }

    @RequestMapping(value = "/editOrganization", method = RequestMethod.POST)
    public String editOrganization(HttpServletRequest request, @ModelAttribute("organization") Organization organization) {

        List<SuperSomeone> memberList = new ArrayList<SuperSomeone>();
        List<Location> orgLocations = new ArrayList<Location>();

        organization.setOrganizationType(request.getParameter("organizationType"));
        organization.setOrganizationName(request.getParameter("organizationName"));
        organization.setOrganizationDescription(request.getParameter("organizationDescription"));
        organization.setOrganizationContact(request.getParameter("organizationContact"));

        String[] orgMembersForm = request.getParameterValues("organizationMember");
        int intToString;

        for (String currentMember : orgMembersForm) {
            intToString = Integer.parseInt(currentMember);
            memberList.add(service.getSuperSomeoneByID(intToString));

        }
        organization.setMemberList(memberList);

        String[] orgLocationsForm = request.getParameterValues("organizationLocation");

        for (String currentLocation : orgLocationsForm) {
            intToString = Integer.parseInt(currentLocation);
            orgLocations.add(service.getLocationByID(intToString));
        }

        organization.setLocationList(orgLocations);

        service.updateOrganization(organization);

        return "redirect:displayOrganizationsPage";

    }

    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {
        String organizationIDString = request.getParameter("organizationID");
        int organiationID = Integer.parseInt(organizationIDString);

        service.deleteOrganization(organiationID);

        return "redirect:displayOrganizationsPage";
    }

    @RequestMapping(value = "/displayLocationsPage", method = RequestMethod.GET)
    public String displayLocationsPage(Model model) {
        List<Location> locationList = service.getAllLocations();
        model.addAttribute("locationList", locationList);

        return "locations";
    }

    @RequestMapping(value = "/createLocation", method = RequestMethod.POST)
    public String createLocation(HttpServletRequest request) {

        Location location = new Location();
        location.setLocationName(request.getParameter("locationName"));
        location.setLocationDescription(request.getParameter("locationDescription"));
        location.setLocationStreet(request.getParameter("locationStreet"));
        location.setLocationCity(request.getParameter("locationCity"));
        location.setLocationState(request.getParameter("locationState"));
        location.setLocationCountry(request.getParameter("locationCountry"));
        location.setLocationLatitude(new BigDecimal(request.getParameter("locationLatitude")));
        location.setLocationLongitude(new BigDecimal(request.getParameter("locationLongitude")));
        service.addLocation(location);

        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        service.deleteLocation(locationID);
        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/displayLocationDetails", method = RequestMethod.GET)
    public String displayLocationDetails(HttpServletRequest request, Model model) {
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);

        Location location = service.getLocationByID(locationID);

        model.addAttribute("location", location);

        return "locationDetails";
    }

    @RequestMapping(value = "/displayLocationEdit", method = RequestMethod.GET)
    public String displayLocationEditPage(HttpServletRequest request, Model model) {
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        Location location = service.getLocationByID(locationID);
        model.addAttribute("location", location);
        return "locationEdit";
    }

    @RequestMapping(value = "/editLocation", method = RequestMethod.POST)
    public String editLocation(@ModelAttribute("location") Location location) {

        service.updateLocation(location);

        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/displaySuperPowersPage", method = RequestMethod.GET)
    public String displaySuperPowersPage(Model model) {
        List<SuperPower> superPowerList = service.getAllSuperPowers();
        model.addAttribute("superPowerList", superPowerList);

        return "superPowers";
    }

    @RequestMapping(value = "/createSuperPower", method = RequestMethod.POST)
    public String createSuperPower(HttpServletRequest request) {
        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName(request.getParameter("superPowerName"));
        superPower.setSuperPowerDescription(request.getParameter("superPowerDescription"));

        service.addSuperPower(superPower);

        return "redirect:displaySuperPowersPage";
    }

    @RequestMapping(value = "/deleteSuperPower", method = RequestMethod.GET)
    public String deleteSuperPower(HttpServletRequest request) {
        String superPowerIDParameter = request.getParameter("superPowerID");
        int superPowerID = Integer.parseInt(superPowerIDParameter);
        service.deleteSuperPower(superPowerID);
        return "redirect:displaySuperPowersPage";
    }

    @RequestMapping(value = "/displaySuperPowerEdit", method = RequestMethod.GET)
    public String displaySuperPowerEdit(HttpServletRequest request, Model model) {
        String superPowerIDParameter = request.getParameter("superPowerID");
        int superPowerID = Integer.parseInt(superPowerIDParameter);
        SuperPower superPower = service.getSuperPowerByID(superPowerID);
        model.addAttribute("superPower", superPower);
        return "superPowerEdit";
    }

    @RequestMapping(value = "/editSuperPower", method = RequestMethod.POST)
    public String editSuperPower(@ModelAttribute("superPower") SuperPower superPower) {
        service.updateSuperPower(superPower);

        return "redirect:displaySuperPowersPage";
    }

}
