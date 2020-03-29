package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Firma
{
	private String firmenName;
	private ArrayList<Mitarbeiter> mitarbeiter;

	public Firma(String firmenName)
	{
		setFirmenName(firmenName);
		mitarbeiter = new ArrayList<Mitarbeiter>(20);
	}

	public String getFirmenName()
	{
		return firmenName;
	}

	public void setFirmenName(String firmenName)
	{
		if (firmenName != null)
		{
			this.firmenName = firmenName;
		}
		else
		{
			System.out.println("Fehler: ungültiger Firmenname!");
			this.firmenName = "UNKN";
		}
	}
	
	/* Falsche Schleife !!!
	public void kundigen(String name)
	{
		if (name != null)
		{
			for (Mitarbeiter m: mitarbeiter)
			{
				if (m.getName().equals(name))
				{
					mitarbeiter.remove(m);
				}
			}
		}
		else
		{
			System.out.println("Fehler: kein gültiger Name!");
		}
	}*/
	
	public void kundigen(String name)
	{
		Mitarbeiter m;
		Iterator<Mitarbeiter> it;
		
		if (name != null)
		{
			it = mitarbeiter.iterator();
			while (it.hasNext())
			{
				m = it.next();
				if (m.getName().equals(name))
				{
					it.remove();
				}
			}
		}
		else
		{
			System.out.println("Fehler: kein gültiger Name!");
		}
	}
	
	public Arbeiter getErsterArbeiter()
	{
		for (Mitarbeiter m : mitarbeiter)
		{
			if (m instanceof Arbeiter)
			{
				return (Arbeiter) m;
			}
		}
		return null;
	}
	
	public void aufnehmen(Mitarbeiter neu)
	{
		if (neu != null)
		{
			//if (!mitarbeiter.contains(neu))
			if (mitarbeiter.contains(neu) == false)
			{
				mitarbeiter.add(neu);
			}
			else
			{
				System.out.println("Fehler: Mitarbeiter schon in dieser Firma!");
			}
		}
		else
		{
			System.out.println("Fehler: kein Mitarbeiter!");
		}
	}

	public double berechneGehaltTotal()
	{
		double sum;
		
		sum = 0;
		for (Mitarbeiter m: mitarbeiter)
		{
			sum = sum + m.berechneGehalt();
		}
		return sum;
	}
	
	public double berechneFrauenQuote()
	{
		int anz;
		
		anz = 0;
		for (Mitarbeiter m: mitarbeiter)
		{
			if (m.getGesch() == 'f')
			{
				anz++;
			}
		}
		return (double)anz*100/mitarbeiter.size();
	}
	
	public Mitarbeiter alterMitarbeiter()
	{
		int jahr;
		Mitarbeiter alter;
		
		jahr = 9999;
		alter = null;
		for (Mitarbeiter m: mitarbeiter)
		{
			if (jahr > m.getGeb())
			{
				jahr = m.getGeb();
				alter = m;
			}
		}
		return alter;
	}
	
	@Override
	public String toString()
	{
		String erg;
		
		erg = "Firma: " + firmenName + "\n";
		for (Mitarbeiter m: mitarbeiter)
		{
			erg = erg + m.toString() + "\n";
		}
		return erg;
	}

	public String toStringCSV()
	{
		String erg;
		
		erg = "";
		for (Mitarbeiter m: mitarbeiter)
		{
			erg = erg + m.toStringCSV() + "\n";
		}
		return erg;
	}
	
	public void exportMitarbeiter(String filename) throws MitarbeiterException
	{
		if (filename != null)
		{
			try
			{
				FileWriter fileWriter = new FileWriter(filename);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(toStringCSV());
				bufferedWriter.close();
				fileWriter.close();
			}
			catch (FileNotFoundException e)
			{
				throw new MitarbeiterException("Fehler: Datei " + filename + " oder Pfad nicht gefunden!");
			}
			catch (IOException e)
			{
				throw new MitarbeiterException("Fehler: Datei " + filename + " konnte nicht geschrieben werden!");
			}
		}
		else
		{
			throw new MitarbeiterException("Fehler: kein Dateiname!");
		}
	}
	
	public void importMitarbeiter(String filename) throws MitarbeiterException
	{
		if (filename != null)
		{
			try
			{
				String zeile;
				FileReader fileReader = new FileReader(filename);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				zeile = bufferedReader.readLine();
				while (zeile != null)
				{
					if (zeile.startsWith("Angestellter"))
					{
						Angestellter angestellter = new Angestellter(zeile);
						aufnehmen(angestellter);
					}
					else
					{
						if (zeile.startsWith("Arbeiter"))						
						{
							Arbeiter arbeiter = new Arbeiter(zeile);
							aufnehmen(arbeiter);
						}
						else
						{
							throw new MitarbeiterException("Fehler: flascher Mitarbeitertyp!");
						}
					}					
					zeile = bufferedReader.readLine();				
				}
				bufferedReader.close();
				fileReader.close();
			}
			catch (FileNotFoundException e)
			{
				throw new MitarbeiterException("Fehler: Datei " + filename + " nicht gefunden!");
			}
			catch (IOException e)
			{
				throw new MitarbeiterException("Fehler: Datei " + filename + " konnte nicht gelesen werden!");
			}
		}
		else
		{
			throw new MitarbeiterException("Fehler: kein Dateiname!");			
		}
	}
	
	public void loadMitarbeiter(String filename) throws MitarbeiterException
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			mitarbeiter = (ArrayList<Mitarbeiter>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
		}
		catch (FileNotFoundException e)
		{
			throw new MitarbeiterException("Fehler: Datei " + filename + " nicht gefunden!");
		}
		catch (IOException e)
		{
			throw new MitarbeiterException("Fehler: Datei " + filename + " konnte nicht gelesen werden!");
		}
		catch (ClassNotFoundException e)
		{
			throw new MitarbeiterException("Fehler: Datei " + filename + " hat ein ungültiges Format!");
		}
		catch (NullPointerException e)
		{
			throw new MitarbeiterException("Fehler: kein Dateiname!");
		}
	}
	
	public void saveMitarbeiter(String filename) throws MitarbeiterException
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(mitarbeiter);
			objectOutputStream.close();
			fileOutputStream.close();
		}
		catch (FileNotFoundException e)
		{
			throw new MitarbeiterException("Fehler: Pfad " + filename + " nicht gefunden!");
		}
		catch (IOException e)
		{
			throw new MitarbeiterException("Fehler: Datei " + filename + " konnte nicht angelegt werden!");
		}
		catch (NullPointerException e)
		{
			throw new MitarbeiterException("Fehler: kein Dateiname!");
		}
	}
	
	public void sortName()
	{
		Collections.sort(mitarbeiter);
	}
	
	public void sortAlter()
	{
		Collections.sort(mitarbeiter, new Mitarbeiter.AltersComparator());
	}

	public void sortGehalt()
	{
		Collections.sort(mitarbeiter, new Mitarbeiter.GehaltComparator());
	}
}














