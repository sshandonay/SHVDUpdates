<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SHVD Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/SpencerStyle.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">    

    </head>
    <body>
        <div class="container" id="allpage">
            <div class ="text-center">
                <h1>Spencer's Super Someone Sighting Site!</h1>
            </div>
            <hr/>
            <div class="text-center navbuttons" >
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
            <div class ="text-center mainmessage">
                <p><h2>Welcome!</h2> </p>
                <br>
                <div class="text-center">
                    <img src="images/superhero.jpg" alt="super hero image" style="width:700px;height:228px;">
                </div>
                <br>
                <p><b>Did you just see a Super Hero? Spotted a Villain? Log sighting locations, super powers, organizations - Click the tabs to get started!</b></p>
            </div>
            <br>
            <br>
            <br>
            <div class="col-md-12">
                <h3>Recent Sightings</h3>

                <table id="topSightingsTable" class="table table-hover">
                    <tr>
                        <th width="15%">Date</th>
                        <th width="25%">Super Someone</th>
                        <th width="25%">Sighting Location</th>
                        <th width="40%">Sighting Description</th>
                    </tr>
                    <c:forEach var="currentTopSighting" items="${topSightingList}">
                        <tr>
                            <td>
                                <c:out value ="${currentTopSighting.superSomeoneSightingDate}"/>
                            </td>

                            <td>
                                <c:forEach var="superSomeone" items ="${currentTopSighting.superSomeoneList}">
                                    <c:out value="${superSomeone.superSomeoneName}"/>
                                </c:forEach>
                            </td>
                            <td>
                                <c:out value ="${currentTopSighting.location.locationName}"/>
                            </td>
                            <td>
                                <c:out value ="${currentTopSighting.superSomeoneSightingDescription}"/>
                            </td>
                        </tr>
                    </c:forEach>

                </table>    

            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <br>
    </body>
</html>