package model;

import java.io.Serializable;
import java.util.Comparator;

@SuppressWarnings("serial")
public abstract class Mitarbeiter implements Comparable<Mitarbeiter>, Serializable
{
	private String name;
	private int geburtsJahr;
	private char gesch;
	private int eintr;
	
	public Mitarbeiter(String zeile) throws MitarbeiterException
	{
		//Angestellter;Thomas;1972;m;2000;.........
		String[] zeilenTeile;
		
		try
		{
			zeilenTeile = zeile.split(";");
			setName(zeilenTeile[1].trim());
			setGeb(Integer.parseInt(zeilenTeile[2].trim()));
			setGesch(zeilenTeile[3].trim().charAt(0));
			setEintr(Integer.parseInt(zeilenTeile[4].trim()));
		}
		catch (NumberFormatException | IndexOutOfBoundsException e)
		{
			throw new MitarbeiterException("Fehler: ungültiges Format!");
		}
	}
	
	public Mitarbeiter() throws MitarbeiterException
	{
		setName("UNKN");
		setGeb(1980);
		setGesch('m');
		setEintr(2000);		
	}
	
	public Mitarbeiter(String name, int geb, char gesch, int eintr) throws MitarbeiterException
	{
		setName(name);
		setGeb(geb);
		setGesch(gesch);
		setEintr(eintr);
	}
	
	//------------------------------ getter --------------------
	public int getEintr()
	{
		return eintr;
	}
	
	public int getGeb()
	{
		return geburtsJahr;
	}
	
	public char getGesch()
	{
		return gesch;
	}
	
	public String getName()
	{
		return name;
	}
	
	//---------------------------------- setter ---------------
	public void setGeb(int geb) throws MitarbeiterException
	{
		if (geb >= 1900 && geb <= 2020) // hardcoded akt. Jahr ->  muss 'automatisiert' werden
		{
			this.geburtsJahr = geb;
		}
		else
		{
			throw new MitarbeiterException("Falscher Parameterwert fuer Mitarbeiter.setGeb(...) !!");
		}
	}
	
	public void setEintr(int eintr)
	{
		if (eintr >= 1900 && eintr <= 2020) // hardcoded akt. Jahr ->  muss 'automatisiert' werden
			this.eintr = eintr;
		else
			System.out.println("Falscher Parameterwert fuer Mitarbeiter.setEintr(...) !!");
	}
	
	public void setGesch(char gesch)
	{
		if (gesch == 'f' || gesch == 'm'  || gesch == 'x'  || gesch == 'd' )  // x und d fuer divers
			this.gesch = gesch;
		else
			System.out.println("Falscher Parameterwert ("+gesch+") fuer Mitarbeiter.setGesch(...) !!");
	}
	
	public void setName(String name)
	{
		if (name != null)
			this.name = name;
		else
			System.out.println("Null-Referenz fuer Mitarbeiter.setName(...) !!");
	}
	
	//  -------------------------------- sonstige ------------------------
	public int berechneAlter()
	{
		return 2020 - geburtsJahr;	// hardcoded akt. Jahr ->  muss 'automatisiert' werden
	}
	
	public int berechneDienstalter()
	{
		return 2020 - eintr;	// hardcoded akt. Jahr ->  muss 'automatisiert' werden
	}
	
	public abstract double berechneGehalt();
	
	public String toStringCSV()
	{
		return name + ";" + geburtsJahr + ";" + gesch + ";" + eintr;
	}
	
	@Override
	public String toString()
	{
		return name + " (" + geburtsJahr + ") " + gesch + " seit: "+ eintr + ": " + berechneGehalt();
	}
	
	//Thomas Griesmayer
	//Ts
	public String getFirstLast()
	{
		return null;
	}
	
	public String getInitialen() throws MitarbeiterException
	{
		try
		{
			if (name.contains(" "))
			{
				return "" + name.charAt(0) + name.charAt(name.indexOf(' ')+1);
			}
			else
			{
				throw new MitarbeiterException("Fehler: fehlt Leerzeichen zischen Vor- und Nachname!");
			}
		}
		catch (StringIndexOutOfBoundsException e)
		{
			throw new MitarbeiterException("Fehler: kein Vor- und Nachname definiert!");
		}
	}
	
	public int compareTo(Mitarbeiter other)
	{
		//name -> String
		if (this.name.compareTo(other.getName()) == 0)
		{
			return this.geburtsJahr - other.geburtsJahr;
		}
		else
		{
			return this.name.compareTo(other.getName());
		}
	}
	
	/*public int compareTo(Mitarbeiter other)
	{
		return this.geburtsJahr - other.geburtsJahr;
		
		if (this.geburtsJahr < other.geburtsJahr)
		{
			return -1;
		}
		else
		{
			if (this.geburtsJahr == other.geburtsJahr)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
	}*/
	
	
	public static class AltersComparator implements Comparator<Mitarbeiter>
	{
		@Override
		public int compare(Mitarbeiter m1, Mitarbeiter m2)
		{
			return m2.berechneAlter() - m1.berechneAlter();
		}
	}
	
	public static class GehaltComparator implements Comparator<Mitarbeiter>
	{
		public int compare(Mitarbeiter m1, Mitarbeiter m2)
		{
			return (int) (m2.berechneGehalt() - m1.berechneGehalt());
		}
	}
}





















