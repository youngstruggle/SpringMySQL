<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
</head>
<body>

	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="jumbotron">
					<h1 class="display-4">Welcome Bank Apps</h1>
					<p class="Lead">Happiness = A Good Bank Account, A good Cook
						and Good digestion - Jean</p>
					<a href="user/new" class="btn btn-lg btn-success">Register Here</a>
					<p>
						<br /> Existing Users: <a href="/user/login">Login Here</a>
					</p>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col-3">
				<div class="card" style="height: 200px">
					<div class="card-header">Online</div>
					<img alt="Online"
						src="<spring:url value='/resource/images/stay-online.png'/>"
						class="card-img-top">
					<div class="card-body">
						<p class="card-text">200+ Transaction via Net Banking</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="card" style="height: 200px">
					<div class="card-header">Phone</div>
					<img alt="Phone"
						src="<spring:url value='/resource/images/stay-phone.png'/>"
						class="card-img-top">
					<div class="card-body">
						<p class="card-text">25+ Transaction via Net Banking</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="card" style="height: 200px">
					<div class="card-header">Social Media</div>
					<img alt="Social Media"
						src="<spring:url value='/resource/images/stay-social.png'/>"
						class="card-img-top">
					<div class="card-body">
						<p class="card-text">Social Media Chatting</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="card" style="height: 200px">
					<div class="card" style="height: 200px">
						<div class="card-header">Watch</div>
						<img alt="Social Media"
							src="<spring:url value='/resource/images/stay-watch.png'/>"
							class="card-img-top">
						<div class="card-body">
							<p class="card-text">Ranking at the flick</p>
						</div>
					</div>

				</div>
			</div>

		</div>

		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>