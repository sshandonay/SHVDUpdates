<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organization Edit</title>
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
            <sf:form class="form-horizontal" role="form" modelAttribute="organization"
                     action="editOrganization" method="POST">
                <div class="form-group">
                    <label for="add-organization-name" class="col-md-4 control-label">Organization Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-name"
                                  path="organizationName" placeholder="Name" required="required"/>
                        <sf:hidden path="organizationID"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-organization-type" class="col-md-4 control-label">Organization Type:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-type"
                                  path="organizationType" placeholder="Org Type: (Hero, Villain, Unknown)" required="required"/>               
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-organization-description" class="col-md-4 control-label">Description:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-description"
                                  path="organizationDescription" placeholder="Description" required="required"/>               
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-organization-contact" class="col-md-4 control-label">Contact:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-contact"
                                  path="organizationContact" placeholder="How To Contact" required="required"/>

                        
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-organization-member" class="col-md-4 control-label">Members:</label>
                    <div class="col-md-8">
                        <select multiple class="form-control" name="organizationMember" placeholder="Members" required="required">

                            <c:forEach var="currentMember" items="${members}">
                                <option value ="${currentMember.superSomeoneID}" selected >${currentMember.superSomeoneName}</option>
                            </c:forEach>

                            <c:forEach var="currentMember" items="${notMembers}">
                                <option value="${currentMember.superSomeoneID}" >${currentMember.superSomeoneName}</option>
                            </c:forEach>
                        </select>

                    </div>
                </div>


                <div class="form-group">
                    <label for="add-org-location" class="col-md-4 control-label">Locations:</label>
                    <div class="col-md-8">
                        <select multiple class="form-control" name="organizationLocation" placeholder="Locations">

                            <c:forEach var="currentLocation" items="${locations}">
                                <option value="${currentLocation.locationID}" selected >${currentLocation.locationName}</option>
                            </c:forEach>

                            <c:forEach var="currentLocation" items="${notLocations}">
                                <option value="${currentLocation.locationID}" >${currentLocation.locationName}</option>
                            </c:forEach>
                        </select>

                    </div>
                </div>



                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Organization"/>
                    </div>
                </div>
            </sf:form>                
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>