/*
 * Vérifie si les champs remplis par l'utilisateur ne sont pas vides.
 *TODO faire les vérificatons plus précises
 */
function bindForm() {
	$(".error-message").hide();
	$("#form").submit(function(event) {
		if (verif()) {
			return;
		} else {
			event.preventDefault();
		}
	});
}

function verif() {
	var passe = true;
	var id = document.getElementById("id").value;
	if (id == "" || (id < 1 && id > 99999999999)) {
		$("#num")
				.find(".error-message")
				.fadeIn('slow')
				.text(
						"Entrer un identifiant (nombre compris entre 1 et 99999999999.");
		passe = false;
	} else {
		$("#num").find(".error-message").hide();
	}
	if (document.getElementById("libelle").value == "") {
		$("#lib").find(".error-message").fadeIn('slow').text(
				"Entrer un libelle.");
		passe = false;
	} else {
		$("#lib").find(".error-message").hide();
	}
	if (document.getElementById("nbplaces").value == ""
			|| document.getElementById("nbplaces").value < 1) {
		$("#np").find(".error-message").fadeIn('slow').text(
				"Veuillez choisir un nombre de place superieur a 0 !");
		passe = false;
	} else {
		$("#np").find(".error-message").hide();
	}
	if (document.getElementById("nbinscrits").value == ""
			|| document.getElementById("nbinscrits").value < 1) {
		$("#ni").find(".error-message").fadeIn('slow').text(
				"Veuillez choisir un nombre d'inscrits superieur a 0 !");
		passe = false;
	} else {
		$("#ni").find(".error-message").hide();
	}
	var dd = document.getElementById("datedebut").value;
	if (dd == "" || !isValidDate(dd)) {
		$("#dd")
				.find(".error-message")
				.fadeIn('slow')
				.text(
						"La date de début n\'est pas valide ! Elle doit etre au format jj/mm/aaaa.");
		passe = false;
	} else {
		$("#dd").find(".error-message").hide();
	}
	var df = document.getElementById("datefin").value;
	if (df == "" || !isValidDate(df)) {
		$("#df")
				.find(".error-message")
				.fadeIn('slow')
				.text(
						"La date de fin n\'est pas valide ! Elle doit etre au format jj/mm/aaaa.");
		passe = false;
	} else {
		$("#df").find(".error-message").hide();
	}

	return passe;
}

function isValidDate(date) {
	if (date == "aaaa/mm/jj")
		return false;
	else
		return true;
	// var matches = /^\d{4}-\d{2}-\d{2}$/.exec(date);
	// return matches == null;

}

function Chargement() {
	var obj = document.getElementById("id_erreur");
	if (obj.value != '')
		alert('Erreur signalée  : "' + obj.value + "'");
}