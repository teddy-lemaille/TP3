package zoo;
import java.util.ArrayList;
import java.util.List;

public class Secteur {

	
	public String getM_typeAnimauxDansSecteur() {
		return m_typeAnimauxDansSecteur;
	}

	public void setM_typeAnimauxDansSecteur(String m_typeAnimauxDansSecteur) {
		this.m_typeAnimauxDansSecteur = m_typeAnimauxDansSecteur;
	}

	public List<Animal> getM_animauxDansSecteur() {
		return m_animauxDansSecteur;
	}

	public void setM_animauxDansSecteur(List<Animal> m_animauxDansSecteur) {
		this.m_animauxDansSecteur = m_animauxDansSecteur;
	}

	private String m_typeAnimauxDansSecteur; 
	private List<Animal> m_animauxDansSecteur;
	
		
	public Secteur(String m_typeAnimauxDansSecteur) {
		super();
		this.m_typeAnimauxDansSecteur = m_typeAnimauxDansSecteur;
		m_animauxDansSecteur = new ArrayList<Animal>();
	}

	public void ajouterAnimal(Animal animal) throws AnimalDansMauvaisSecteurException
	{
		if(animal.getTypeAnimal().equals(m_typeAnimauxDansSecteur))
			m_animauxDansSecteur.add(animal);
		else
			throw new AnimalDansMauvaisSecteurException();		
	}
	
	public Integer getNombreAnimaux()
	{
		return m_animauxDansSecteur.size();
	}
	
	public String obtenirType()
	{
		return m_typeAnimauxDansSecteur;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
