<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Locations Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/SpencerStyle.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">    


    </head>
    <body>
        <div class="container">
            <div class ="text-center">
                <h1>Spencer's Super Someone Sighting Site!</h1>
            </div>
            <hr/>
            <div class="text-center navbuttons">
                <div class="nav nav-button">
                    <button role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></button>
                    <button role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySuperSomeonesPage">Super Someones</a></button>
                    <button role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></button>
                    <button role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></button>
                    <button role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></button>
                    <button role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySuperPowersPage">Super Powers</a></button>
                </div>
            </div>
            <br>
            <br>
            <div class="col-md-6">
                <div class="text-center">
                    <h2>Logged Locations</h2>
                </div>
                <table id="locationsTable" class="table table-hover">
                    <tr>
                        <th width="30%">Name</th>
                        <th width="30%">City</th>
                        <th width="15%"></th>
                        <th width="15%"></th>
                    </tr>
                    <c:forEach var="currentLocation" items="${locationList}">
                        <tr>
                            <td>
                                <a href="displayLocationDetails?locationID=${currentLocation.locationID}">
                                    <c:out value ="${currentLocation.locationName}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value ="${currentLocation.locationCity}"/>
                            </td>
                            <td>
                                <a href="displayLocationEdit?locationID=${currentLocation.locationID}">
                                    Edit
                            </td>
                            <td>
                                <a href="deleteLocation?locationID=${currentLocation.locationID}">
                                    Delete

                            </td>
                        </tr>
                    </c:forEach>
                </table>                  
            </div>

            <div class="col-md-6">
                <h2>Add New Location</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createLocation">
                    <div class="form-group">
                        <label for="add-location-name" class="col-md-4 control-label">Location Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationName" placeholder="Name" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-description" class="col-md-4 control-label">Location Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationDescription" placeholder="Description" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-street" class="col-md-4 control-label">Location Street:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationStreet" placeholder="Street"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-city" class="col-md-4 control-label">Location City:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationCity" placeholder="City"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-state" class="col-md-4 control-label">Location State:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationState" placeholder="State"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-country" class="col-md-4 control-label">Location Country:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationCountry" placeholder="Country"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-latitude" class="col-md-4 control-label">Location Latitude:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationLatitude" placeholder="Latitude"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-longitude" class="col-md-4 control-label">Location Longitude:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationLongitude" placeholder="Longitude"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Location"/>
                        </div>
                    </div>
                </form>

            </div> <!-- End col div -->

        </div> <!-- End row div -->









    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>