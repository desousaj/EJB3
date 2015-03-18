<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@page import="java.util.Date,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Affichage de tous les stages</title>
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
								Listing&nbsp;des Stages
							</h3>
						</div>
					</div>
					<div class="row clearfix">
						<div class="col-md-12 column">
							<table data-height="299" data-click-to-select="true" class="table table-hover">
							    <thead>
							        <tr>
							            <th data-field="numero" data-checkbox="true" width="10%">Numero</th>
							            <th data-field="libelle" data-align="right">Libellé</th>
							            <th data-field="datededebut" data-align="center" width="15%">Date début</th>
							            <th data-field="datedefin" data-align="" width="15%">Date fin</th>
							            <th data-field="nombredeplaces" data-align="" width="10%">Nombre de places</th>
							            <th data-field="nombredinscrits" data-align="" width="10%">Nombre d'inscrits</th>
							            <th data-field="editer" data-align="" width="10%">Editer</th>							            
							            <th data-field="supprimer" data-align="" width="10%">Supprimer</th>
							        </tr>
							    </thead>
							 
							<tbody class=".table-hover">
							<c:forEach  items="${liste}"  var="item" >
							 <tr>
							    <td>${item.id}</td>
							    <td>${item.libelle}</td>
							      <td>
							      <fmt:formatDate type="both" dateStyle="short"
							          timeStyle="short" value="${item.datedebut}" pattern="dd/MM/yyyy"/>
							      </td>
							       <td>
							       <fmt:formatDate type="both" dateStyle="short"
							          timeStyle="short" value="${item.datefin}" pattern="dd/MM/yyyy" />
							      </td>
							       
							      <td>${item.nbplaces}</td>
								  <td>${item.nbinscrits}</td>
								  <td>
								  	<form method="post" action="Controleur" onsubmit="">
										<input type="hidden" name="id" value="${item.id}"  id="id"/>
			  							<input type="hidden" name="action" value="aficherModifierStage" />
									  	<button class="btn btn-default">Editer</button>
									  </form>
								  </td>
								  <td>
									  <form method="post" action="Controleur" onsubmit="">
										<input type="hidden" name="id" value="${item.id}"  id="id"/>
			  							<input type="hidden" name="action" value="supprimerStage" />
									  	<button class="btn btn-default">Supprimer</button>
									  </form>
								  </td>							     
							  </tr>
							 </c:forEach>
							 </tbody> 
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>			
		</body>
	</html>
