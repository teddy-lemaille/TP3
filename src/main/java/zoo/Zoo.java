package zoo;
import org.apache.logging.log4j.LogManager ;
import org.apache.logging.log4j.Logger ;
import java.util.ArrayList;
import java.util.List;

public class Zoo 
{
	private static final Logger logger = LogManager.getLogger ( Zoo.class ); 
	private int m_visiteurs;
	private List<Secteur> m_secteursAnimaux;
	
	public int getM_visiteurs() {
		return m_visiteurs;
	}

	public void setM_visiteurs(int m_visiteurs) {
		this.m_visiteurs = m_visiteurs;
	}

	public List<Secteur> getM_secteursAnimaux() {
		return m_secteursAnimaux;
	}

	public void setM_secteursAnimaux(List<Secteur> m_secteursAnimaux) {
		this.m_secteursAnimaux = m_secteursAnimaux;
	}

	public Zoo() 
	{
		logger.fatal("Creation d'un zoo");
		m_secteursAnimaux = new ArrayList<Secteur>();
	}
		
	public void ajouterSecteur(String type)
	{
		logger.fatal("Nouvelle secteur");
		m_secteursAnimaux.add(new Secteur(type));
	}
	
	public void nouveauVisiteur() throws LimiteVisiteurException
	{
		if(m_visiteurs < getLimiteVisiteur())
			m_visiteurs++;
		else 
			throw new LimiteVisiteurException();
	}
	
	public int getLimiteVisiteur()
	{
		return (15*m_secteursAnimaux.size());
	}

	public void nouvelAnimal(Animal animal)
	{
		logger.fatal("Nouvelle animal");
		boolean secteurBon = false;
		for(Secteur s:this.m_secteursAnimaux)
		{
			if(animal.getTypeAnimal().equals(s.obtenirType()))
			{
				try 
				{
					secteurBon = true;
					s.ajouterAnimal(animal);
				} 
				catch (AnimalDansMauvaisSecteurException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		if(secteurBon == false)		
		{
			ajouterSecteur(animal.getTypeAnimal());
			nouvelAnimal(animal);
		}
		
		
		
	}
	
	public int nombreAnimaux()
	{
		int nbrAnimaux = 0;
		for(Secteur s:this.m_secteursAnimaux)
		{
			nbrAnimaux += s.getNombreAnimaux();
		}
		return nbrAnimaux;
	}
		
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Zoo zoo = new Zoo();
		zoo.ajouterSecteur("Chien");
		
		for(int i=0; i<14; i++)
		{
			try 
			{
				zoo.nouveauVisiteur();
			} 
			catch (LimiteVisiteurException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("nbr visiteur = " + zoo.m_visiteurs);
		}
		
		zoo.ajouterSecteur("Chat");
		
		try 
		{
			zoo.nouveauVisiteur();
		} 
		catch (LimiteVisiteurException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("nbr visiteur = " + zoo.m_visiteurs);
	}

}
