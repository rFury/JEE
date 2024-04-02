<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Update Car</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Modification des Voitures
</div>
<div class="card-body">
<form action="update.do" method="post">
<div class="form-group">
<label class="control-label">ID Car:</label>
<input readonly type="text" name="id" class="form-control"
value="${car.carID}"/>
</div>
<div class="form-group">
<label class="control-label">Model Car:</label>
<input type="text" name="model" class="form-control"
value="${car.carModel}"/>
</div>
<div class="form-group">
<label class="control-label">Brand Car:</label>
<input type="text" name="brand" class="form-control" value="${car.carBrand}"/>
</div>
<div class="form-group">
<label class="control-label">Price Car:</label>
<input type="text" name="price" class="form-control" value="${car.price}"/>
</div>
<div class="form-group">
<select name="FG" class="form-control">
    <option value="${car.familyGroup.group_ID}" selected>${car.familyGroup.group_Name}</option>
    <c:forEach items="${groupModel.getFamilyGroups()}" var="FG">
        <c:if test="${FG.group_ID != car.familyGroup.group_ID}">
            <option value="${FG.group_ID}">${FG.group_Name}</option>
        </c:if>
    </c:forEach>
</select>

</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>
