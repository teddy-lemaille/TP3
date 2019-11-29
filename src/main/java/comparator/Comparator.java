package comparator;

import zoo.Secteur;

public class Comparator implements java.util.Comparator<Secteur>
{
	public int compare(Secteur a, Secteur b)
	{
		return a.getNombreAnimaux().compareTo(b.getNombreAnimaux());
	}

	
}
