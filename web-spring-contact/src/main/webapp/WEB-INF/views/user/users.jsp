<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<%@ include file="../head.html"%>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Contact</a>
	</nav>
	<div class="container container-fluid mt-2">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Prenom</th>
					<th scope="col">Nom</th>
					<th scope="col">Tel</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.identifier}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.phoneNumber}</td>
						<td><a href="user/${user.identifier}"> <i
								class="fas fa-edit"></i>
						</a> <a href="user/delete/${user.identifier}"> <i
								class="fas fa-trash"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-right" style="margin:-40px 30px 0 0 ">
			<a href="user/initForm"> <i class="fas fa-plus-circle fa-3x"></i>
			</a>
		</div>
	</div>
</body>

</html>