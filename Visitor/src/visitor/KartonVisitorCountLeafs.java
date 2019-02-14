package visitor;

public class KartonVisitorCountLeafs implements IVisitor{

	
	private int anzLeafs;
	
	@Override
	public void visitTextKarton(TextKarton k) {
		anzLeafs++;
		
	}

	@Override
	public void visitZahlKarton(ZahlKarton k) {
		anzLeafs++;
		
	}

	@Override
	public void visitContainerKarton(ContainerKarton k) {
		// TODO Auto-generated method stub
		
	}
	
	public int getAnzLeafs()
	{
		return anzLeafs;
	}
	
	

}
