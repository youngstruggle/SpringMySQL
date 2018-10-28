<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
</head>
<body>
	<h2>Bank Account Details</h2>
	
    <p><spring:message code="lbl.accountNo" /> : ${account.accountNo}</p>
	<p><spring:message code="lbl.accountHolderName" /> : ${account.accountHolderName}</p>
	<p><spring:message code="lbl.balance" /> : ${account.balance}</p>
	<p><spring:message code="lbl.accountType" /> : ${account.balance}</p>  
	<p><spring:message code="lbl.dob" /> : ${account.dateOfBirth}</p> 
	<p><spring:message code="lbl.psCode" /> : ${account.psCode}</p> 
	
</body>
</html>