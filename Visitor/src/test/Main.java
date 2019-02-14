package test;
import visitor.*;
public class Main {

	public static void main(String[] args) {
		
		//kompositum zusammenbauen:
		ContainerKarton root=new ContainerKarton("root");
		ContainerKarton kiste=new ContainerKarton("kiste");
		ContainerKarton behaelter=new ContainerKarton("behälter");
		
		//kiste und behälter befinden sich beide in root:
		root.add(kiste);
		root.add(behaelter);
		
		//in kiste befindet sich ein textkarton
		TextKarton texti=new TextKarton("texti");
		texti.setText("TEXT");
		kiste.add(texti);
		
		//in behaelter befindet sich ein zahlkarton
		ZahlKarton zahli=new ZahlKarton("zahli");
		zahli.setZahl(13);
		behaelter.add(zahli);
		
		
		//*************************************************************
		// durchlaufen mit kartonvisitor
		KartonVisitor kv=new KartonVisitor();
		root.accept(kv);
		
		//anderer visitor:
		KartonVisitorCountLeafs zaehler=new KartonVisitorCountLeafs();
		root.accept(zaehler);
		System.out.println("Anzahl Leafs: " + zaehler.getAnzLeafs());
		
		

	}

}
