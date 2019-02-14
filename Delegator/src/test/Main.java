package test;
/*
 * 	Das Entwurfsmuster Delegator:
 * 
 * 	-> Das Problem:
 * 
 * 		-> Unterschiedlichen Klassen aus v�llig unabh�ngigen Vererbungsstrukturen sollen Dienste zur Verf�gung gestellt werden, 
 * 			allerdings auf eine Art und Weise, in welcher die aufgerufenen Dienste wiederum Methoden in den Clients aufrufen 
 * 			 k�nnen!
 
 * ***************************************************
 * 
 * 		-> Koh�sion und Kopplung(Paradigmen) -> cohesion and coupling:
 * 
 * 			-> Koh�sion ist ein qualitatives Ma� f�r den inneren Zusammenhalt/Zusammenhang eines Moduls, einer Klasse, einer Methode...
 * 
 * 				-> Wenn in einer Klasse, einer Methode, einem Package NUR Code steht, welcher von der Idee her auch wirklich dort 
 * 				   hineingeh�rt, dann haben wir HOHE KOH�SION
 * 
 * 
 * 				-> Ziel eines Entwicklers ist immer hohe Koh�sion!
 * 
 * 
 * 				-> Wenn geringe Koh�sion gefahren wird, leidet vor allem die Anpassbarkeit, Testbarkeit und Erweiterbarkeit der Software!
 * 
 * 
 * 
 * 			-> Kopplung ist ein qualitatives Ma� f�r die Aufrufabh�ngigkeit unter Modulen, Klassen, Methoden....
 * 
 * 				-> Je mehr Aufrufe n�tig sind, um ein Teilproblem zu l�sen, umso h�her ist die Kopplung
 * 
 * 				-> Ziel ist immer m�glichst geringe/niedrige Kopplung!
 * 
 * 				-> Zu hohe Kopplung f�hrt zu schwer nachvollziehbarem und schwer testbarem Code!
 * 	
 * 
 * 			-> Koh�sion und Kopplung bedingen sich gegenseitig:
 * 
 * 				-> Je h�her die Koh�sion, umso h�her die Kopplung
 * 
 * 
 * 			-> Konsequenz: Ein m�glichst ausgeglichenes Verh�ltnis von m�glichst hoher Koh�sion bei gleichzeitig m�glichst 
 * 						   niedriger Kopplung!
 * 
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
