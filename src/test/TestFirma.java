package test;

import model.*;

public class TestFirma
{
	public static void main(String[] args)
	{
		testExportMitarbeiter();
	}

	public static void testExportMitarbeiter()
	{
		Firma firma;
		
		try
		{
			firma = new Firma("Hugo Import Export!");

			firma.aufnehmen(new Arbeiter("Hugo",      2001, 'm', 2019, 100, 40));
			firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
			firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
			firma.aufnehmen(new Angestellter("Hugo",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
			firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
			firma.aufnehmen(new Arbeiter("Hugo",      1981, 'm', 2020, 100, 40));
			firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
			System.out.println(firma);
			System.out.println("===========================");
			firma.exportMitarbeiter("/home/thomas/Desktop/Code_2019/4akif/13_TextFiles/mitarbeiter_export.txt");
			firma.exportMitarbeiter(null);
			firma.exportMitarbeiter("/gibtsjanicht/mitarbeiter.ser");
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
	}

	
	public static void testImportMitarbeiter()
	{
		Firma firma;
		
		try
		{
			firma = new Firma("Hugo Import Export!");
			firma.importMitarbeiter("/home/thomas/Desktop/Code_2019/4akif/13_TextFiles/mitarbeiter.txt");
			System.out.println(firma);
			
			firma.importMitarbeiter("/home/thomas/gibtesnicht/mitarbeiter.txt");
			firma.importMitarbeiter(null);
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
	}
	

	public static void testLoadMitarbeiter()
	{
		Firma firma;
		
		try
		{
			firma = new Firma("Hugo Import Export!");
			firma.loadMitarbeiter("/home/thomas/Desktop/Code_2019/4akif/13_TextFiles/mitarbeiter.ser");
			System.out.println(firma);
			System.out.println("===========================");
			firma.loadMitarbeiter(null);			
			firma.loadMitarbeiter("/gibtsjanicht/mitarbeiter.ser");
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void testSaveMitarbeiter()
	{
		Firma firma;
		
		try
		{
			firma = new Firma("Hugo Import Export!");

			firma.aufnehmen(new Arbeiter("Hugo",      2001, 'm', 2019, 100, 40));
			firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
			firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
			firma.aufnehmen(new Angestellter("Hugo",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
			firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
			firma.aufnehmen(new Arbeiter("Hugo",      1981, 'm', 2020, 100, 40));
			firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
			System.out.println(firma);
			System.out.println("===========================");
			firma.saveMitarbeiter("/home/thomas/Desktop/Code_2019/4akif/13_TextFiles/mitarbeiter.ser");
			firma.saveMitarbeiter(null);
			firma.saveMitarbeiter("/gibtsjanicht/mitarbeiter.ser");
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void testSortGehalt()
	{
		Firma firma;
		
		try
		{
			firma = new Firma("Hugo Import Export!");

			firma.aufnehmen(new Arbeiter("Hugo",      2001, 'm', 2019, 100, 40));
			firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
			firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
			firma.aufnehmen(new Angestellter("Hugo",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
			firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
			firma.aufnehmen(new Arbeiter("Hugo",      1981, 'm', 2020, 100, 40));
			firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
			System.out.println(firma);
			System.out.println("===========================");
			firma.sortGehalt();
			System.out.println(firma);
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void testSortAlter()
	{
		Firma firma;
		
		try
		{
			firma = new Firma("Hugo Import Export!");

			firma.aufnehmen(new Arbeiter("Hugo",      2001, 'm', 2019, 100, 40));
			firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
			firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
			firma.aufnehmen(new Angestellter("Hugo",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
			firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
			firma.aufnehmen(new Arbeiter("Hugo",      1981, 'm', 2020, 100, 40));
			firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
			System.out.println(firma);
			System.out.println("===========================");
			firma.sortAlter();
			System.out.println(firma);
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void testSortName()
	{
		Firma firma;
		
		try
		{
			firma = new Firma("Hugo Import Export!");

			firma.aufnehmen(new Arbeiter("Hugo",      2001, 'm', 2019, 100, 40));
			firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
			firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
			firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
			firma.aufnehmen(new Angestellter("Hugo",  1975, 'f', 2010, 1700));
			firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
			firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
			firma.aufnehmen(new Arbeiter("Hugo",      1981, 'm', 2020, 100, 40));
			firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
			System.out.println(firma);
			System.out.println("===========================");
			firma.sortName();
			System.out.println(firma);
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
	}
/*
	public static void testKundigen()
	{
		Firma firma;
		
		firma = new Firma("Hugo Import Export!");
		firma.kundigen(null);
		firma.kundigen("Hugo");
		System.out.println(firma);
		System.out.println("===========================");
		firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
		firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
		firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
		firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
		firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
		firma.aufnehmen(new Angestellter("Hugo",  1975, 'f', 2010, 1700));
		firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
		firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
		firma.aufnehmen(new Arbeiter("Hugo",      1981, 'm', 2020, 100, 40));
		firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
		System.out.println(firma);
		System.out.println("===========================");
		firma.kundigen("Hugo");
		System.out.println("===========================");
		System.out.println(firma);
		System.out.println("===========================");
		firma.kundigen("Andrea");
		System.out.println(firma);
		System.out.println("===========================");
	}
	
	public static void testErsterArbeiter()
	{
		Firma firma;
		
		firma = new Firma("Hugo Import Export!");
		System.out.println(firma.getErsterArbeiter());		//null
		firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
		firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
		System.out.println(firma.getErsterArbeiter());		//null
		firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
		firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
		firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
		firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
		firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
		firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
		System.out.println(firma.getErsterArbeiter());		//Max
	}
	
	public static void testAlterMitarbeiter()
	{
		Firma firma;
		
		firma = new Firma("Hugo Import Export!");
		System.out.println(firma.alterMitarbeiter());		
		firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
		firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
		firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
		firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
		firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
		firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
		firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
		firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
		System.out.println(firma);
		System.out.println(firma.alterMitarbeiter());
	}
	
	public static void testBerechneFrauenQuote()
	{
		Firma firma;
		
		firma = new Firma("Hugo Import Export!");
		firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
		firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
		firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
		firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
		firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
		firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
		firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
		firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
		System.out.println(firma);
		System.out.println(firma.berechneFrauenQuote());
	}
	
	public static void testBerechneGehaltTotal()
	{
		Firma firma;
		
		firma = new Firma("Hugo Import Export!");
		firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
		firma.aufnehmen(new Arbeiter("Max",       1965, 'm', 2019, 100, 40));
		firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
		firma.aufnehmen(new Arbeiter("Hugo",      1969, 'm', 2019, 100, 40));
		firma.aufnehmen(new Arbeiter("Werner",    1970, 'm', 2020,  50, 30));
		firma.aufnehmen(new Arbeiter("Franz",     1972, 'm', 1994,  80, 35));
		firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
		firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
		System.out.println(firma);
		System.out.println(firma.berechneGehaltTotal());
	}

	public static void testAufnehmen2()
	{
		Arbeiter a;
		Firma firma;
		
		a = new Arbeiter("Franz", 1965, 'm', 2019, 100, 40);
		firma = new Firma("Hugo Import Export!");
		firma.aufnehmen(new Angestellter("Fritz", 1970, 'm', 2001, 2700));
		firma.aufnehmen(new Arbeiter("Max", 1965, 'm', 2019, 100, 40));
		firma.aufnehmen(a);
		firma.aufnehmen(new Angestellter("Susi",  1975, 'f', 2010, 1700));
		firma.aufnehmen(new Angestellter("Alex",  1981, 'f', 2017, 3700));
		firma.aufnehmen(a);
		firma.aufnehmen(new Angestellter("Maria", 1990, 'f', 2001, 2900));
		System.out.println(firma);
	}
	
	public static void testAufnehmen()
	{
		Angestellter a1, a2;
		Firma firma;
		
		firma = new Firma("Hugo Import Export!");
		a1 = new Angestellter("Fritz", 1970, 'm', 2001, 2700);
		a2 = new Angestellter("Susi", 1981, 'f', 2010, 3100);
		firma.aufnehmen(a1);
		firma.aufnehmen(a2);
		firma.aufnehmen(a1);
		firma.aufnehmen(null);
		System.out.println(firma);
	}

	public static void testInstanz()
	{
		Firma firma;
		Firma ungultig;
		
		ungultig = new Firma(null);
		firma = new Firma("Hugo Import Export!");
	}
	*/
}
