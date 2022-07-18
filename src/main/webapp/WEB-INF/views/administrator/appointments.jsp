<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Medical Center - Citas</title>
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
<script type="text/javascript"
	src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>

	<c:if test="${message != null}">
		<script type="text/javascript">
			viewAlert('${message}', '${messageType}');
		</script>
	</c:if>
	
	<nav class="sidebar">
		<header>
			<div class="image-text">
				<span class="image"> <img
					src="<c:url value = "/resources/img/logo.png"/>" alt="logo">
				</span>

				<div class="text header-text">
					<span class="name">MEDICAL CENTER</span>
				</div>
			</div>

			<em class="bx bx-chevron-right toogle"></em>
		</header>
		<div class="menu-bar">
			<div class="menu">
				<ul class="menu-links">
					<li class="nav-link"><a href="/sistema/home">
							<em class='bx bx-home-alt icon'></em> <span class="text nav-text">Home</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/appointments" class="select"> <em
							class='bx bx-food-menu icon'></em> <span class="text nav-text">Citas</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/patients"> <em
							class='bx bx-user icon'></em> <span class="text nav-text">Pacientes</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/doctors"> <em
							class='bx bx-user icon'></em> <span class="text nav-text">Doctores</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/schedules"> <em
							class='bx bx-calendar icon'></em> <span class="text nav-text">Horarios</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/specialtys"> <em
							class='bx bx-pie-chart-alt icon'></em> <span class="text nav-text">Especialidades</span>
					</a></li>

				</ul>
			</div>

			<div class="bottom-content">
				<ul>
					<li class=""><a href="/sistema/logout"> <em class="bx bx-log-out icon"></em>
							<span class="text nav-text">Logout</span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="home">

		<div class='container'>

			<h4 class='mt-4 text-welcome'>CITAS</h4>
			<hr>
			<button class='btn btn-primary' data-bs-toggle="modal"
				data-bs-target="#exampleModal">Agregar</button>
			<div class='row jutify-content-center text-center'></div>
			<br>
			<div class="card mb-4">
				<div class="card-body">
					<table id="datatablesSimple" >
						<caption>Registro de citas</caption>
						<thead>
							<tr>
								<th class='text-center' scope="row">ID</th>
								<th class='text-center' scope="row">Fecha</th>
								<th class='text-center' scope="row">Hora</th>
								<th class='text-center' scope="row">Paciente</th>
								<th class='text-center' scope="row">Acciones</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th scope="row">ID</th>
								<th scope="row">Tipo</th>
								<th scope="row">Estado</th>
								<th scope="row">Acciones</th>
							</tr>
						</tfoot>

						<tbody>
							<c:forEach items="${specialtys}" var="sp">
								<c:url var="deleteSpecialty" value="/deleteSpecialty">
									<c:param name="specialtyId" value="${sp.id}" />
								</c:url>
								<tr>
									<td class='text-center'>${sp.id}</td>
									<td class='text-center'>${sp.type }</td>
									<td class='text-center'>${sp.status }</td>
									<td class='text-center'><a class='bx bx-trash bx-sm'
										href="${deleteSpecialty}"></a></td>
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
						CITA</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action='addAppointment' method="post">
						<div class='mb-3'>
							<label class="form-label">Doctor</label>
							<select class="form-select" onchange="mostrarHorario('${doctor.names}')">
								<option selected>Seleccione un doctor</option>
								<c:forEach items="${doctorList}" var="doctor" >
									<option value="${doctor.cmp}">${doctor.cmp} - ${doctor.lastnames}, ${doctor.names}</option>
								</c:forEach>
							</select>
						</div>
						<div class='mb-3'>
							<label class="form-label">Paciente</label>
							<select class="form-select">
								<option selected>Seleccione un paciente</option>
								<c:forEach items="${patientList}" var="patient" >
									<option value="${patient.id}" >${patient.dni} - ${patient.lastnames}, ${patient.names}</option>
								</c:forEach>
							</select>
						</div>
						<div class='mb-3'>
							<label class='form-label'>Seleccione una fecha</label> <input
								type="date" name="date" class='form-control' required>
						</div>
						<div class='mb-3'>
							<label class='form-label'>Seleccione una hora</label> <input
								type="time" name="time" class='form-control' required>
						</div>
						
						<br>
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

	<script type="text/javascript"
	src="<c:url value="/resources/js/mostrar.js"/>"></script>
	<script src='<c:url value="/resources/js/bootstrap.bundle.min.js" />'></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value = "/resources/js/datatables-simple-demo.js"/>"></script>
</body>
</html>