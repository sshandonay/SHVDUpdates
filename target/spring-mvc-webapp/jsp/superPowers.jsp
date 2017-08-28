<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Super Powers Page</title>
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
            <div class="col-md-6 displayTableScroll">
                <div class="text-center">
                    <h2>Logged Super Powers</h2>
                </div>
                <table id="superPowerTable" class="table table-hover">
                    <tr>
                        <th width="30%">Name</th>
                        <th width="30%">Description</th>
                        <th width="15%"></th>
                        <th width="15%"></th>
                    </tr>
                    <c:forEach var="currentSuperPower" items="${superPowerList}">
                        <tr>
                            <td>
                                <c:out value ="${currentSuperPower.superPowerName}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value ="${currentSuperPower.superPowerDescription}"/>
                            </td>
                            <td>
                                <a href="displaySuperPowerEdit?superPowerID=${currentSuperPower.superPowerID}">
                                    Edit
                            </td>
                            <td>
                                <a href="deleteSuperPower?superPowerID=${currentSuperPower.superPowerID}">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>                    
            </div>

            <div class="col-md-6">
                <h2>Add New Super Power</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createSuperPower">
                    <div class="form-group">
                        <label for="add-super-power-name" class="col-md-4 control-label">Super Power Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="superPowerName" placeholder="Name" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-super-power-description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="superPowerDescription" placeholder="Description" required="required"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Super Power"/>
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