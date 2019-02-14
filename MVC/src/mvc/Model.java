package mvc;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;

import com.microsoft.sqlserver.jdbc.SQLServerException;
//hier steht die geschäftslogik
/**
 * 	JDBC:
 * 
 * 		-> API inklusive Treiber als Abstraktion aller geläufigen RDBMS
 * 		-> Bietet eine einheitliche Schnittstelle für den Zugriff und die
 * 		   grundlegendsten Opearationen auf RDB
 * 		-> Basis aller Frameworks in Java, welche auf relationale DB aufsetzen
 * 
 * 	JPA(Java Persistence API):
 * 
 * 		-> Nachfolger der alten JDO
 * 		-> Gilt als Standard-Vereinbarung für alle Frameworks, welche JDBO abstrahieren
 * 		-> Red Hat(JBoss)-> Hibernate, IBM -> OpenJPA, Oracle -> EclipseLink ...
 * 		-> Ein Implementierer dieser Spezifikation nennt man auch JPA-Provider
 * 
 * 
 * 	
 * 	Hibernate(ORM):
 * 
 * 		-> Der wohl verbreitste JPA-Provider
 * 		-> Spezifikation für das Mapping von Objekte auf relationale Datenbanken
 * 		-> Bietet Funktionen für das persistente Speichern von Objekten in RDB
 * 
 * 
 * 
 * 
 *
 */

public class Model 
{
		
	private Controller controller;
    private Connection conn;
    private Statement stm;
    private PreparedStatement prepStm;
    private String sql;
    private ResultSet result;
    private HashMap<Integer, Kunde> hm_kunden=new HashMap<Integer, Kunde>();
    
	public Model(Controller c)
	{
		controller=c;
	}
	
	//verbindung zur DB aufbauen
	public void dbConnect(String dbName)
	{
		//name der db vom user(GUI) geholt
		String db=dbName;
		//treiber laden
		try
		{
		    //diese Methode der Klasse Class lädt ein Klassenobjekt
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(ClassNotFoundException e)
		{
		    controller.vermittleMeldungAnView("Treiberladen fehlgeschlagen!");
		}
		try
		{
		    conn=DriverManager.getConnection("jdbc:sqlserver://localhost:50880;" + 
		    		"databasename=" + db + 
		    		";integratedSecurity=true;");
		    controller.vermittleMeldungAnView("Erfolgreich mit der Datenank \"" + db + "\" verbunden");
		    holeKunden();
		}
		catch(SQLServerException e)
		{
			System.out.println(e.getMessage());
			controller.vermittleMeldungAnView("Fehler beim Verbinden mit dem Server " + db + " " + e.getMessage());
		}
		catch(SQLException e)
		{
		    controller.vermittleMeldungAnView("Fehler beim Verbinden mit der Datenbank " + db + " " + e.getMessage());
		}
		
	  }
	
	private void holeKunden()
    {
		try
		{
		    //abfrage an die tabelle kunde 
		    sql="SELECT * FROM Kunde";
		    //anweisung in sql-string vorkompilieren und speichern
		    prepStm=conn.prepareStatement(sql);
		    //das ergebnis der abfrage in einem resultset-objekt liefern
		    result=prepStm.executeQuery();
		    controller.vermittleMeldungAnView("Kunden erfolgreich geladen");
		    printKundenView();
		    
		}
		catch(SQLException e)
		{
			
		    controller.vermittleMeldungAnView("Fehler beim Laden der Kunden : " + e.getMessage());
		}
	
	
	
    }
	
	private void printKundenView()
	{
		String[] spalten;
		Object[][] daten;
		try
		{
			spalten=new String[result.getMetaData().getColumnCount()];
			daten=new Object[39][result.getMetaData().getColumnCount()];
			for(int i=0;i<spalten.length;i++)
		    {
				//spatennamen laden
				spalten[i]=result.getMetaData().getColumnName(i+1);
		    }
			
			int index=0;
			while(result.next())
			{
				daten[index][0]=result.getInt("PK");
				daten[index][1]=result.getString("Vorname");
				daten[index][2]=result.getString("Name");
				daten[index][3]=result.getString("Beruf");
				daten[index][4]=result.getString("KundeNr");
				index++;
			}
			
			controller.vermittleDatenAnView(spalten, daten);
			
		}
		catch(SQLException e)
		{
			controller.vermittleMeldungAnView("Fehler beim Laden der Datensätze : " + e.getMessage());
		}
		
		
		
	}
	
	
		
}
	
	
	

