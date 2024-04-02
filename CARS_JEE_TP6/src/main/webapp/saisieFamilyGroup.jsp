<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Saisie Family_Group</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Saisie des Family_Group
        </div>
        <div class="card-body">
            <form action="saveFamilyGroup" method="post">
                <div class="form-group">
                    <label class="control-label">Nom Family_Group :</label>
                    <input type="text" name="groupName" class="form-control"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Date de cr�ation :</label>
                    <input type="date" name="dateOfCreation" class="form-control"/>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
