<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Ajout d'un stages</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
  		<meta name="description" content="">
  		<meta name="author" content="">
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/jquery-ui.min.css" />
		<link href="css/bootstrap.min.css" rel="stylesheet">
		

		<link rel="shortcut icon" href="images/favicon.png">
		 
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>	
		<script type="text/javascript" src="js/js_verification.js"></script>
		
		<!-- TODO mettre dans js  -->
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>

	</head>


<body  onLoad="Chargement();">
<!--  TODO : faire un menu-->
<P><A href="index.jsp"><FONT face="Arial" color="#004080">Retour Accueil</FONT></A></P>

<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-12 column">
							<h3 class="text-center">
								Formulaire d'ajout d'un stage
							</h3>
						</div>
					</div>
					<div class="row clearfix">
						<div class="col-md-12 column">
							<input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
							<form id="form" method="post" action="Controleur">
							<input type="hidden" name="type" value="ajout"  id="type"/>
  							<input type="hidden" name="action" value="ajoutStage" />
								<div class="form-group" id="num">
									<label for="id">Numéro</label><input class="form-control" type="text" name="id" value="${stage.id}" id="id" />									 
									<span class="error-message"></span>
								</div>
								<div class="form-group" id="lib">
									 <label for="libelle">Libellé</label><input class="form-control" type="text" name="libelle" value="${stage.libelle}" id="libelle" />
									 <span class="error-message"></span>
								</div>
								<div class="form-group" id="dd">
									 <label for="datedebut">Date de début du stage</label><input class="form-control" type="Date" pattern="dd/MM/yyyy" name="datedebut" value="${stage.datedebut}" id="datedebut" />
									 <span class="error-message"></span>
								</div>
								<div class="form-group" id="df">
									 <label for="datefin">Date de fin de stage</label><input class="form-control" type="Date" pattern="dd/MM/yyyy" name="datefin" value="${stage.datefin}" id="datefin" />
									 <span class="error-message"></span>
								</div>
								<div class="form-group" id="np">
									 <label for="nbplaces">Nombre de places</label><input class="form-control" type="text" name="nbplaces" value="${stage.nbplaces}" id="nbplaces" />
									 <span class="error-message"></span>
								</div>
								<div class="form-group" id="ni">
									 <label for="nbinscrits">Nombre d'inscrits</label><input class="form-control" type="text" name="nbinscrits" value="${stage.nbinscrits}" id="nbinscrits" />
									 <span class="error-message"></span>
								</div>								
								<button type="submit" class="btn btn-default" name="ajouter" value="Ajouter">Ajouter</button>
								<button type="reset" class="btn btn-default" name="reset" value="Reset">Reset</button>							
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>		
	</body>
	
	<script>
		bindForm();
  	</script>
</html>
