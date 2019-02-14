package visitor;

public class KartonVisitorAddieren implements IVisitor{

	private int summe;
	
	
	@Override
	public void visitTextKarton(TextKarton k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitZahlKarton(ZahlKarton k) {
		summe+=k.getZahl();
		
	}

	@Override
	public void visitContainerKarton(ContainerKarton k) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public int getSumme()
	{
		return summe;
	}

}
