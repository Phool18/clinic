<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Medical Center - Doctores</title>
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
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
<script type="text/javascript"
	src="<c:url value="/resources/js/sweetalert2.min.js" />"></script>
<script src='<c:url value="/resources/js/alert_message.js" />'></script>
<script src='<c:url value="/resources/js/jquery-3.6.0.min.js" />'></script>
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	    $('.js-example-basic-single').select2({
	    	dropdownParent: $('#exampleModal')
	    });
	});
	</script>
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

			<i class="bx bx-chevron-right toogle"></i>
		</header>
		<div class="menu-bar">
			<div class="menu">
				<ul class="menu-links">
					<li class="nav-link"><a href="/clinic/home">
							<em class='bx bx-home-alt icon'></em> <span class="text nav-text">Home</span>
					</a></li>

					<li class="nav-link"><a href="/clinic/appointments"> <em
							class='bx bx-food-menu icon'></em> <span class="text nav-text">Citas</span>
					</a></li>

					<li class="nav-link"><a href="/clinic/patients"> <em
							class='bx bx-user icon'></em> <span class="text nav-text">Pacientes</span>
					</a></li>

					<li class="nav-link"><a href="/clinic/doctors"> <em
							class='bx bx-user icon'></em> <span class="text nav-text">Doctores</span>
					</a></li>

					<li class="nav-link"><a href="/clinic/schedules" class="select"> <em
							class='bx bx-calendar icon'></em> <span class="text nav-text">Horarios</span>
					</a></li>

					<li class="nav-link"><a href="/clinic/specialtys"> <em
							class='bx bx-pie-chart-alt icon'></em> <span class="text nav-text">Especialidades</span>
					</a></li>

				</ul>
			</div>

			<div class="bottom-content">
				<ul>
					<li class=""><a href="/clinic/logout"> <em class="bx bx-log-out icon"></em>
							<span class="text nav-text">Logout</span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="home">

		<div class='container'>

			<h4>HORARIOS</h4>
			<hr>
			<button class='btn btn-success mb-4' data-bs-toggle="modal"
				data-bs-target="#exampleModal">Agregar</button>
			<br>
			<div class="card mb-4">
				<div class="card-body">
					<table id="datatablesSimple">
						<caption>Registro de Horarios</caption>
						<thead>
							<tr>
								<th class='text-center'>Dia</th>
								<th class='text-center'>Doctor</th>
								<th class='text-center'>Hora de inicio</th>
								<th class='text-center'>Hora de salida</th>
								<th class='text-center'>Estado</th>
								<th class='text-center'>Acciones</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Dia</th>
								<th>Doctor</th>
								<th>Hora de inicio</th>
								<th>Hora de salida</th>
								<th>Estado</th>
								<th>Acciones</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${scheduleList}" var="schedule">
								<tr>
									<td class='text-center'>${schedule.day}</td>
									<td class='text-center'>${schedule.doctor.lastnames},
										${schedule.doctor.names}</td>
									<td class='text-center'>${schedule.start_time}</td>
									<td class='text-center'>${schedule.end_time}</td>
									<td class='text-center'>${schedule.status}</td>
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
					<h5 class="modal-title" id="exampleModalLabel">REGISTRAR NUEVO
						HORARIO</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form:form action='addSchedule' modelAttribute="schedule"
						method="post">
						<div class='mb-3'>
							<label class='form-label'>Seleccione un doctor</label>
							<select class="js-example-basic-single js-states form-control" style="width: 100%;"  name="doctor_cmp">
  								<c:forEach items='${doctorList}' var="doctor">
									<option value="${doctor.cmp}">${doctor.cmp}-
										${doctor.lastnames}, ${doctor.names}</option>
								</c:forEach>
							</select>
						</div>
						<div class='mb-3'>
							<label class='form-label'>Seleccione un dia</label>
							<select name="day" class="form-select" required>
								<option value='Lunes'>Lunes</option>
								<option value='Martes'>Martes</option>
								<option value='Miercoles'>Miercoles</option>
								<option value='Jueves'>Jueves</option>
								<option value='Viernes'>Viernes</option>
								<option value='Sabado'>Sabado</option>
							</select>
						</div>
						<div class='mb-3'>
							<div class='row'>
								<div class='col-6'>
									<label class='form-label'>Ingreso</label> 
								</div>
								<div class='col-6'>
									<label class='form-label'>Salida</label> 
								</div>
								<div class='col-6'>
									<input type="time" name="start_time" class="form-control" required>
								</div>
								<div class='col-6'>
									<input type="time" name="end_time" class="form-control" required>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Guardar</button>
						</div>
					</form:form>
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