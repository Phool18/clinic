<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Medical Center - Pacientes</title>
<!----======== CSS ======== -->
<link rel="icon" href="<c:url value ="/resources/img/icon.png"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/sweetalert2.min.css" />">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/styles.css"/>">
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

<!----===== Javascript ===== -->
<script type="text/javascript"
	src="<c:url value="/resources/js/sweetalert2.min.js" />"></script>
<script src='<c:url value="/resources/js/script.js" />'></script>
</head>
<body>
	<%String add = request.getParameter("add");%>
	<script type="text/javascript">
		const msg = '<%=add%>';
		alert(msg);
	</script>
	<nav class="sidebar">
		<header>
			<div class="image-text">
				<div class="text logo-text">
					<span class="name">MEDICAL CENTER</span>
				</div>
			</div>

		</header>
		<hr>
		<div class="menu-bar">
			<div class="menu">
				<ul class="menu-links">
					<li class="nav-link"><a href="/sistema/home"> <i
							class='bx bx-home-alt icon'></i> <span class="text nav-text">Home</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/appointments"> <i
							class='bx bx-food-menu icon'></i> <span class="text nav-text">Citas</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/patients"> <i
							class='bx bx-user icon'></i> <span class="text nav-text">Pacientes</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/doctors"> <i
							class='bx bx-user icon'></i> <span class="text nav-text">Doctores</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/schedules"> <i
							class='bx bx-calendar icon'></i> <span class="text nav-text">Horarios</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/specialtys"> <i
							class='bx bx-pie-chart-alt icon'></i> <span class="text nav-text">Especialidades</span>
					</a></li>

				</ul>
			</div>

			<div class="bottom-content">
				<li class=""><a href="/sistema/logout"> <i
						class='bx bx-log-out icon'></i><span class="text nav-text">Logout</span>
				</a></li>
			</div>
		</div>

	</nav>

	<section class="home">

		<div class='container'>

			<h4 class='mt-4 text-welcome'>PACIENTES</h4>
			<hr>
			<button class='btn btn-primary' data-bs-toggle="modal"
				data-bs-target="#exampleModal">Agregar</button>
			<div class='row jutify-content-center text-center'></div>
			<br>
			<div class="card mb-4">
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th class='text-center' scope="row">DNI</th>
								<th class='text-center' scope="row">Nombres</th>
								<th class='text-center' scope="row">Telefono</th>
								<th class='text-center' scope="row">Genero</th>
								<th class='text-center' scope="row">Acciones</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th scope="row">DNI</th>
								<th scope="row">Nombres</th>
								<th scope="row">Telefono</th>
								<th scope="row">Genero</th>
								<th scope="row">Acciones</th>
							</tr>
						</tfoot>

						<tbody>
							<c:forEach items="${patientList}" var="patient">
								<tr>
									<td class='text-center'>${patient.dni}</td>
									<td class='text-center'>${patient.lastnames}, ${patient.names}</td>
									<td class='text-center'>${patient.phone}</td>
									<td class='text-center'>${patient.gender}</td>
									<td class='text-center'><a class='bx bx-trash bx-sm'
										href=""></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">REGISTRAR NUEVA
						ESPECIALIDAD</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action='addPatient' method="post">
						<div class='mb-3'>
							<input type="number" name="dni" placeholder="DNI *"
								class='form-control' required>
						</div>
						<div class='mb-3'>
							<input type="text" name="names" placeholder="Nombres *"
								class='form-control' required>
						</div>
						<div class='mb-3'>
							<input type="text" name="lastnames" placeholder="Apellidos *"
								class='form-control' required>
						</div>
						<div class='mb-3'>
							<label class="form-label">Fecha de nacimiento *</label>
							<input type="date" name="date_of_birth"
								placeholder="Fecha de nacimiento" class='form-control' required>
						</div>
						<div class='mb-3'>
							<label class="form-label">Genero *</label>
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="gender" value="masculino" checked> <label
									class="form-check-label">Masculino</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="gender" value="femenino">
								<label class="form-check-label">Femenino</label>
							</div>
						</div>
						<div class='mb-3'>
							<input type="text" name="address" placeholder="Direccion"
								class='form-control' required>
						</div>
						<div class='mb-3'>
							<input type="number" name="phone" placeholder="Telefono"
								class='form-control' required>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Guardar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src='<c:url value="/resources/js/bootstrap.bundle.min.js" />'></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value = "/resources/js/datatables-simple-demo.js"/>"></script>
</body>
</html>