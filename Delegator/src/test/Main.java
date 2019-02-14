package test;
/*
 * 	Das Entwurfsmuster Delegator:
 * 
 * 	-> Das Problem:
 * 
 * 		-> Unterschiedlichen Klassen aus völlig unabhängigen Vererbungsstrukturen sollen Dienste zur Verfügung gestellt werden, 
 * 			allerdings auf eine Art und Weise, in welcher die aufgerufenen Dienste wiederum Methoden in den Clients aufrufen 
 * 			 können!
 
 * ***************************************************
 * 
 * 		-> Kohäsion und Kopplung(Paradigmen) -> cohesion and coupling:
 * 
 * 			-> Kohäsion ist ein qualitatives Maß für den inneren Zusammenhalt/Zusammenhang eines Moduls, einer Klasse, einer Methode...
 * 
 * 				-> Wenn in einer Klasse, einer Methode, einem Package NUR Code steht, welcher von der Idee her auch wirklich dort 
 * 				   hineingehört, dann haben wir HOHE KOHÄSION
 * 
 * 
 * 				-> Ziel eines Entwicklers ist immer hohe Kohäsion!
 * 
 * 
 * 				-> Wenn geringe Kohäsion gefahren wird, leidet vor allem die Anpassbarkeit, Testbarkeit und Erweiterbarkeit der Software!
 * 
 * 
 * 
 * 			-> Kopplung ist ein qualitatives Maß für die Aufrufabhängigkeit unter Modulen, Klassen, Methoden....
 * 
 * 				-> Je mehr Aufrufe nötig sind, um ein Teilproblem zu lösen, umso höher ist die Kopplung
 * 
 * 				-> Ziel ist immer möglichst geringe/niedrige Kopplung!
 * 
 * 				-> Zu hohe Kopplung führt zu schwer nachvollziehbarem und schwer testbarem Code!
 * 	
 * 
 * 			-> Kohäsion und Kopplung bedingen sich gegenseitig:
 * 
 * 				-> Je höher die Kohäsion, umso höher die Kopplung
 * 
 * 
 * 			-> Konsequenz: Ein möglichst ausgeglichenes Verhältnis von möglichst hoher Kohäsion bei gleichzeitig möglichst 
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
