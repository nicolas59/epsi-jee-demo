<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<%@ include file="../head.html"%>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Contact</a>
	</nav>
	<div class="container container-fluid mt-4">
		<h3>Ajout d'un nouvel utilisateur</h3>
		<form:form method="POST" action="../user" modelAttribute="user">
			<form:hidden path="identifier" class="form-control" />
			<div class="form-group">
				<form:label path="lastName">Nom : </form:label>
				<form:input path="lastName" class="form-control"/>
			</div>
			<div class="form-group">

				<form:label path="firstName" >
                     Prenom :</form:label>
				<form:input path="firstName" class="form-control"/>
			</div>
			<div class="form-group">

				<form:label path="phoneNumber" >
                     Mobile :</form:label>
				<form:input path="phoneNumber" class="form-control"/>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Submit" />
			</div>
		</form:form>
	</div>
</body>
</html>