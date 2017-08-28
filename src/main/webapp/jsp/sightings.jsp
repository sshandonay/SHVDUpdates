<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Sightings Page</title>
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
                    <h2>Logged Sightings</h2>
                </div>
                <table id="sightingTable" class="table table-hover">
                    <tr>
                        <th width="30%">Date</th>
                        <th width="30%">Description</th>
                        <th width="15%"></th>
                        <th width="15%"></th>
                    </tr>
                    <c:forEach var="currentSightingData" items="${sightingDataList}">
                        <tr>
                            <td>
                                <a href="displaySightingDetails?sightingDataID=${currentSightingData.superSomeoneSightingDataID}">
                                    <c:out value ="${currentSightingData.superSomeoneSightingDate}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value ="${currentSightingData.superSomeoneSightingDescription}"/>
                            </td>
                            <td>
                                <a href="displaySightingEdit?sightingDataID=${currentSightingData.superSomeoneSightingDataID}">
                                    Edit
                                </a>

                            </td>
                            <td>
                                <a href="deleteSighting?sightingDataID=${currentSightingData.superSomeoneSightingDataID}">
                                    Delete
                                </a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>                   
            </div>

            <div class="col-md-6">
                <h2>Add New Sighting</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createSighting">
                    <div class="form-group">
                        <label for="add-sighting-description" class="col-md-4 control-label">Sighting Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="sightingDescription" placeholder="Description" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-sighting-date" class="col-md-4 control-label">Sighting Date:</label>
                        <div class="col-md-8">
                            <input type="date" class="form-control" name="sightingDate" placeholder="Date" required="required"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-super-someone" class="col-md-4 control-label">Super Someones:</label>
                        <div class="col-md-8">
                            <select multiple class="form-control" name="superSomeonesSighted" placeholder="Super Someones" required="required">

                                <c:forEach var="currentSuperSomeone" items="${superSomeoneList}">
                                    <option value ="${currentSuperSomeone.superSomeoneID}">${currentSuperSomeone.superSomeoneName}</option>
                                </c:forEach>
                            </select>

                        </div>
                    </div>


                    <div class="form-group">
                        <label for="add-sighting-location" class="col-md-4 control-label">Locations:</label>
                        <div class="col-md-8">
                            <select class="form-control" name="sightingLocation" placeholder="Locations">

                                <c:forEach var="currentLocation" items="${locationList}">
                                    <option value ="${currentLocation.locationID}">${currentLocation.locationName}</option>
                                </c:forEach>
                            </select>

                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Sighting"/>
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