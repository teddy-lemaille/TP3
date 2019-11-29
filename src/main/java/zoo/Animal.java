package zoo;

public class Animal 
{

	protected String m_nomAnimal;
	protected String m_typeAnimal;
	
	public Animal() 
	{
	}
	
	public Animal(String m_nomAnimal, String m_typeAnimal) 
	{
		this.m_nomAnimal = m_nomAnimal;
		this.m_typeAnimal = m_typeAnimal;
	}
	
	public String getNomAnimal()
	{
		return m_nomAnimal;
	}
	
	public String getTypeAnimal()
	{
		return m_typeAnimal;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
