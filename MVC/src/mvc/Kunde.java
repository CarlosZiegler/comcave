package mvc;


public class Kunde 
{
   
    private int id;
    private String name;
    private String beruf;
    private String vorname;
    private int kundennummer;
    public Kunde(int id, String name, String beruf, String vorname,
	    int kundennummer) {
		super();
		this.id = id;
		this.name = name;
		this.beruf = beruf;
		this.vorname = vorname;
		this.kundennummer = kundennummer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBeruf() {
        return beruf;
    }
    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public int getKundennummer() {
        return kundennummer;
    }
    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }
    
    
    
}
