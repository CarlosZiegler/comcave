package versionskontrolle;
/*
 * 	Versionskontrollsysteme/Versionskontrolle:
 * 
 * 		- Wof�r VKS?
 * 
 * 			- Konfliktfreie Bearbeitung/Entwicklung von Dokumenten(Quellcode, Buch, Dokumentation...)
 * 
 * 			- Zugriff auf eine komplette Entwicklungshistorie mit allen Versionen
 * 
 * 			- Nachvollziehbarkeit "Wer hat was gemacht?"
 * 
 * 				 
 * 		-> Grundbegriffe:
 * 
 * 			- Repository/Repo  -> Speicherort f�r die Versionshistorie
 * 
 * 			- Branch -> Entwicklungszweig(Aneinanderkettung von Versionsst�nden)
 * 
 * 			- Remote Repository(Remote) -> Speicherort f�r die Versionshistorie, welche nicht lokal ist
 * 
 * 			- Merge -> Das Verschmelzen/Zusammenf�hren mehrerer Entwicklungsst�nde zu einem
 * 				-> Hier m�ssen oft auch Konflikte zwischen Versionsst�nden aufgel�st werden
 * 
 * 			- Commit -> Einspielen einer Version in die Versionshistorie/Repository(lokal/remote)
 * 
 * 
 * 		-> Einf�hrung in das VKS git:
 * 
 * 			- Dezentralisiertes VKS, welches open source ist
 * 
 * 			- Es gibt auf dem Markt sehr viele git-Clients
 * 
 * 
 * 			-> Arbeiten mit git:
 * 
 * 				1. git installieren / git-Client installieren
 * 				2. Lokales Repo anlegen bzw. ein Remote-Repo clonen
 * 				3. Dateien, welche versioniert werden sollen, zum Index/Stage hinzuf�gen
 * 				4. Nach bestimmten �nderungen werden die Dateist�nde aus dem Index per COMMIT ins
 * 				   Repository gespeichert
 * 
 * 
 * 			-> Git arbeitet grunds�tzlich mit 3 Bereichen:
 * 
 * 					1. Working directory
 * 					2. Index/Stage
 * 					3. Repository
 * 
 * 
 * 			-> Merge:
 * 
 * 				-> F�hrt mehrere Versionsst�nde unterschiedlicher Branches zu einem zusammen
 * 
 * 				-> Beispiel: Der Branch "db" soll IN den "master"-Branch einfliessen
 * 
 * 						1. git checkout master
 * 						2. git merge db
 * 
 * 					-> Nach so einem Merge m�ssen die Hashwerte der HEADS beider Zweige identisch sein!
 * 					-> Hierbei kann es zu Konflikten kommen: Dann wird git den Merge ablehnen und 
 * 					   Fehlermedlung werfen -> Die Entwickler m�ssen dann selbst den Konflikt bereinigen 
 * 					   und den Merge erneut versuchen durchzuf�hren
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Main {

	private int wert;
	
	public static void main(String[] args) {
		

	}

}
