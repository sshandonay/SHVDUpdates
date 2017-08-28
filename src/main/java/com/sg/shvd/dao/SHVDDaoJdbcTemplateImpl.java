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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class SHVDDaoJdbcTemplateImpl implements SHVDDao {

//JDBC Template Setter injection
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Prepared Statements
//Location
    private static final String SQL_INSERT_LOCATION
            = "insert into Location (LocationName, LocationDescription, LocationStreet, LocationCity, LocationState, LocationCountry, LocationLatitude, LocationLongitude) values (?, ?, ?, ?, ?, ?, ?, ?) ;";

    private static final String SQL_DELETE_LOCATION
            = "delete from Location where LocationID = ?";

    private static final String SQL_UPDATE_LOCATION
            = "update Location set LocationName = ?, LocationDescription = ?, LocationStreet = ?, LocationCity = ?, LocationState = ?, LocationCountry = ?, LocationLatitude = ?, LocationLongitude = ? where LocationID = ? ;";

    private static final String SQL_SELECT_LOCATION
            = "select * from Location where LocationID = ? ;";

    private static final String SQL_SELECT_ALL_LOCATIONS
            = "select * from Location";

//Location FK  *ALL SIGHTINGS WHERE LOCATION_ID = ?
    private static final String SQL_DELETE_LOCATION_FK_SUPSOMSIGHTDATA
            = "delete from SuperSomeoneSightingData where LocationID = ? ;";

//OrganizationLocation (BRIDGE TBL)
    private static final String SQL_DELETE_ORGANIZATION_FK_ORGLOC
            = "delete from OrganizationLocation where OrganizationID = ?";

    private static final String SQL_DELETE_LOCATION_FK_ORGLOC
            = "delete from OrganizationLocation where LocationID = ? ;";

    private static final String SQL_INSERT_ORGANIZATION_LOCATION
            = "insert into OrganizationLocation (OrganizationID, LocationID) values(?,?) ;";

    private static final String SQL_SELECT_LOCATIONS_BY_ORGANIZATION_ID
            = "select Location.LocationID, Location.LocationName, Location.LocationDescription, Location.LocationStreet, Location.LocationCity, Location.LocationState, Location.LocationLatitude, Location.LocationLongitude"
            + "from Location "
            + "join OrganizationLocation on Location.LocationID = OrganizationLocation.LocationID "
            + "join Organization on Organization.OrganizationID = OrganizationLocation.LocationID "
            + "Where Organization.OrganizationID = ? ; ";

//Organization
    private static final String SQL_INSERT_ORGANIZATION
            = "insert into Organization (OrganizationType, OrganizationName, OrganizationDescription, OrganizationContact) values (?,?,?,?)";

    private static final String SQL_DELETE_ORGANIZATION
            = "delete from Organization where OrganizationID = ?";

    private static final String SQL_UPDATE_ORGANIZATION
            = "update Organization set OrganizationType = ?, OrganizationName = ?, OrganizationDescription = ?, OrganizationContact = ? where OrganizationID = ? ;";

    private static final String SQL_SELECT_ORGANIZATION
            = "select * from Organization where OrganizationID = ?";

    private static final String SQL_SELECT_ALL_ORGANIZATIONS
            = "select * from Organization";

//SuperPower
    private static final String SQL_INSERT_SUPERPOWER
            = "insert into SuperPower (SuperPowerName, SuperPowerDescription) values (?,?)";

    private static final String SQL_DELETE_SUPERPOWER
            = "delete from SuperPower where SuperPowerID = ?";

    private static final String SQL_UPDATE_SUPERPOWER
            = "update SuperPower set SuperPowerName = ?, SuperPowerDescription = ? where SuperPowerID = ? ;";

    private static final String SQL_SELECT_SUPERPOWER
            = "select * from SuperPower where SuperPowerID = ?";

    private static final String SQL_SELECT_ALL_SUPERPOWERS
            = "select * from SuperPower";

//SuperSomeoneSuperPower (BRIDGE TBL)
    private static final String SQL_DELETE_SUPERPOWER_FK_SUPSOMESUPPOW
            = "delete from SuperSomeoneSuperPower where SuperPowerID = ?";

    private static final String SQL_DELETE_SUPERSOMEONE_FK_SUPSOMESUPPOW
            = "delete from SuperSomeoneSuperPower where SuperSomeoneID = ?";

    private static final String SQL_INSERT_SUPERSOMEONE_SUPERPOWER
            = "insert into SuperSomeoneSuperPower (SuperPowerID, SuperSomeoneID) values (?, ?)";

    private static final String SQL_SELECT_ALL_POWERS_BY_SUPERSOMEONE_ID
            = "SELECT * FROM SuperPower JOIN SuperSomeoneSuperPower ON SuperPower.SuperPowerID = SuperSomeoneSuperPower.SuperPowerID where SuperSomeoneSuperPower.SuperSomeoneID = ?";

//SuperSomeone
    private static final String SQL_INSERT_SUPERSOMEONE
            = "insert into SuperSomeone (SuperSomeoneType, SuperSomeoneName, SuperSomeoneAlias, SuperSomeoneDescription) values (?,?,?,?)";

    private static final String SQL_DELETE_SUPERSOMEONE
            = "delete from SuperSomeone where SuperSomeoneID = ?";

    private static final String SQL_UPDATE_SUPERSOMEONE
            = "update SuperSomeone set SuperSomeoneType = ?, SuperSomeoneName = ?, SuperSomeoneAlias = ?, SuperSomeoneDescription = ? where SuperSomeoneID = ? ";

    private static final String SQL_SELECT_SUPERSOMEONE
            = "select * from SuperSomeone where SuperSomeoneID = ?";

    private static final String SQL_SELECT_ALL_SUPERSOMEONES
            = "select * from SuperSomeone";

    //Member (BRIDGE TBL)
    private static final String SQL_DELETE_SUPERSOMEONE_FK_MEM
            = "delete from Member where SuperSomeoneID = ?";

    private static final String SQL_DELETE_ORGANIZATION_FK_MEM
            = "delete from Member where OrganizationID = ?";

    private static final String SQL_INSERT_MEMBER
            = "insert into Member (SuperSomeoneID, OrganizationID) values (?, ?);";

//SightingData
    private static final String SQL_INSERT_SUPERSOMEONESIGHTINGDATA
            = "insert into SuperSomeoneSightingData (LocationID, SuperSomeoneSightingDescription, SuperSomeoneSightingDate) value (?, ?, ?)";

    private static final String SQL_DELETE_SUPERSOMEONESIGHTINGDATA
            = "delete from SuperSomeoneSightingData where SuperSomeoneSightingDataID = ?";

    private static final String SQL_UPDATE_SUPERSOMEONESIGHTINGDATA
            = "update SuperSomeoneSightingData set LocationID = ?, SuperSomeoneSightingDescription = ?, SuperSomeoneSightingDate = ?  where SuperSomeoneSightingDataID = ?";

    private static final String SQL_SELECT_SUPERSOMEONESIGHTINGDATA
            = "select * from SuperSomeoneSightingData where SuperSomeoneSightingDataID = ?";

    private static final String SQL_SELECT_ALL_SUPERSOMEONESIGHTINGDATA
            = "select * from SuperSomeoneSightingData";

    //SuperSomeoneSighting (BRIDGE TBL)
    private static final String SQL_DELETE_SUPERSOMEONE_FK_SUPSOMSIGHT
            = "delete from SuperSomeoneSighting where SuperSomeoneID = ?";

    private static final String SQL_DELETE_SUPERSOMEONESIGHTINGDATA_FK_SUPSOMSIGHT
            = "delete from SuperSomeoneSighting where SuperSomeoneSightingDataID = ? ;";

    private static final String SQL_INSERT_SUPERSOMEONE_SIGHTING
            = "insert into SuperSomeoneSighting (SuperSomeoneID, SuperSomeoneSightingDataID) values (?, ?)";

//Required SQL
//The system must be able to report all of the superheros sighted at a particular location.
    private static final String SQL_GET_SUPERSOMEONES_BY_LOCATION_NAME
            = "SELECT SuperSomeoneSighting.SuperSomeoneID, SuperSomeone.SuperSomeoneName "
            + "FROM SuperSomeoneSighting "
            + "JOIN SuperSomeoneSightingData ON SuperSomeoneSighting.SuperSomeoneSightingDataID = SuperSomeoneSightingData.SuperSomeoneSightingDataID "
            + "JOIN SuperSomeone ON SuperSomeone.SuperSomeoneID  = SuperSomeoneSighting.SuperSomeoneID "
            + "JOIN Location ON Location.LocationID = SuperSomeoneSightingData.LocationID "
            + "WHERE Location.LocationName = ?";

    private static final String SQL_GET_SUPERSOMEONES_BY_LOCATION_ID
            = "SELECT SuperSomeoneSighting.SuperSomeoneID, SuperSomeone.SuperSomeoneName"
            + "FROM SuperSomeoneSighting"
            + "JOIN SuperSomeoneSightingData ON SuperSomeoneSighting.SuperSomeoneSightingDataID = SuperSomeoneSightingData.SuperSomeoneSightingDataID"
            + "JOIN SuperSomeone ON SuperSomeone.SuperSomeoneID  = SuperSomeoneSighting.SuperSomeoneID"
            + "JOIN Location ON Location.LocationID = SuperSomeoneSightingData.LocationID"
            + "WHERE Location.LocationID = ?";

//The system must be able to report all of the locations where a particular superhero has been seen.
    private static final String SQL_GET_LOCATIONS_BY_SUPERPERSON_NAME
            = "SELECT Location.LocationName"
            + "FROM Location"
            + "JOIN SuperSomeoneSightingData ON SuperSomeoneSightingData.LocationID = Location.LocationID"
            + "JOIN SuperSomeoneSighting ON SuperSomeoneSighting.SuperSomeoneSightingDataID = SuperSomeoneSightingData.SuperSomeoneSightingDataID"
            + "JOIN SuperSomeone ON SuperSomeone.SuperSomeoneID = SuperSomeoneSighting.SuperSomeoneID"
            + "WHERE SuperSomeone.SuperSomeoneName = ?";

    private static final String SQL_GET_LOCATIONS_BY_SUPERPERSON_ID
            = "SELECT Location.LocationName"
            + "FROM Location"
            + "JOIN SuperSomeoneSightingData ON SuperSomeoneSightingData.LocationID = Location.LocationID"
            + "JOIN SuperSomeoneSighting ON SuperSomeoneSighting.SuperSomeoneSightingDataID = SuperSomeoneSightingData.SuperSomeoneSightingDataID"
            + "JOIN SuperSomeone ON SuperSomeone.SuperSomeoneID = SuperSomeoneSighting.SuperSomeoneID"
            + "WHERE SuperSomeone.SuperSomeoneID = ?";

//The system must be able to report all sightings (hero and location) for a particular date.
    private static final String SQL_GET_SIGHTINGS_BY_DATE
            = "SELECT SuperSomeone.SuperSomeoneName, Location.LocationName, SuperSomeoneSightingData.SuperSomeoneSightingDate"
            + "FROM SuperSomeoneSightingData"
            + "JOIN Location ON Location.LocationID = SuperSomeoneSightingData.LocationID"
            + "JOIN SuperSomeoneSighting ON SuperSomeoneSighting.SuperSomeoneSightingDataID = SuperSomeoneSightingData.SuperSomeoneSightingDataID"
            + "JOIN SuperSomeone ON SuperSomeone.SuperSomeoneID = SuperSomeoneSighting.SuperSomeoneID"
            + "WHERE SuperSomeoneSightingDate = ?";

//The system must be able to report all of the members of a particular organization.
    private static final String SQL_GET_MEMBERS_BY_ORGANIZATION_NAME
            = "SELECT SS.SuperSomeoneName, Organization.OrganizationName"
            + "FROM SuperSomeone AS SS"
            + "JOIN Member ON SS.SuperSomeoneID = Member.SuperSomeoneID"
            + "JOIN Organization ON Member.OrganizationID = Organization.OrganizationID"
            + "WHERE Organization.OrganizationName = ?";

    private static final String SQL_GET_MEMBERS_BY_ORGANIZATION_ID
            = "SELECT SS.SuperSomeoneName, Organization.OrganizationID"
            + "FROM SuperSomeone AS SS"
            + "JOIN Member ON SS.SuperSomeoneID = Member.SuperSomeoneID"
            + "JOIN Organization ON Member.OrganizationID = Organization.OrganizationID"
            + "WHERE Organization.OrganizationID = ?";

//The system must be able to report all of the organizations a particular superhero/villian belongs to.
    private static final String SQL_GET_ORGANIZATIONS_BY_SUPERPERSON_NAME
            = "SELECT Organization.OrganizationName"
            + "FROM Organization"
            + "JOIN Member on Member.OrganizationID = Organization.OrganizationID"
            + "JOIN SuperSomeone on Member.SuperSomeoneID = SuperSomeone.SuperSomeoneID"
            + "WHERE SuperSomeone.SuperSomeoneName = ?";

    private static final String SQL_GET_ORGANIZATIONS_BY_SUPERPERSON_ID
            = "SELECT Organization.OrganizationName"
            + "FROM Organization"
            + "JOIN Member on Member.OrganizationID = Organization.OrganizationID"
            + "JOIN SuperSomeone on Member.SuperSomeoneID = SuperSomeone.SuperSomeoneID"
            + "WHERE SuperSomeone.SuperSomeoneID = ?";

//Home Page Top 10 Most Recent Sightings
    private static final String SQL_GET_TOP_SIGHTINGS_ENHANCED
            = "select SuperSomeoneSightingData.SuperSomeoneSightingDate, SuperSomeone.SuperSomeoneName, Location.LocationName, SuperSomeoneSightingData.SuperSomeoneSightingDescription "
            + "from SuperSomeone "
            + "join SuperSomeoneSighting on SuperSomeone.SuperSomeoneID = SuperSomeoneSighting.SuperSomeoneID "
            + "join SuperSomeoneSightingData on SuperSomeoneSighting.SuperSomeoneSightingDataID = SuperSomeoneSightingData.SuperSomeoneSightingDataID "
            + "join Location on SuperSomeoneSightingData.LocationID = Location.LocationID ORDER BY SuperSomeoneSightingData.SuperSomeoneSightingDate DESC "
            + "LIMIT 10; ";

    private static final String SQL_GET_TOP_SIGHTINGS
            = "select * "
            + "from SuperSomeoneSightingData "
            + "ORDER BY SuperSomeoneSightingData.SuperSomeoneSightingDate DESC "
            + "LIMIT 10; ";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationStreet(),
                location.getLocationCity(),
                location.getLocationState(),
                location.getLocationCountry(),
                location.getLocationLatitude(),
                location.getLocationLongitude());

        int locationID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);

        location.setLocationID(locationID);

    }

    @Override
    public void deleteLocation(int locationID) {

        jdbcTemplate.update(SQL_DELETE_LOCATION_FK_ORGLOC, locationID);
        jdbcTemplate.update(SQL_DELETE_LOCATION_FK_SUPSOMSIGHTDATA, locationID);
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationID);

    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationStreet(),
                location.getLocationCity(),
                location.getLocationState(),
                location.getLocationCountry(),
                location.getLocationLatitude(),
                location.getLocationLongitude(),
                location.getLocationID());
    }

    @Override
    public Location getLocationByID(int locationID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION,
                    new LocationMapper(),
                    locationID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS,
                new LocationMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organization organization) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                organization.getOrganizationType(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationContact());

        int organizationID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);

        organization.setOrganizationID(organizationID);
        insertOrganizationLocation(organization);
        insertOrganizationMember(organization);

    }

    @Override
    public void deleteOrganization(int organizationID) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION_FK_ORGLOC, organizationID);
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION_FK_MEM, organizationID);
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organizationID);
    }

    @Override
    public void updateOrganization(Organization organization) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                organization.getOrganizationType(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationContact(),
                organization.getOrganizationID());

        jdbcTemplate.update(SQL_DELETE_ORGANIZATION_FK_MEM, organization.getOrganizationID());
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION_FK_ORGLOC, organization.getOrganizationID());

        insertOrganizationLocation(organization);
        insertOrganizationMember(organization);
    }

    @Override
    public Organization getOrganizationByID(int organizationID) {
        try {
            Organization organization = jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION,
                    new OrganizationMapper(),
                    organizationID);
            organization.setMemberList(getMembersForOrganization(organization));
            organization.setLocationList(getLocationsForOrganization(organization));
            return organization;

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private List<SuperSomeone> getMembersForOrganization(Organization organization) {
        List<SuperSomeone> superSomeoneList = jdbcTemplate.query(SQL_SELECT_MEMBER_BY_ORGANIZATIONID,
                new SuperSomeoneMapper(),
                organization.getOrganizationID());

        return linkSuperPowersWithSuperSomeones(superSomeoneList);
    }

    private static final String SQL_SELECT_MEMBER_BY_ORGANIZATIONID
            = "SELECT * FROM SuperSomeone ss JOIN Member m on ss.SuperSomeoneID = m.SuperSomeoneID where m.OrganizationID = ? ;";

    private List<Location> getLocationsForOrganization(Organization organization) {
        return jdbcTemplate.query(SQL_SELECT_LOCATIONS_BY_ORGANIZATIONID,
                new LocationMapper(), organization.getOrganizationID());

    }

    private static final String SQL_SELECT_LOCATIONS_BY_ORGANIZATIONID
            = " SELECT * FROM Location l JOIN OrganizationLocation ol ON l.LocationID = ol.LocationID WHERE ol.OrganizationID = ? ;";

    private List<Organization> linkMembersAndLocationsWithOrganization(List<Organization> organizationList) {
        for (Organization currentOrganization : organizationList) {
            currentOrganization.setMemberList(getMembersForOrganization(currentOrganization));
            currentOrganization.setLocationList(getLocationsForOrganization(currentOrganization));
        }
        return organizationList;
    }

    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization organization = new Organization();
            organization.setOrganizationID(rs.getInt("OrganizationID"));
            organization.setOrganizationType(rs.getString("OrganizationType"));
            organization.setOrganizationName(rs.getString("OrganizationName"));
            organization.setOrganizationDescription(rs.getString("OrganizationDescription"));
            organization.setOrganizationContact(rs.getString("OrganizationContact"));

            return organization;

        }

    }

    @Override
    public List<Organization> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS,
                new OrganizationMapper());
    }

    private void insertOrganizationLocation(Organization organization) {
        final int organizationID = organization.getOrganizationID();
        final List<Location> locations = organization.getLocationList();

        for (Location currentLocation : locations) {
            jdbcTemplate.update(SQL_INSERT_ORGANIZATION_LOCATION, organizationID,
                    currentLocation.getLocationID());
        }

    }

    private void insertOrganizationMember(Organization organization) {
        int organizationID = organization.getOrganizationID();
        List<SuperSomeone> memberList = organization.getMemberList();

        for (SuperSomeone currentMember : memberList) {
            jdbcTemplate.update(SQL_INSERT_MEMBER, currentMember.getSuperSomeoneID(), organizationID);
        }

    }

    @Override
    public List<Location> findLocationsForOrganization(Organization organization) {
        return jdbcTemplate.query(SQL_SELECT_LOCATIONS_BY_ORGANIZATION_ID,
                new LocationMapper(),
                organization.getOrganizationID());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuperPower(SuperPower superPower) {
        jdbcTemplate.update(SQL_INSERT_SUPERPOWER,
                superPower.getSuperPowerName(),
                superPower.getSuperPowerDescription());
        int superPowerID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        superPower.setSuperPowerID(superPowerID);

    }

    @Override
    public void deleteSuperPower(int superPowerID) {
        jdbcTemplate.update(SQL_DELETE_SUPERPOWER_FK_SUPSOMESUPPOW, superPowerID);
        jdbcTemplate.update(SQL_DELETE_SUPERPOWER, superPowerID);
    }

    @Override
    public void updateSuperPower(SuperPower superPower) {
        jdbcTemplate.update(SQL_UPDATE_SUPERPOWER,
                superPower.getSuperPowerName(),
                superPower.getSuperPowerDescription(),
                superPower.getSuperPowerID());
    }

    @Override
    public SuperPower getSuperPowerByID(int superPowerID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERPOWER,
                    new SuperPowerMapper(),
                    superPowerID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SuperPower> getAllSuperPowers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERPOWERS,
                new SuperPowerMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuperSomeone(SuperSomeone superSomeone) {
        jdbcTemplate.update(SQL_INSERT_SUPERSOMEONE,
                superSomeone.getSuperSomeoneType(),
                superSomeone.getSuperSomeoneName(),
                superSomeone.getSuperSomeoneAlias(),
                superSomeone.getSuperSomeoneDescription());

        int superSomeoneID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        superSomeone.setSuperSomeoneID(superSomeoneID);

        insertSuperSomeoneSuperPower(superSomeone);

    }

    @Override
    public void deleteSuperSomeone(int superSomeoneID) {
        jdbcTemplate.update(SQL_DELETE_SUPERSOMEONE_FK_MEM, superSomeoneID);
        jdbcTemplate.update(SQL_DELETE_SUPERSOMEONE_FK_SUPSOMSIGHT, superSomeoneID);
        jdbcTemplate.update(SQL_DELETE_SUPERSOMEONE_FK_SUPSOMESUPPOW, superSomeoneID);
        jdbcTemplate.update(SQL_DELETE_SUPERSOMEONE, superSomeoneID);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSuperSomeone(SuperSomeone superSomeone) {
        jdbcTemplate.update(SQL_UPDATE_SUPERSOMEONE,
                superSomeone.getSuperSomeoneType(),
                superSomeone.getSuperSomeoneName(),
                superSomeone.getSuperSomeoneAlias(),
                superSomeone.getSuperSomeoneDescription(),
                superSomeone.getSuperSomeoneID());

        jdbcTemplate.update(SQL_DELETE_SUPERSOMEONE_SUPERPOWERS, superSomeone.getSuperSomeoneID());
        insertSuperSomeoneSuperPower(superSomeone);

    }

    private static final String SQL_DELETE_SUPERSOMEONE_SUPERPOWERS
            = "DELETE FROM SuperSomeoneSuperPower WHERE SuperSomeoneID = ? ;";

    @Override
    public SuperSomeone getSuperSomeoneByID(int superSomeoneID) {
        try {
            SuperSomeone superSomeone = jdbcTemplate.queryForObject(SQL_SELECT_SUPERSOMEONE,
                    new SuperSomeoneMapper(),
                    superSomeoneID);
            superSomeone.setSuperPowerList(getSuperPowersOfSuperSomeone(superSomeone));
            return superSomeone;

        } catch (EmptyResultDataAccessException ex) {
            return null;

        }

    }

    @Override
    public List<SuperSomeone> getAllSuperSomeones() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERSOMEONES,
                new SuperSomeoneMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSightingData(SightingData sightingData) {

        String myDate = sightingData.getSuperSomeoneSightingDate().toString();
        String myFormattedDate = myDate.replace("-", "");

        jdbcTemplate.update(SQL_INSERT_SUPERSOMEONESIGHTINGDATA,
                sightingData.getLocationID(),
                sightingData.getSuperSomeoneSightingDescription(),
                myFormattedDate);

        int superSomeoneSightingDataID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        sightingData.setSuperSomeoneSightingDataID(superSomeoneSightingDataID);

        saveSighting(sightingData);
    }

    private void saveSighting(SightingData sightingData) {
        int sightingDataID = sightingData.getSuperSomeoneSightingDataID();
        List<SuperSomeone> superSomeones = sightingData.getSuperSomeoneList();

        for (SuperSomeone currentSuperSomeone : superSomeones) {
            jdbcTemplate.update(SQL_INSERT_SUPERSOMEONE_SIGHTING, currentSuperSomeone.getSuperSomeoneID(), sightingDataID);

        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSightingData(int superSomeoneSightingDataID) {
        jdbcTemplate.update(SQL_DELETE_SUPERSOMEONESIGHTINGDATA_FK_SUPSOMSIGHT, superSomeoneSightingDataID);
        jdbcTemplate.update(SQL_DELETE_SUPERSOMEONESIGHTINGDATA, superSomeoneSightingDataID);

    }

    @Override
    public void updateSightingData(SightingData sightingData) {

        String myDate = sightingData.getSuperSomeoneSightingDate().toString();
        String myFormattedDate = myDate.replace("-", "");

        jdbcTemplate.update(SQL_UPDATE_SUPERSOMEONESIGHTINGDATA,
                sightingData.getLocation().getLocationID(),
                sightingData.getSuperSomeoneSightingDescription(),
                myFormattedDate,
                sightingData.getSuperSomeoneSightingDataID());

        jdbcTemplate.update(SQL_DELETE_SUPERSOMEONESIGHTINGDATA_FK_SUPSOMSIGHT, sightingData.getSuperSomeoneSightingDataID());

        saveSighting(sightingData);
    }

    @Override
    public SightingData getSightingDataByID(int SuperSomeoneSightingDataID) {
        try {
            SightingData sightingData = jdbcTemplate.queryForObject(SQL_SELECT_SUPERSOMEONESIGHTINGDATA,
                    new SightingDataMapper(),
                    SuperSomeoneSightingDataID);

            sightingData.setSuperSomeoneList(getSuperSomeoneForSightingData(sightingData));

            sightingData.setLocation(getLocationForSightingData(sightingData));

            return sightingData;

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SightingData> getAllSightingData() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERSOMEONESIGHTINGDATA, new SightingDataMapper());

    }

    @Override
    public List<SightingData> showTopSightings() {
        List<SightingData> sightingList = jdbcTemplate.query(SQL_GET_TOP_SIGHTINGS,
                new SightingDataMapper());
        return linkSuperHeroAndLocationWithSightingData(sightingList);

    }

    private List<SightingData> linkSuperHeroAndLocationWithSightingData(List<SightingData> sightingList) {
        for (SightingData currentSighting : sightingList) {
            currentSighting.setSuperSomeoneList(getSuperSomeoneForSightingData(currentSighting));
            currentSighting.setLocation(getLocationForSightingData(currentSighting));
        }
        return sightingList;
    }

    private List<SuperSomeone> getSuperSomeoneForSightingData(SightingData sightingData) {
        List<SuperSomeone> superSomeoneList = jdbcTemplate.query(SQL_SELECT_SUPERSOMEONE_BY_SIGHTINGDATAID, new SuperSomeoneMapper(),
                sightingData.getSuperSomeoneSightingDataID());

        return linkSuperPowersWithSuperSomeones(superSomeoneList);
    }

    private Location getLocationForSightingData(SightingData sightingData) {
        return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION_BY_SIGHTINGDATAID,
                new LocationMapper(),
                sightingData.getSuperSomeoneSightingDataID());
    }

    private List<SuperSomeone> linkSuperPowersWithSuperSomeones(List<SuperSomeone> superSomeoneList) {
        for (SuperSomeone currentSuperSomeone : superSomeoneList) {
            currentSuperSomeone.setSuperPowerList(getSuperPowersOfSuperSomeone(currentSuperSomeone));
        }
        return superSomeoneList;
    }

    private static final String SQL_SELECT_SUPERSOMEONE_BY_SIGHTINGDATAID
            = "SELECT * FROM SuperSomeone SS JOIN SuperSomeoneSighting SSS ON SS.SuperSomeoneID = SSS.SuperSomeoneID WHERE SSS.SuperSomeoneSightingDataID = ?";

    private static final String SQL_SELECT_LOCATION_BY_SIGHTINGDATAID
            = "SELECT * FROM SuperSomeoneSightingData SSSD JOIN Location L ON SSSD.LocationID = L.LocationID WHERE SSSD.SuperSomeoneSightingDataID = ?";

    //Helper Section
    private void insertSuperSomeoneSuperPower(SuperSomeone superSomeone) {
        int superSomeoneID = superSomeone.getSuperSomeoneID();
        List<SuperPower> superPowerList = superSomeone.getSuperPowerList();

        for (SuperPower currentSuperPower : superPowerList) {
            jdbcTemplate.update(SQL_INSERT_SUPERSOMEONE_SUPERPOWER, currentSuperPower.getSuperPowerID(), superSomeoneID);
        }
    }

    private List<SuperPower> getSuperPowersOfSuperSomeone(SuperSomeone superSomeone) {
        return jdbcTemplate.query(SQL_SELECT_ALL_POWERS_BY_SUPERSOMEONE_ID,
                new SuperPowerMapper(), superSomeone.getSuperSomeoneID());
    }

    @Override
    public List<Organization> getOrganizationsBySuperSomeone(int superSomeoneID) {
        List<Organization> organizationList = jdbcTemplate.query(SQL_SELECT_ORGANIZATION_BY_SUPERSOMEONEID,
                new OrganizationMapper(),
                superSomeoneID);
        return linkMembersAndLocationsWithOrganization(organizationList);

    }

    public List<Organization> getOrganizationsByLocationID(int locationID) {
        List<Organization> organizationList = jdbcTemplate.query(SQL_SELECT_ORGANIZATION_BY_LOCATIONID,
                new OrganizationMapper(),
                locationID);

        return linkMembersAndLocationsWithOrganization(organizationList);
    }

    private static final String SQL_SELECT_ORGANIZATION_BY_LOCATIONID
            = "SELECT o.OrganizationID, o.OrganizationType, o.OrganizationName, o.OrganizationDescription, o.OrganizationContact FROM Organization o JOIN OrganizationLocation ol ON ol.LocationID WHERE o.OrganizationID = ol.OrganizationID AND ol.LocationID = ? ;";

    private static final String SQL_SELECT_ORGANIZATION_BY_SUPERSOMEONEID
            = "SELECT o.OrganizationID, o.OrganizationType, o.OrganizationName, o.OrganizationDescription, o.OrganizationContact FROM Organization o JOIN Member m on SuperSomeoneID WHERE o.OrganizationID = m.OrganizationID and m.SuperSomeoneID = ? ; ";

//Mapper Section
    //Location
    private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location location = new Location();
            location.setLocationID(rs.getInt("LocationID"));
            location.setLocationName(rs.getString("LocationName"));
            location.setLocationDescription(rs.getString("LocationDescription"));
            location.setLocationStreet(rs.getString("LocationStreet"));
            location.setLocationCity(rs.getString("LocationCity"));
            location.setLocationState(rs.getString("LocationState"));
            location.setLocationCountry(rs.getString("LocationCountry"));
            location.setLocationLatitude(rs.getBigDecimal("LocationLatitude"));
            location.setLocationLongitude(rs.getBigDecimal("LocationLongitude"));
            return location;
        }
    }

    //SuperPower
    private static final class SuperPowerMapper implements RowMapper<SuperPower> {

        @Override
        public SuperPower mapRow(ResultSet rs, int i) throws SQLException {
            SuperPower superPower = new SuperPower();
            superPower.setSuperPowerID(rs.getInt("SuperPowerID"));
            superPower.setSuperPowerName(rs.getString("SuperPowerName"));
            superPower.setSuperPowerDescription(rs.getString("SuperPowerDescription"));
            return superPower;
        }
    }

    //SuperSomeone
    private static final class SuperSomeoneMapper implements RowMapper<SuperSomeone> {

        @Override
        public SuperSomeone mapRow(ResultSet rs, int i) throws SQLException {
            SuperSomeone superSomeone = new SuperSomeone();
            superSomeone.setSuperSomeoneID(rs.getInt("SuperSomeoneID"));
            superSomeone.setSuperSomeoneType(rs.getString("SuperSomeoneType"));
            superSomeone.setSuperSomeoneName(rs.getString("SuperSomeoneName"));
            superSomeone.setSuperSomeoneAlias(rs.getString("SuperSomeoneAlias"));
            superSomeone.setSuperSomeoneDescription(rs.getString("SuperSomeoneDescription"));
            return superSomeone;
        }
    }

    //SuperSomeoneSighting
    private static final class SightingDataMapper implements RowMapper<SightingData> {

        @Override
        public SightingData mapRow(ResultSet rs, int i) throws SQLException {
            SightingData sightingData = new SightingData();
            sightingData.setSuperSomeoneSightingDataID(rs.getInt("SuperSomeoneSightingDataID"));
            sightingData.setLocationID(rs.getInt("LocationID"));
            sightingData.setSuperSomeoneSightingDescription(rs.getString("SuperSomeoneSightingDescription"));
            sightingData.setSuperSomeoneSightingDate(rs.getTimestamp("SuperSomeoneSightingDate").toLocalDateTime().toLocalDate());
            return sightingData;
        }
    }

}
