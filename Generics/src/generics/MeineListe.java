package generics;
import java.util.*;
/*
 *  Begriffe: 
 *  
 *  Anweisung class MeineListe<E>
 *  
 *  	-> MeineListe -> Rohtyp
 *  	-> <E> -> Typvariable
 *  	-> MeineListe<E> -> Generischer Typ(generic type)
 * 
 * 
 * 
 */

public class MeineListe<E> implements Iterable<E>
{
	private LinkedList<E> elemente;
	
	public MeineListe()
	{
		elemente=new LinkedList<E>();
	}
	
	public void addElement(E elem)
	{
		elemente.add(elem);
	}
	
	public E getElementAt(int index)
	{
		return elemente.get(index);
	}

	@Override
	public Iterator<E> iterator() 
	{
		return elemente.iterator();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
