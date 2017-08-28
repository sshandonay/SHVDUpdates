<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Someone Edit</title>
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
            <div>
                <sf:form class="form-horizontal" role="form" modelAttribute="superSomeone"
                         action="editSuperSomeone" method="POST">
                    <div class="form-group">
                        <label for="add-super-someone-name" class="col-md-4 control-label">Super Someone Name:</label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-super-someone-name"
                                      path="superSomeoneName" placeholder="Name" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-super-someone-type" class="col-md-4 control-label">Super Someone Type:</label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-super-someone-type"
                                      path="superSomeoneType" placeholder="Type" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-super-someone-alias" class="col-md-4 control-label">Super Someone Alias:</label>                          
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-super-someone-alias"
                                      path="superSomeoneAlias" placeholder="Alias" required="required"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="add-super-someone-description" class="col-md-4 control-label">Description:</label>                          
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-super-someone-description"
                                      path="superSomeoneDescription" placeholder="Description" required="required"/>
                            <sf:hidden path="superSomeoneID"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-super-someone-power" class="col-md-4 control-label">Super Powers:</label>
                        <div class="col-md-8">
                            <select multiple class="form-control" name="superPowers" placeholder="Powers" required="required">

                                <c:forEach var="currentSuperPower" items="${superPowers}">
                                    <option value ="${currentSuperPower.superPowerID}" selected >${currentSuperPower.superPowerName}</option>
                                </c:forEach>

                                <c:forEach var="currentSuperPower" items="${notSuperPowers}">
                                    <option value="${currentSuperPower.superPowerID}" >${currentSuperPower.superPowerName}</option>
                                </c:forEach>
                            </select>

                        </div>
                    </div>






                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Update Super Someone"/>
                        </div>
                    </div>
                </sf:form> 

            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>