<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
</head>
<body>

	<div class="container">
		<%@ include file="header.jsp"%>

		<div class="row">
			<div class="col-12">
				<c:url value="/logout" var="logoutUrl" />

				<form action="${logoutUrl}" method="post" id="LogoutForm">
					<input type="hidden" name="${csrf.parameterName}"
						value="${_csrf.token}" />
				</form>

				<script type="text/javascript">
					function formSubmit() {
						document.getElementById("LogoutForm").submit();
					}
				</script>

				<p class="display-5">
					Welcome : ${username}, <a href="javascript:formSubmit()">
						Logout </a>
				</p>

			</div>
		</div>

		<div class="row">
			<div class="col-12">
				<a href="<c:url value='/new'/>" class="btn btn-primary"> Add New
					Account</a>
			</div>
		</div>

		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th><spring:message code="lbl.accountNo" /></th>
							<th><spring:message code="lbl.accountHolderName" /></th>
							<th><spring:message code="lbl.balance" /></th>
							<th><spring:message code="lbl.accountType" /></th>
							<th><spring:message code="lbl.psCode" /></th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="account" items="${accounts}">
							<c:url var="updateLink" value="/edit">
								<c:param name="accountNo" value="${account.accountNo}" />
							</c:url>
							<c:url var="deleteLink" value="/delete">
								<c:param name="accountNo" value="${account.accountNo}" />
							</c:url>
							<tr>
								<td>${account.accountNo}</td>
								<td>${account.accountHolderName}</td>
								<td>${account.balance}</td>
								<td>${account.accountType}</td>
								<td>${account.psCode}</td>
								<td><a href="${updateLink}" class="btn btn-warning">Edit</a></td>
								<td><a href="${deleteLink}" class="btn btn-danger"
									onclick="if(!(confirm('Are you sure to delete'))) return false">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>