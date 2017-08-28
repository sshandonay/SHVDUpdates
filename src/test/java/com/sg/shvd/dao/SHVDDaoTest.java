/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shvd.dao;

import com.sg.shvd.model.Location;
import com.sg.shvd.model.Organization;
import com.sg.shvd.model.SightingData;
import com.sg.shvd.model.SuperPower;
import com.sg.shvd.model.SuperSomeone;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class SHVDDaoTest {

    SHVDDao dao;

    public SHVDDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        dao = ctx.getBean("SHVDDao", SHVDDao.class);

        //delete all SuperPowers
        List<SuperPower> superPowers = dao.getAllSuperPowers();
        for (SuperPower currentSuperPower : superPowers) {
            dao.deleteSuperPower(currentSuperPower.getSuperPowerID());
        }
        //delete all SuperSomeones
        List<SuperSomeone> superSomeones = dao.getAllSuperSomeones();
        for (SuperSomeone currentSuperSomeone : superSomeones) {
            dao.deleteSuperSomeone(currentSuperSomeone.getSuperSomeoneID());
        }

        // delete all Locations
        List<Location> locations = dao.getAllLocations();
        for (Location currentLocation : locations) {
            dao.deleteLocation(currentLocation.getLocationID());
        }

        // delete all Organizations
        List<Organization> organizations = dao.getAllOrganizations();
        for (Organization currentOrganization : organizations) {
            dao.deleteOrganization(currentOrganization.getOrganizationID());
        }

        //delete all SightingDatas
        List<SightingData> sightingDatas = dao.getAllSightingData();
        for (SightingData currentSightingData : sightingDatas) {
            dao.deleteSightingData(currentSightingData.getSuperSomeoneSightingDataID());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetLocation() {
        BigDecimal locLat = new BigDecimal("123.456789");
        BigDecimal locLong = new BigDecimal("123.456789");

        Location location = new Location();
        location.setLocationName("Location 1");
        location.setLocationDescription("Location Description 1");
        location.setLocationStreet("Location Street 1");
        location.setLocationCity("Location City 1");
        location.setLocationState("Location State 1");
        location.setLocationCountry("C1");
        location.setLocationLatitude(locLat);
        location.setLocationLongitude(locLong);

        dao.addLocation(location);

        Location fromDao
                = dao.getLocationByID(location.getLocationID());

        assertEquals(location, fromDao);

        assertEquals(location.getLocationLongitude(), fromDao.getLocationLongitude());

    }

    @Test
    public void deleteLocation() {
        BigDecimal locLat = new BigDecimal("123.456789");
        BigDecimal locLong = new BigDecimal("123.456789");

        Location location = new Location();
        location.setLocationName("Location 1");
        location.setLocationDescription("Location Description 1");
        location.setLocationStreet("Location Street 1");
        location.setLocationCity("Location City 1");
        location.setLocationState("Location State 1");
        location.setLocationCountry("C1");
        location.setLocationLatitude(locLat);
        location.setLocationLongitude(locLong);

        dao.addLocation(location);

        Location fromDao
                = dao.getLocationByID(location.getLocationID());
        assertEquals(fromDao, location);
        dao.deleteLocation(location.getLocationID());

        fromDao = dao.getLocationByID(location.getLocationID());
        assertNull(fromDao);

    }

    @Test
    public void testUpdateLocation() {
        BigDecimal locLat = new BigDecimal("125.456789");
        BigDecimal locLong = new BigDecimal("121.456789");

        Location location = new Location();
        location.setLocationName("Location One");
        location.setLocationDescription("Location Description One");
        location.setLocationStreet("Location Street One");
        location.setLocationCity("Location City One");
        location.setLocationState("Location State One");
        location.setLocationCountry("CountryOne");
        location.setLocationLatitude(locLat);
        location.setLocationLongitude(locLong);

        dao.addLocation(location);

        Location fromDao = dao.getLocationByID(location.getLocationID());

        assertEquals(fromDao, location);

        location.setLocationCity("Louisville");

        dao.updateLocation(location);

        fromDao = dao.getLocationByID(location.getLocationID());

        assertEquals(location, fromDao);

        assertEquals("Louisville", fromDao.getLocationCity());

    }

    @Test
    public void testGetAllLocations() {
        BigDecimal locLatA = new BigDecimal("125.456789");
        BigDecimal locLongA = new BigDecimal("121.456789");
        BigDecimal locLatB = new BigDecimal("120.456733");
        BigDecimal locLongB = new BigDecimal("118.456723");

        Location location = new Location();
        location.setLocationName("Location One");
        location.setLocationDescription("Location Description One");
        location.setLocationStreet("Location Street One");
        location.setLocationCity("Location City One");
        location.setLocationState("Location State One");
        location.setLocationCountry("CountryOne");
        location.setLocationLatitude(locLatA);
        location.setLocationLongitude(locLongA);
        dao.addLocation(location);

        Location locationB = new Location();
        locationB.setLocationName("Location B");
        locationB.setLocationDescription("Location Description B");
        locationB.setLocationStreet("Location Street B");
        locationB.setLocationCity("Location City B");
        locationB.setLocationState("Location State B");
        locationB.setLocationCountry("CountryB");
        locationB.setLocationLatitude(locLatB);
        locationB.setLocationLongitude(locLongB);
        dao.addLocation(locationB);

        List<Location> fromDao = dao.getAllLocations();

        assertEquals(2, fromDao.size());

    }

    @Test
    public void addGetOrganization() {
        BigDecimal locLatA = new BigDecimal("125.456789");
        BigDecimal locLongA = new BigDecimal("121.456789");

        Location location = new Location();
        location.setLocationName("LoccName");
        location.setLocationDescription("LocDescription");
        location.setLocationStreet("LocStreet");
        location.setLocationCity("LocCity");
        location.setLocationState("LocState");
        location.setLocationCountry("LocCountry");
        location.setLocationLatitude(locLatA);
        location.setLocationLongitude(locLongA);
        dao.addLocation(location);
        List<Location> locationList = new ArrayList<>();
        locationList.add(location);

        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("superPowerName");
        superPower.setSuperPowerDescription("superPowerDescription");
        dao.addSuperPower(superPower);
        List<SuperPower> superPowerList = new ArrayList<>();
        superPowerList.add(superPower);

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Hero");
        superSomeone.setSuperSomeoneName("superSomeoneName");
        superSomeone.setSuperSomeoneAlias("superSomeoneAlias");
        superSomeone.setSuperSomeoneDescription("superSomeoneDesc");
        superSomeone.setSuperPowerList(superPowerList);
        dao.addSuperSomeone(superSomeone);
        List<SuperSomeone> superSomeoneList = new ArrayList<>();
        superSomeoneList.add(superSomeone);

        Organization organization = new Organization();
        organization.setOrganizationType("oType");
        organization.setOrganizationName("oName");
        organization.setOrganizationDescription("oDesc");
        organization.setOrganizationContact("oContact");
        organization.setLocationList(locationList);
        organization.setMemberList(superSomeoneList);

        dao.addOrganization(organization);

        Organization fromDao
                = dao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(organization, fromDao);
        assertEquals("oType", fromDao.getOrganizationType());

    }

    @Test
    public void deleteOrganization() {
        BigDecimal locLatA = new BigDecimal("115.456789");
        BigDecimal locLongA = new BigDecimal("118.456789");

        Location location = new Location();
        location.setLocationName("lName");
        location.setLocationDescription("lDescription");
        location.setLocationStreet("lStreet");
        location.setLocationCity("lCity");
        location.setLocationState("lState");
        location.setLocationCountry("lCountry");
        location.setLocationLatitude(locLatA);
        location.setLocationLongitude(locLongA);
        dao.addLocation(location);
        List<Location> locationList = new ArrayList<>();
        locationList.add(location);

        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("spName");
        superPower.setSuperPowerDescription("spDescription");
        dao.addSuperPower(superPower);
        List<SuperPower> superPowerList = new ArrayList<>();
        superPowerList.add(superPower);

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Hero");
        superSomeone.setSuperSomeoneName("shName");
        superSomeone.setSuperSomeoneAlias("shAlias");
        superSomeone.setSuperSomeoneDescription("shDesc");
        superSomeone.setSuperPowerList(superPowerList);
        dao.addSuperSomeone(superSomeone);
        List<SuperSomeone> superSomeoneList = new ArrayList<>();
        superSomeoneList.add(superSomeone);

        Organization organization = new Organization();
        organization.setOrganizationType("oType");
        organization.setOrganizationName("oName");
        organization.setOrganizationDescription("oDescription");
        organization.setOrganizationContact("oContact");
        organization.setLocationList(locationList);
        organization.setMemberList(superSomeoneList);

        dao.addOrganization(organization);

        Organization fromDao
                = dao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(fromDao, organization);

        dao.deleteOrganization(organization.getOrganizationID());

        fromDao = dao.getOrganizationByID(organization.getOrganizationID());
        assertNull(fromDao);

    }

    @Test
    public void testGetAllOrganizations() {
        BigDecimal locLatA = new BigDecimal("115.456789");
        BigDecimal locLongA = new BigDecimal("118.456789");
        BigDecimal locLatB = new BigDecimal("101.456789");
        BigDecimal locLongB = new BigDecimal("122.456789");

        Location locationA = new Location();
        locationA.setLocationName("lNameA");
        locationA.setLocationDescription("lDescriptionA");
        locationA.setLocationStreet("lStreetA");
        locationA.setLocationCity("lCityA");
        locationA.setLocationState("lStateA");
        locationA.setLocationCountry("lCountryA");
        locationA.setLocationLatitude(locLatA);
        locationA.setLocationLongitude(locLongA);
        dao.addLocation(locationA);
        List<Location> locationListA = new ArrayList<>();
        locationListA.add(locationA);

        SuperPower superPowerA = new SuperPower();
        superPowerA.setSuperPowerName("spNameA");
        superPowerA.setSuperPowerDescription("spDescriptionA");
        dao.addSuperPower(superPowerA);
        List<SuperPower> superPowerListA = new ArrayList<>();
        superPowerListA.add(superPowerA);

        SuperSomeone superSomeoneA = new SuperSomeone();
        superSomeoneA.setSuperSomeoneType("Hero");
        superSomeoneA.setSuperSomeoneName("shNameA");
        superSomeoneA.setSuperSomeoneAlias("shAliasA");
        superSomeoneA.setSuperSomeoneDescription("shDescA");
        superSomeoneA.setSuperPowerList(superPowerListA);
        dao.addSuperSomeone(superSomeoneA);
        List<SuperSomeone> superSomeoneListA = new ArrayList<>();
        superSomeoneListA.add(superSomeoneA);

        Organization organizationA = new Organization();
        organizationA.setOrganizationType("oTypeA");
        organizationA.setOrganizationName("oNameA");
        organizationA.setOrganizationDescription("oDescriptionA");
        organizationA.setOrganizationContact("oContactA");
        organizationA.setLocationList(locationListA);
        organizationA.setMemberList(superSomeoneListA);

        dao.addOrganization(organizationA);

        Location locationB = new Location();
        locationB.setLocationName("lNameB");
        locationB.setLocationDescription("lDescriptionB");
        locationB.setLocationStreet("lStreetB");
        locationB.setLocationCity("lCityB");
        locationB.setLocationState("lStateB");
        locationB.setLocationCountry("lCountryB");
        locationB.setLocationLatitude(locLatB);
        locationB.setLocationLongitude(locLongB);
        dao.addLocation(locationB);
        List<Location> locationListB = new ArrayList<>();
        locationListB.add(locationB);

        SuperPower superPowerB = new SuperPower();
        superPowerB.setSuperPowerName("spNameB");
        superPowerB.setSuperPowerDescription("spDescriptionB");
        dao.addSuperPower(superPowerB);
        List<SuperPower> superPowerListB = new ArrayList<>();
        superPowerListB.add(superPowerB);

        SuperSomeone superSomeoneB = new SuperSomeone();
        superSomeoneB.setSuperSomeoneType("Villain");
        superSomeoneB.setSuperSomeoneName("shNameB");
        superSomeoneB.setSuperSomeoneAlias("shAliasB");
        superSomeoneB.setSuperSomeoneDescription("shDescB");
        superSomeoneB.setSuperPowerList(superPowerListB);
        dao.addSuperSomeone(superSomeoneB);
        List<SuperSomeone> superSomeoneListB = new ArrayList<>();
        superSomeoneListB.add(superSomeoneB);

        Organization organizationB = new Organization();
        organizationB.setOrganizationType("oTypeB");
        organizationB.setOrganizationName("oNameB");
        organizationB.setOrganizationDescription("oDescriptionB");
        organizationB.setOrganizationContact("oContactB");
        organizationB.setLocationList(locationListB);
        organizationB.setMemberList(superSomeoneListB);

        dao.addOrganization(organizationB);

        List<Organization> fromDao = dao.getAllOrganizations();

        assertEquals(2, fromDao.size());

    }

    @Test
    public void testUpdateOrganization() {
        BigDecimal locLatA = new BigDecimal("125.456789");
        BigDecimal locLongA = new BigDecimal("121.456789");

        Location location = new Location();
        location.setLocationName("LocName");
        location.setLocationDescription("LocDescription");
        location.setLocationStreet("LocStreet");
        location.setLocationCity("LocCity");
        location.setLocationState("LocState");
        location.setLocationCountry("LocCountry");
        location.setLocationLatitude(locLatA);
        location.setLocationLongitude(locLongA);
        dao.addLocation(location);
        List<Location> locationList = new ArrayList<>();
        locationList.add(location);

        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("superPowerName");
        superPower.setSuperPowerDescription("superPowerDescription");
        dao.addSuperPower(superPower);
        List<SuperPower> superPowerList = new ArrayList<>();
        superPowerList.add(superPower);

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Hero");
        superSomeone.setSuperSomeoneName("superSomeoneName");
        superSomeone.setSuperSomeoneAlias("superSomeoneAlias");
        superSomeone.setSuperSomeoneDescription("superSomeoneDesc");
        superSomeone.setSuperPowerList(superPowerList);
        dao.addSuperSomeone(superSomeone);
        List<SuperSomeone> superSomeoneList = new ArrayList<>();
        superSomeoneList.add(superSomeone);

        Organization organization = new Organization();
        organization.setOrganizationType("OType");
        organization.setOrganizationName("OName");
        organization.setOrganizationDescription("ODescription");
        organization.setOrganizationContact("OTestContact");
        organization.setLocationList(locationList);
        organization.setMemberList(superSomeoneList);

        dao.addOrganization(organization);

        Organization fromDao
                = dao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(fromDao, organization);

        organization.setOrganizationName("OUpdate");

        dao.updateOrganization(organization);

        fromDao = dao.getOrganizationByID(organization.getOrganizationID());

        assertEquals(fromDao, organization);

    }

    @Test
    public void addGetSightingData() {
        BigDecimal locLatA = new BigDecimal("101.456789");
        BigDecimal locLongA = new BigDecimal("104.456789");
        String sightingDateString = "2017-11-11";
        LocalDate sightingDate = LocalDate.parse(sightingDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Location location = new Location();
        location.setLocationName("LocName");
        location.setLocationDescription("LocDescription");
        location.setLocationStreet("LocStreet");
        location.setLocationCity("LocCity");
        location.setLocationState("LocState");
        location.setLocationCountry("LocCountry");
        location.setLocationLatitude(locLatA);
        location.setLocationLongitude(locLongA);
        dao.addLocation(location);
        int locID = location.getLocationID();

        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("superPowerName");
        superPower.setSuperPowerDescription("superPowerDescription");
        dao.addSuperPower(superPower);
        List<SuperPower> superPowerList = new ArrayList<>();
        superPowerList.add(superPower);

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Hero");
        superSomeone.setSuperSomeoneName("superSomeoneName");
        superSomeone.setSuperSomeoneAlias("superSomeoneAlias");
        superSomeone.setSuperSomeoneDescription("superSomeoneDesc");
        superSomeone.setSuperPowerList(superPowerList);
        dao.addSuperSomeone(superSomeone);
        List<SuperSomeone> superSomeoneList = new ArrayList<>();
        superSomeoneList.add(superSomeone);

        SightingData sightingData = new SightingData();
        sightingData.setLocationID(locID);
        sightingData.setSuperSomeoneSightingDescription("TestDescription");
        sightingData.setSuperSomeoneSightingDate(sightingDate);
        sightingData.setSuperSomeoneList(superSomeoneList);
        sightingData.setLocation(location);

        dao.addSightingData(sightingData);
        int sightDataID = sightingData.getSuperSomeoneSightingDataID();

        SightingData fromDao = dao.getSightingDataByID(sightDataID);
        assertEquals(sightingData, fromDao);

    }

    @Test
    public void deleteSightingData() {

        BigDecimal locLatA = new BigDecimal("101.456789");
        BigDecimal locLongA = new BigDecimal("104.456789");
        String sightingDateString = "2017-11-11";
        LocalDate sightingDate = LocalDate.parse(sightingDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Location location = new Location();
        location.setLocationName("LocName");
        location.setLocationDescription("LocDescription");
        location.setLocationStreet("LocStreet");
        location.setLocationCity("LocCity");
        location.setLocationState("LocState");
        location.setLocationCountry("LocCountry");
        location.setLocationLatitude(locLatA);
        location.setLocationLongitude(locLongA);
        dao.addLocation(location);
        int locID = location.getLocationID();

        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("superPowerName");
        superPower.setSuperPowerDescription("superPowerDescription");
        dao.addSuperPower(superPower);
        List<SuperPower> superPowerList = new ArrayList<>();
        superPowerList.add(superPower);

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Hero");
        superSomeone.setSuperSomeoneName("superSomeoneName");
        superSomeone.setSuperSomeoneAlias("superSomeoneAlias");
        superSomeone.setSuperSomeoneDescription("superSomeoneDesc");
        superSomeone.setSuperPowerList(superPowerList);
        dao.addSuperSomeone(superSomeone);
        List<SuperSomeone> superSomeoneList = new ArrayList<>();
        superSomeoneList.add(superSomeone);

        SightingData sightingData = new SightingData();
        sightingData.setLocationID(locID);
        sightingData.setSuperSomeoneSightingDescription("TestDescription");
        sightingData.setSuperSomeoneSightingDate(sightingDate);
        sightingData.setSuperSomeoneList(superSomeoneList);
        sightingData.setLocation(location);

        dao.addSightingData(sightingData);


        SightingData fromDao = dao.getSightingDataByID(sightingData.getSuperSomeoneSightingDataID());
        assertEquals(fromDao, sightingData);

        dao.deleteSightingData(sightingData.getSuperSomeoneSightingDataID());
        fromDao = dao.getSightingDataByID(sightingData.getSuperSomeoneSightingDataID());

        assertNull(fromDao);

    }

    @Test
    public void testUpdateSightingData() {   

        BigDecimal locLatA = new BigDecimal("101.456789");
        BigDecimal locLongA = new BigDecimal("104.456789");
        String sightingDateString = "2017-11-11";
        LocalDate sightingDate = LocalDate.parse(sightingDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Location location = new Location();
        location.setLocationName("LocName");
        location.setLocationDescription("LocDescription");
        location.setLocationStreet("LocStreet");
        location.setLocationCity("LocCity");
        location.setLocationState("LocState");
        location.setLocationCountry("LocCountry");
        location.setLocationLatitude(locLatA);
        location.setLocationLongitude(locLongA);
        dao.addLocation(location);
        int locID = location.getLocationID();

        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("superPowerName");
        superPower.setSuperPowerDescription("superPowerDescription");
        dao.addSuperPower(superPower);
        List<SuperPower> superPowerList = new ArrayList<>();
        superPowerList.add(superPower);

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Hero");
        superSomeone.setSuperSomeoneName("superSomeoneName");
        superSomeone.setSuperSomeoneAlias("superSomeoneAlias");
        superSomeone.setSuperSomeoneDescription("superSomeoneDesc");
        superSomeone.setSuperPowerList(superPowerList);
        dao.addSuperSomeone(superSomeone);
        List<SuperSomeone> superSomeoneList = new ArrayList<>();
        superSomeoneList.add(superSomeone);

        SightingData sightingData = new SightingData();
        sightingData.setLocationID(locID);
        sightingData.setSuperSomeoneSightingDescription("TestDescription");
        sightingData.setSuperSomeoneSightingDate(sightingDate);
        sightingData.setSuperSomeoneList(superSomeoneList);
        sightingData.setLocation(location);

        dao.addSightingData(sightingData);

        SightingData fromDao = dao.getSightingDataByID(sightingData.getSuperSomeoneSightingDataID());
        assertEquals(fromDao, sightingData);

        sightingData.setSuperSomeoneSightingDescription("uDescription");
        dao.updateSightingData(sightingData);

        fromDao = dao.getSightingDataByID(sightingData.getSuperSomeoneSightingDataID());

        assertEquals(fromDao, sightingData);

    }

    @Test
    public void testGetAllSightingData() {

        BigDecimal locLatA = new BigDecimal("101.456789");
        BigDecimal locLongA = new BigDecimal("104.456789");
        String sightingDateString = "2017-11-11";
        LocalDate sightingDate = LocalDate.parse(sightingDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Location location = new Location();
        location.setLocationName("LocName");
        location.setLocationDescription("LocDescription");
        location.setLocationStreet("LocStreet");
        location.setLocationCity("LocCity");
        location.setLocationState("LocState");
        location.setLocationCountry("LocCountry");
        location.setLocationLatitude(locLatA);
        location.setLocationLongitude(locLongA);
        dao.addLocation(location);
        int locID = location.getLocationID();

        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("superPowerName");
        superPower.setSuperPowerDescription("superPowerDescription");
        dao.addSuperPower(superPower);
        List<SuperPower> superPowerList = new ArrayList<>();
        superPowerList.add(superPower);

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Hero");
        superSomeone.setSuperSomeoneName("superSomeoneName");
        superSomeone.setSuperSomeoneAlias("superSomeoneAlias");
        superSomeone.setSuperSomeoneDescription("superSomeoneDesc");
        superSomeone.setSuperPowerList(superPowerList);
        dao.addSuperSomeone(superSomeone);
        List<SuperSomeone> superSomeoneList = new ArrayList<>();
        superSomeoneList.add(superSomeone);

        SightingData sightingData = new SightingData();
        sightingData.setLocationID(locID);
        sightingData.setSuperSomeoneSightingDescription("TestDescription");
        sightingData.setSuperSomeoneSightingDate(sightingDate);
        sightingData.setSuperSomeoneList(superSomeoneList);
        sightingData.setLocation(location);

        dao.addSightingData(sightingData);
        dao.addSightingData(sightingData);

        List<SightingData> fromDao = dao.getAllSightingData();

        assertEquals(2, fromDao.size());

    }

    @Test
    public void addGetSuperPower() {
        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("TestName");
        superPower.setSuperPowerDescription("TestDescription");

        dao.addSuperPower(superPower);

        SuperPower fromDao
                = dao.getSuperPowerByID(superPower.getSuperPowerID());
        assertEquals(fromDao, superPower);

    }

    @Test
    public void deleteSuperPower() {
        SuperPower superPower = new SuperPower();
        superPower.setSuperPowerName("TestName");
        superPower.setSuperPowerDescription("TestDescription");

        dao.addSuperPower(superPower);

        SuperPower fromDao
                = dao.getSuperPowerByID(superPower.getSuperPowerID());
        assertEquals(fromDao, superPower);
        dao.deleteSuperPower(superPower.getSuperPowerID());
        assertNull(dao.getSuperPowerByID(superPower.getSuperPowerID()));

    }

    @Test
    public void testGetAllSuperPowers() {
        SuperPower superPowerA = new SuperPower();
        superPowerA.setSuperPowerName("sPowerNameA");
        superPowerA.setSuperPowerDescription("sDescriptionA");

        dao.addSuperPower(superPowerA);

        SuperPower superPowerB = new SuperPower();
        superPowerB.setSuperPowerName("sPowerNameB");
        superPowerB.setSuperPowerDescription("sDescriptionB");

        dao.addSuperPower(superPowerB);

        List<SuperPower> fromDao = dao.getAllSuperPowers();

        assertEquals(2, fromDao.size());

    }

    @Test
    public void addGetSuperSomeone() {
        SuperPower superPowerforSS = new SuperPower();
        superPowerforSS.setSuperPowerName("sPowerName");
        superPowerforSS.setSuperPowerDescription("sDescription");

        dao.addSuperPower(superPowerforSS);

        List<SuperPower> superPowerList = dao.getAllSuperPowers();

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Type Test");
        superSomeone.setSuperSomeoneName("Name Test");
        superSomeone.setSuperSomeoneAlias("Alias Test");
        superSomeone.setSuperSomeoneDescription("Description Test");
        superSomeone.setSuperPowerList(superPowerList);

        dao.addSuperSomeone(superSomeone);

        SuperSomeone fromDao
                = dao.getSuperSomeoneByID(superSomeone.getSuperSomeoneID());
        assertEquals(fromDao, superSomeone);

    }

    @Test
    public void deleteSuperSomeone() {
        SuperPower superPowerforSS = new SuperPower();
        superPowerforSS.setSuperPowerName("sPowerName");
        superPowerforSS.setSuperPowerDescription("sDescription");

        dao.addSuperPower(superPowerforSS);

        List<SuperPower> superPowerList = dao.getAllSuperPowers();

        SuperSomeone superSomeone = new SuperSomeone();
        superSomeone.setSuperSomeoneType("Type Test");
        superSomeone.setSuperSomeoneName("Name Test");
        superSomeone.setSuperSomeoneAlias("Alias Test");
        superSomeone.setSuperSomeoneDescription("Description Test");
        superSomeone.setSuperPowerList(superPowerList);

        dao.addSuperSomeone(superSomeone);

        SuperSomeone fromDao
                = dao.getSuperSomeoneByID(superSomeone.getSuperSomeoneID());
        assertEquals(fromDao, superSomeone);

        dao.deleteSuperSomeone(superSomeone.getSuperSomeoneID());
        assertNull(dao.getSuperSomeoneByID(superSomeone.getSuperSomeoneID()));

    }

    @Test
    public void testGetAllSuperSomeones() {

        SuperPower superPowerforSS = new SuperPower();
        superPowerforSS.setSuperPowerName("sPowerName");
        superPowerforSS.setSuperPowerDescription("sDescription");

        dao.addSuperPower(superPowerforSS);

        List<SuperPower> superPowerList = dao.getAllSuperPowers();

        SuperSomeone superSomeoneA = new SuperSomeone();
        superSomeoneA.setSuperSomeoneType("TypeA");
        superSomeoneA.setSuperSomeoneName("NameA");
        superSomeoneA.setSuperSomeoneAlias("AliasA");
        superSomeoneA.setSuperSomeoneDescription("DescriptionA");
        superSomeoneA.setSuperPowerList(superPowerList);

        dao.addSuperSomeone(superSomeoneA);

        SuperSomeone superSomeoneB = new SuperSomeone();
        superSomeoneB.setSuperSomeoneType("TypeB");
        superSomeoneB.setSuperSomeoneName("NameB");
        superSomeoneB.setSuperSomeoneAlias("AliasB");
        superSomeoneB.setSuperSomeoneDescription("DescriptionB");
        superSomeoneB.setSuperPowerList(superPowerList);

        dao.addSuperSomeone(superSomeoneB);

        List<SuperSomeone> fromDao = dao.getAllSuperSomeones();

        assertEquals(2, fromDao.size());

    }

}
