<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date,java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Gestion des stages</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
  		<meta name="description" content="">
  		<meta name="author" content="">
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		
		<link href="css/bootstrap.min.css" rel="stylesheet">
		

		<link rel="shortcut icon" href="images/favicon.png">
		 
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>	
		<script type="text/javascript" src="js/js_verification.js"></script>
	</head>



	<body>
	<c:if test="${not empty MesSucces}">	
		<div class="alert alert-success alert-dismissible" role="alert">
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		  <strong>Succès !</strong> ${MesSucces}
		</div>
	</c:if>
	
	<c:if test="${not empty MesErreurs}">
		<div class="alert alert-danger alert-dismissible" role="alert">
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		  <strong>Erreur !</strong> ${MesErreurs}
		</div>
	</c:if>
	
	<div class="container">
	<div class="row clearfix">
				<div class="col-md-12 column">
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>Menu</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<li>
									<a class="gn-icon gn-icon-stage">Stage</a>
									<ul class="gn-submenu">									
										<li><a class="gn-icon gn-icon-add">Ajouter un stage</a></li>
										<li><a class="gn-icon gn-icon-list">Afficher les stages</a></li>
										<li><a class="gn-icon gn-icon-search">Chercher un stage</a></li>
									</ul>
								</li>
								<li>
									<a class="gn-icon gn-icon-stagiaire">Stagiaires</a>
									<ul class="gn-submenu">
										<li><a class="gn-icon gn-icon-person">Ajouter un stagiaire</a></li>
										<li><a class="gn-icon gn-icon-list">Afficher les stagiaires</a></li>
									</ul>
								</li>
							</ul>
						</div><!-- /gn-scroller -->
					</nav>
				</li>
				<li id="polytech"><a href="http://polytech.univ-lyon1.fr/">Polytech</a></li>
			</ul>
			</div>
			</div>

			
	
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-12 column">
							<h3 class="text-center">
								Gestion des Stages
							</h3>
						</div>
					</div>
					<div class="row clearfix">
						<div class="col-md-12 column">
							<p>
								Nous sommes le <%= DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL).format(new Date()) %>
							</p>
						</div>
					</div>
					<div class="row clearfix">
						<div class="col-md-12 column">
							<div class="panel-group" id="panel-934093">
								<div class="panel panel-default">
									<div class="panel-heading">
										 <a class="panel-title" data-toggle="collapse" data-parent="#panel-934093" href="#panel-element-771486">Gestion des stages</a>
									</div>
									<div id="panel-element-771486" class="panel-collapse collapse in">
										<div class="panel-body">
											<a href="Controleur?action=saisieStage">Saisie d'un stage</a>
										</div>
										<div class="panel-body">
											<a href="Controleur?action=afficheStage">Affichage liste des stages</a>
										</div>
										<div class="panel-body">
											<a href="Controleur?action=rechercherStages">Recherche d'un stage</a>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										 <a class="panel-title" data-toggle="collapse" data-parent="#panel-934093" href="#panel-element-120256">Gestion des stagiaires</a>
									</div>
									<div id="panel-element-120256" class="panel-collapse collapse">										
										<div class="panel-body">
											<a href="Controleur?action=rechercheStage">Création d'un stagiaire</a>
										</div>
										<div class="panel-body">
											<a href="Controleur?action=afficheStagiaire">Afficher les stagiaires</a>
										</div>
										<div class="panel-body">
											<a href="Controleur?action=rechercheStage">Rechercher un stagiaire</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script src="js/classie.js"></script>
		<script src="js/gnmenu.js"></script>
		<script>
			new gnMenu( document.getElementById( 'gn-menu' ) );
		</script>
	</body>
</html>
