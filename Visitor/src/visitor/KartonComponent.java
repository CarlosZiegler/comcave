package visitor;

public abstract class KartonComponent 
{
	private KartonComponent parent;
	private String name;
	
	public KartonComponent(String name)
	{
		this.name=name;
	}

	public KartonComponent getParent() {
		return parent;
	}

	public void setParent(KartonComponent parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void accept(IVisitor v);
	
	
}
