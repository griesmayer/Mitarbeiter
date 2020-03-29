package model;

public class Angestellter extends Mitarbeiter
{
	private double lohn;

	public Angestellter(String zeile) throws MitarbeiterException
	{
		super(zeile);
		
		//Angestellter;Thomas;1972;m;2000;3500
		String[] zeilenTeile;
		
		try
		{
			zeilenTeile = zeile.split(";");
			setLohn(Double.parseDouble(zeilenTeile[5].trim()));
		}
		catch (NumberFormatException | IndexOutOfBoundsException e)
		{
			throw new MitarbeiterException("Fehler: ungültiges Format!");
		}
	}
	
	public Angestellter(String name, int geb, char gesch, int eintr, double lohn) throws MitarbeiterException
	{
		super(name, geb, gesch, eintr);
		setLohn(lohn);
	}

	public double getLohn()
	{
		return lohn;
	}

	public void setLohn(double lohn)
	{
		if (lohn >= 1500)
		{
			this.lohn = lohn;
		}
		else
		{
			System.out.println("Fehler: zu wenig!");
			this.lohn = 1500;
		}
	}

	@Override
	public String toStringCSV()
	{
		return "Angestellter;" + super.toStringCSV() + ";" + lohn;
	}
	
	@Override
	public double berechneGehalt()
	{
		return lohn;
	}	
}
