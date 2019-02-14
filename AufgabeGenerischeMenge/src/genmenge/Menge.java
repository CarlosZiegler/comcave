package genmenge;

import java.util.HashSet;
import java.util.Iterator;

public class Menge<E> 
{
    private HashSet<Comparable<E>> elemente;
    
    public Menge()
    {
	elemente=new HashSet<Comparable<E>>();
    }
    
    //hinzufügen eines elementes in die menge
    public <T extends Comparable<E>> boolean addElement(T elem)
    {
	return elemente.add(elem);
    }
    
    //diese methode liefert eine kopie der elemente
    public Menge<E> getCloneMenge()
    {
	Menge<E> temp=new Menge<E>();
	HashSet<Comparable<E>> tempSet=(HashSet<Comparable<E>>) elemente.clone();
	Iterator<Comparable<E>> it=tempSet.iterator();
	while(it.hasNext())
	{
	    temp.addElement(it.next());
	}
	return temp;
    }
    
    //iterator
    public Iterator<Comparable<E>> iterator()
    {
	return elemente.iterator();
    }
    
    //schnittmenge
    public Menge<E> getSchnittmenge(Menge<E> menge)
    {
	Menge<E> temp=new Menge<E>();
	Comparable<E> elem=null;
	Iterator<Comparable<E>> it=menge.iterator();
	while(it.hasNext())
	{
	    elem=it.next();
	    if(elemente.contains(elem))
	    {
		temp.addElement(elem);
	    }
	}
	return temp;
    }
    
    //vereinigung zweier mengen
    public Menge<E> getVereinigung(Menge<E> menge)
    {
	Menge<E> temp=menge.getCloneMenge();
	Comparable<E> elem=null;
	Iterator<Comparable<E>> it=elemente.iterator();
	while(it.hasNext())
	{
	    elem=it.next();
	    temp.addElement(elem);
	}
	return temp;
    }
    
   //entfernen
    public boolean loescheElem(Comparable<E> elem)
    {
	return elemente.remove(elem);
    }

    //differenzbildung
    public Menge<E> getDifferenz(Menge<E> menge)
    {
	Menge<E> temp=new Menge<E>();
	Comparable<E> elem=null;
	Iterator<Comparable<E>> it=menge.iterator();
	while(it.hasNext())
	{
	    elem=it.next();
	    if(!elemente.contains(elem))
	    {
		temp.addElement(elem);
	    }
	}
	return temp;
    }
    
    public boolean isVorhanden(Comparable<E> elem)
    {
	return elemente.contains(elem);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((elemente == null) ? 0 : elemente.hashCode());
	return result;
    }

    
    
    //gleichheit zweier mengen
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Menge other = (Menge) obj;
	if (elemente == null) {
	    if (other.elemente != null)
		return false;
	} else if (!elemente.equals(other.elemente))
	    return false;
	return true;
    }
    
    
    
}
