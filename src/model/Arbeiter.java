package model;

public class Arbeiter extends Mitarbeiter
{
	private int stunden;
	private double stundenLohn;
	
	public Arbeiter(String zeile) throws MitarbeiterException
	{
		super(zeile);
		
		//Angestellter;Thomas;1972;m;2000;3500
		String[] zeilenTeile;
		
		try
		{
			zeilenTeile = zeile.split(";");
			setStunden(Integer.parseInt(zeilenTeile[5].trim()));
			setStundenLohn(Double.parseDouble(zeilenTeile[6].trim()));
		}
		catch (NumberFormatException | IndexOutOfBoundsException e)
		{
			throw new MitarbeiterException("Fehler: ungültiges Format!");
		}
	}
	
	public Arbeiter(String name, int geb, char gesch, int eintr, int stunden, double stundenLohn) throws MitarbeiterException
	{
		super(name, geb, gesch, eintr);
		setStunden(stunden);
		setStundenLohn(stundenLohn);
	}

	public int getStunden()
	{
		return stunden;
	}
	
	public void setStunden(int stunden)
	{
		this.stunden = stunden;
	}
	
	public double getStundenLohn()
	{
		return stundenLohn;
	}
	
	public void setStundenLohn(double stundenLohn)
	{
		this.stundenLohn = stundenLohn;
	}

	@Override
	public double berechneGehalt()
	{
		return stunden * stundenLohn;
	}	
	
	@Override
	public String toStringCSV()
	{
		return "Arbeiter;" + super.toStringCSV() + ";" + stunden + ";" + stundenLohn;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " " + stunden + " Stunden " + stundenLohn + " Stundenlohn";
	}
}
