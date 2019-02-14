package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class StringTransformator implements VermittlerString
{

	//alle lambdas auf einer liste halten
	private List<UnaryOperator<String>> ops=new ArrayList<>();
	//ausgangs-string
	private String init;
	
	//Lazyness definiert die Standard-Methode "of" als Init:
	public static StringTransformator of(String s)
	{
		StringTransformator trans=new StringTransformator();
		trans.init=s;
		return trans;
	}
	
	
	
	
	@Override
	public VermittlerString transform(UnaryOperator<String> op) {
		ops.add(op);
		return this;
	}

	@Override
	public String toString()
	{
		String ergebnis=init;
		for(UnaryOperator<String> op : ops)
		{
			ergebnis=op.apply(ergebnis);
		}
		return ergebnis;
	}
	
	
	
}
