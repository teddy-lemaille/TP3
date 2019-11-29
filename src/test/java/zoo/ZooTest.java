package zoo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import comparator.Comparator;


public class ZooTest 
{

	@Test
	public void testNouveauVisiteur() throws LimiteVisiteurException 
	{
		Zoo zoo = new Zoo();
		zoo.ajouterSecteur("Chien");
		

		for(int i=0; i<15; i++)
		{
			zoo.nouveauVisiteur();	
		}
		
		try
		{
			zoo.nouveauVisiteur();
			fail();
		}
		catch(LimiteVisiteurException e)
		{
			
		}
		
		Animal premierChien = new Animal("toutou","Chien");
		zoo.nouvelAnimal(premierChien);
		assertEquals(1,zoo.nombreAnimaux());
		assertEquals(true,zoo.getM_secteursAnimaux().get(0).getM_animauxDansSecteur().contains(premierChien));
	}
	
	


	@Test
	public void testComparatorSecteur()
	{
		Zoo zoo = new Zoo();
		zoo.ajouterSecteur("Chien");
		zoo.ajouterSecteur("Chat");
		
		Animal Chien1 = new Animal("toutou","Chien");
		zoo.nouvelAnimal(Chien1);
		Animal Chien2 = new Animal("toutou2","Chien");
		zoo.nouvelAnimal(Chien2);
		
		Animal Chat1 = new Animal("tou","Chat");
		zoo.nouvelAnimal(Chat1);
		
		Comparator com = new Comparator();
		
		
		assertEquals(1, com.compare(zoo.getM_secteursAnimaux().get(0), zoo.getM_secteursAnimaux().get(1)));
		
	}
	
}
