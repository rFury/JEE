<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Liste des Family_Groups</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Liste des Family_Groups
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <tr>
                    <th>ID</th><th>Nom Family_Group</th><th>Date de création</th><th>Suppression</th><th>Edition</th>
                </tr>
                <c:forEach items="${model.familyGroups}" var="familyGroup">
                    <tr>
                        <td>${familyGroup.group_ID }</td>
                        <td>${familyGroup.group_Name }</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${familyGroup.dateOfCreation}" /></td>
                        <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerFamilyGroup?id=${familyGroup.group_ID}">Supprimer</a></td>
                        <td><a href="editerFamilyGroup?id=${familyGroup.group_ID}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
