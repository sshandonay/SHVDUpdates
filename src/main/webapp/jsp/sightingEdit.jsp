<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sighting Edit</title>
        <!-- Bootstrap core CSS -->
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
        </div>

        <div>
            <sf:form class="form-horizontal" role="form" modelAttribute="sightingData"
                     action="editSightingData" method="POST">
                <div class="form-group">
                    <label for="add-sighting-description" class="col-md-4 control-label">Sighting Description:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-sighting-description"
                                  path="superSomeoneSightingDescription" placeholder="Description"/>
                        <sf:hidden path="superSomeoneSightingDataID"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-sighting-date" class="col-md-4 control-label">Sighting Date:</label>
                    <div class="col-md-8">
                        <sf:input type="date" class="form-control" id="add-sighting-date"
                                  path="superSomeoneSightingDate" placeholder="Date" required="required"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-super-someone" class="col-md-4 control-label">Super Someones:</label>
                    <div class="col-md-8">
                        <select multiple class="form-control" name="superSomeonesSighted" placeholder="Super Someones" required="required">

                            <c:forEach var="currentSuperSomeone" items="${sighted}">
                                <option value ="${currentSuperSomeone.superSomeoneID}" selected >${currentSuperSomeone.superSomeoneName}</option>
                            </c:forEach>

                            <c:forEach var="currentSuperSomeone" items="${notSighted}">
                                <option value ="${currentSuperSomeone.superSomeoneID}" >${currentSuperSomeone.superSomeoneName}</option>
                            </c:forEach>

                        </select>

                    </div>
                </div>

                <div class="form-group">
                    <label for ="addLocation" class="col-md-4 control-label">Locations:</label>
                    <div class="col-md-8">
                        <select class="form-control" name="location" placeholder="location">
                            <c:forEach var="currentLocation" items="${sightingLocations}">
                                <option value="${currentLocation.locationID}" selected >${currentLocation.locationName} </option>
                            </c:forEach>

                            <c:forEach var="currentLocation" items="${notLocations}">
                                <option value="${currentLocation.locationID}" >${currentLocation.locationName}</option>
                            </c:forEach>

                        </select>

                    </div>

                </div>



                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Sighting"/>
                    </div>
                </div>
            </sf:form>                
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>