package visitor;

//die schnittstelle bietet zu jedem typ des kompositums eine korrespondierende methode an, welche sich im visitor befindet und
//beim durchlaufen der kompositumstruktur aufgerufen werden k�nnen
// -> diese besucher-methoden haben immer das pr�fix "visit"
public interface IVisitor 
{

	void visitTextKarton(TextKarton k);
	void visitZahlKarton(ZahlKarton k);
	void visitContainerKarton(ContainerKarton k);
	
	
	
}
