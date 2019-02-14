package lambdas;
import java.util.function.*;

public class EingabeTransformer 
{

	public static String transform(String zeichenkette, UnaryOperator<String> t)
	{
		return t.apply(zeichenkette);
	}
	
	
	public static <T> UnaryOperator<T> compose(UnaryOperator<T>...operatoren)
	{
		return k ->
		{
			T ergebnis=k;
			for(UnaryOperator<T> ops : operatoren)
			{
				ergebnis=ops.apply(ergebnis);
				
			}
			return ergebnis;
		};
	}
	
	
	
	
}
