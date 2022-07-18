<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="<c:url value ="/resources/img/icon.png"/>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Medical Center - Login</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
</head>
<body class='bg-login'>

	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class='col-10'>
				<div class='row justify-content-center'>
					<div class='col-md-4'>
						<div class='card card-login'>
							<div class='card-body'>
								<h5 class='text-center mb-3'>Iniciar Sesión</h5>
								<form:form action='loginProcess' method="post"
									modelAttribute="userLogin">
									<div class='mb-3'>
										<input type="email" name='email'
											placeholder='Correo electrónico' class='form-control'
											required>
									</div>
									<div class='mb-3'>
										<input type="password" name='password'
											placeholder='Contraseña' class='form-control' required>
									</div>
									<button type="submit" class='btn btn-primary w-100'>Ingresar</button>
								</form:form>
								<c:if test="${error!=null}">
									<div class="alert alert-danger text-center alerta-error"
										role="alert">
										<span class='fs-6'>${error}</span>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>