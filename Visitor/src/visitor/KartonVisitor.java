package visitor;

public class KartonVisitor implements IVisitor{

	@Override
	public void visitTextKarton(TextKarton k) {
		
		System.out.println("TextKarton " + k.getName() + " mit dem Text " + k.getText() + " im Parent: " + k.getParent().getName());
	}

	@Override
	public void visitZahlKarton(ZahlKarton k) {
		
		System.out.println("ZahlKarton " + k.getName() + " mit der Zahl " + k.getZahl() + " im Parent: " + k.getParent().getName());
	}

	@Override
	public void visitContainerKarton(ContainerKarton k) {
		
		
	}

}
