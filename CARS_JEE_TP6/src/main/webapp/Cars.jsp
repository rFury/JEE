<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
 <div class="card-header">
 Car Search
 </div>
 <div class="card-body">
 <form action="chercher.do" method="get">
 <label>Keyword</label>
 <input type="text" name="motCle" value="${model.motCle}" />
 <button type="submit" class="btn btn-primary">Search</button>
 </form>
 <table class="table table-striped">
 <tr>
 <th>ID</th><th>Model</th><th>Brand</th><th>Price</th><th>Family_Group</th>
 <th>Delete</th><th>Edit</th>
 </tr>
 <c:forEach items="${model.cars}" var="car">
 <tr>
 <td>${car.carID}</td>
 <td>${car.carModel}</td>
 <td>${car.carBrand}</td>
 <td>${car.price}</td>
 <td>${car.familyGroup.getGroup_Name() }</td>
 <td><a onclick="return confirm('Are you sure?')" 
 href="supprimer.do?id=${car.carID}">Delete</a></td>
 <td><a href="editer.do?id=${car.carID}">Edit</a></td>
 </tr>
 </c:forEach>
 </table>
 </div>
</div>
</div>
</body>
</html>
