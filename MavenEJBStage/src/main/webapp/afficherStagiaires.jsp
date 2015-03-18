<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@page import="java.util.Date,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Affichage de tous les stagiaires</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
  		<meta name="description" content="">
  		<meta name="author" content="">
  		
  		
		<link rel="stylesheet" href="css/style.css" />
		<link href="css/bootstrap.min.css" rel="stylesheet">
		

		<link rel="shortcut icon" href="images/favicon.png">
		 
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>	
		<script type="text/javascript" src="js/js_verification.js"></script>
	</head>
		
		<body>
		<!--  TODO : faire un menu-->
		<P><A href="index.jsp"><FONT face="Arial" color="#004080">Retour Accueil</FONT></A></P>
		
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-12 column">
							<h3 class="text-center">
								Listing&nbsp;des Stagiaires
							</h3>
						</div>
					</div>
					<div class="row clearfix">
						<div class="col-md-12 column">
							<table data-height="299" data-click-to-select="true" class="table">
							    <thead>
							        <tr>
							            <th data-field="numero" data-checkbox="true" width="10%">Numero</th>
							            <th data-field="nom" data-align="right">Nom</th>
							            <th data-field="prenom" data-align="right">Prenom</th>
							            <th data-field="datedenaissance" data-align="center" width="15%">Date de naissance</th>
							            <th data-field="adresse" data-align="" width="10%">Adresse</th>
							            <th data-field="codepostale" data-align="" width="10%">Code postal</th>
							            <th data-field="ville" data-align="" >Ville</th>
							        </tr>
							    </thead>
							 
							<c:forEach  items="${liste}"  var="item" >
							 <tr>
							    <td>${item.num}</td>
							    <td>${item.nom}</td>
							    <td>${item.prenom}</td>
							      <td>
							      <fmt:formatDate type="both" dateStyle="short"
							          timeStyle="short" value="${item.datenaissance}" pattern="dd/MM/yyyy"/>
							      </td>
							       
							     <td>${item.adresse}</td>
								 <td>${item.cpostal}</td>
							     <td>${item.ville}</td>
							  </tr>
							 </c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>			
		</body>
	</html>
