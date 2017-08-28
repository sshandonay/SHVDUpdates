<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organizations Page</title>
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
                    <h2>Logged Organizations</h2>
                </div>
                <table id="organizationTable" class="table table-hover">
                    <tr>
                        <th width="30%">Name</th>
                        <th width="30%">Description</th>
                        <th width="15%"></th>
                        <th width="15%"></th>
                    </tr>
                    <c:forEach var="currentOrganization" items="${organizationList}">
                        <tr>
                            <td>
                                <a href="displayOrganizationDetails?organizationID=${currentOrganization.organizationID}">
                                    <c:out value ="${currentOrganization.organizationName}"/>
                            </td>
                            <td>
                                <c:out value ="${currentOrganization.organizationDescription}"/>
                            </td>
                            <td>
                                <a href="displayOrganizationEdit?organizationID=${currentOrganization.organizationID}">
                                    Edit
                            </td>
                            <td>
                                <a href="deleteOrganization?organizationID=${currentOrganization.organizationID}">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>  

            </div>

            <div class="col-md-6">
                <h2>Add New Organization</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createOrganization">
                    <div class="form-group">
                        <label for="add-org-name" class="col-md-4 control-label">Organization Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="organizationName" placeholder="Name" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-org-type" class="col-md-4 control-label">Organization Type:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="organizationType" placeholder="Org Type: (Hero, Villain, Unknown)" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-org-description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="organizationDescription" placeholder="Description" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-org-contact" class="col-md-4 control-label">How To Contact:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="organizationContact" placeholder="Contact" required="required"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-org-location" class="col-md-4 control-label">Locations:</label>
                        <div class="col-md-8">
                            <select multiple class="form-control" name="organizationLocation" placeholder="Locations" required="required">

                                <c:forEach var="currentLocation" items="${locationList}">
                                    <option value ="${currentLocation.locationID}">${currentLocation.locationName}</option>
                                </c:forEach>
                            </select>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-org-member" class="col-md-4 control-label">Members:</label>
                        <div class="col-md-8">
                            <select multiple class="form-control" name="organizationMember" placeholder="Members">

                                <c:forEach var="currentMember" items="${memberList}">
                                    <option value ="${currentMember.superSomeoneID}">${currentMember.superSomeoneName}</option>
                                </c:forEach>
                            </select>

                        </div>
                    </div>






                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Organization"/>
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