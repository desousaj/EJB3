package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utils {
	// le format est une combinaison de MM dd yyyy avec / ou �
	// exemple dd/MM/yyyy
	public static Date conversionChaineenDate(String unedate, String unformat)
			throws Exception {
		Date datesortie;
		// on d�finit un format de sortie
		SimpleDateFormat defFormat = new SimpleDateFormat(unformat);
		datesortie = defFormat.parse(unedate);
		return datesortie;
	}
}
