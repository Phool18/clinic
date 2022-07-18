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

			<em class="bx bx-chevron-right toogle"></em>
		</header>
		<div class="menu-bar">
			<div class="menu">
				<ul class="menu-links">
					<li class="nav-link"><a href="/sistema/home">
							<em class='bx bx-home-alt icon'></em> <span class="text nav-text">Home</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/appointments"> <em
							class='bx bx-food-menu icon'></em> <span class="text nav-text">Citas</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/patients" > <em
							class='bx bx-user icon'></em> <span class="text nav-text">Pacientes</span>
					</a></li>

					<li class="nav-link"><a href="/sistema/doctors" class="select"> <em
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
		<div class="container">
			<h4>DOCTORES</h4>
			<hr>
			<button class="btn btn-success mb-4" data-bs-toggle="modal"
				data-bs-target="#exampleModal">Agregar</button>
			<div class="card mb-4">
				<div class="card-body">
					<table id="datatablesSimple" class="text-center">
						<caption>Registro de Doctores</caption>
						<thead>
							<tr>
                                <th scope="col" class="text-center">CMP</th>
                                <th scope="col" class="text-center">Nombres</th>
                                <th scope="col" class="text-center">Especialidad</th>
                                <th scope="col" class="text-center">Estado</th>
                                <th scope="col" class="text-center">Acciones</th>
                            </tr>
						</thead>
						<tbody>
							<c:forEach items="${doctorList}" var="doctor">
								<tr>
									<td class='text-center'>${doctor.cmp}</td>
									<td class='text-center'>${doctor.lastnames}<span> ${doctor.names}</span></td>
									<td class='text-center'>${doctor.specialty.type}</td>
									<td class='text-center'>${doctor.status}</td>
									<td class='text-center'></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" aria-labelledby="exampleModalLabel" aria-hidden="true" style="overflow:hidden;">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">REGISTRAR NUEVO DOCTOR</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form:form action='addDoctor' method="post">
						
						<div class='mb-3'>
							<input type="number" name='cmp'
							placeholder='CMP' class='form-control'
							required>
						</div>
						<div class='mb-3'>
							<input type="text" name='names'
							placeholder='Nombres' class='form-control'
							required>
						</div>
						<div class='mb-3'>
							<input type="text" name='lastnames'
							placeholder='Apellidos' class='form-control'
							required>
						</div>
						<div class='mb-3'>
							<input type="text" name='phone'
							placeholder='Telefono' class='form-control'
							required>
						</div>
						<div class='mb-3'>
							<label class="form-label">Seleccione una especialidad</label>
							<select class="js-example-basic-single js-states form-control" style="width: 100%;"  name="specialty">
  								<c:forEach items="${specialtyList}" var='specialty'>
  									<option value="${specialty.id}">${specialty.type}</option>
  								</c:forEach>
							</select>
						</div>
						<span>Cuenta</span>
						<hr>
						<div class='mb-3'>
							<input type="email" name='email'
							placeholder='Correo electronico' class='form-control'
							required>
						</div>
						<div class='mb-3'>
							<input type="password" name='password'
							placeholder='Contrasena' class='form-control'
							required>
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
	
	
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
	<script src="<c:url value = "/resources/js/datatables-simple-demo.js"/>"></script>
	<script src='<c:url value="/resources/js/script.js" />'></script>
	
</body>
</html>