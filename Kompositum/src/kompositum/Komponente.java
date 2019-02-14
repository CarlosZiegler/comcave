package kompositum;

public abstract class Komponente 
{
	//attribute
	private String name;
	private Komponente parent;
	
	//konstruktor
	public Komponente(String name)
	{
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Komponente getParent() {
		return parent;
	}

	public void setParent(Komponente parent) {
		this.parent = parent;
	}
	
	
	
	
	
	
	
}
