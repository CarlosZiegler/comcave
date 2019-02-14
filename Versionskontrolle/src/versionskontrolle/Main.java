package versionskontrolle;
/*
 * 	Versionskontrollsysteme/Versionskontrolle:
 * 
 * 		- Wofür VKS?
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
 * 			- Repository/Repo  -> Speicherort für die Versionshistorie
 * 
 * 			- Branch -> Entwicklungszweig(Aneinanderkettung von Versionsständen)
 * 
 * 			- Remote Repository(Remote) -> Speicherort für die Versionshistorie, welche nicht lokal ist
 * 
 * 			- Merge -> Das Verschmelzen/Zusammenführen mehrerer Entwicklungsstände zu einem
 * 				-> Hier müssen oft auch Konflikte zwischen Versionsständen aufgelöst werden
 * 
 * 			- Commit -> Einspielen einer Version in die Versionshistorie/Repository(lokal/remote)
 * 
 * 
 * 		-> Einführung in das VKS git:
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
 * 				3. Dateien, welche versioniert werden sollen, zum Index/Stage hinzufügen
 * 				4. Nach bestimmten Änderungen werden die Dateistände aus dem Index per COMMIT ins
 * 				   Repository gespeichert
 * 
 * 
 * 			-> Git arbeitet grundsätzlich mit 3 Bereichen:
 * 
 * 					1. Working directory
 * 					2. Index/Stage
 * 					3. Repository
 * 
 * 
 * 			-> Merge:
 * 
 * 				-> Führt mehrere Versionsstände unterschiedlicher Branches zu einem zusammen
 * 
 * 				-> Beispiel: Der Branch "db" soll IN den "master"-Branch einfliessen
 * 
 * 						1. git checkout master
 * 						2. git merge db
 * 
 * 					-> Nach so einem Merge müssen die Hashwerte der HEADS beider Zweige identisch sein!
 * 					-> Hierbei kann es zu Konflikten kommen: Dann wird git den Merge ablehnen und 
 * 					   Fehlermedlung werfen -> Die Entwickler müssen dann selbst den Konflikt bereinigen 
 * 					   und den Merge erneut versuchen durchzuführen
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
