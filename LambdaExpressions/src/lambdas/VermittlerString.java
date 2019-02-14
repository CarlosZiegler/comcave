package lambdas;
import java.util.function.*;


public interface VermittlerString 
{
	VermittlerString transform(UnaryOperator<String> op);
	String toString();
	
	
}
