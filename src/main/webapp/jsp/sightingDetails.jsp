<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sighting Details Page</title>
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
            <p>
                Sighting Description: <c:out value="${sightingData.superSomeoneSightingDescription}"/>
            </p>
            <p>
                Sighting Date: <c:out value="${sightingData.superSomeoneSightingDate}"/>
            </p>
            <p>
                Sighting Location: <c:out value="${sightingLocation.locationName}"/>
            </p>
            <p>
                Super Someones Sighted:
                <c:forEach var="currentSuperSomeone" items="${sightingData.superSomeoneList}">
                    <c:out value="${currentSuperSomeone.superSomeoneName}"/>
                </c:forEach>
            </p>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
