package test;

import model.*;

public class TestMitarbeiter
{

	public static void main(String[] args)
	{
		testMitarbeiter();

	}
	
	public static void testMitarbeiter()
	{
		Arbeiter a1, a2, a3, a4, a5;
		
		try
		{
			a1 = new Arbeiter("Fritz Mayer", 1899, 'm', 2010, 20, 29);
			System.out.println(a1);
			System.out.println(a1.getInitialen());
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			a2 = new Arbeiter("Max Müller",   2021, 'm', 2010, 20, 29);
			System.out.println(a2);
			System.out.println(a2.getInitialen());
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			a3 = new Arbeiter("Karl Moser",  1973, 'm', 2010, 20, 29);
			System.out.println(a3);
			System.out.println(a3.getInitialen());
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			a4 = new Arbeiter("Thomas",  1973, 'm', 2010, 20, 29);
			System.out.println(a4);
			System.out.println(a4.getInitialen());
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			a5 = new Arbeiter("Thomas ",  1973, 'm', 2010, 20, 29);
			System.out.println(a5);
			System.out.println(a5.getInitialen());
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
	}
	/*
	public static void testVererbung()
	{
		//Mitarbeiter m;
		Angestellter a1, a2, a3, a4;
		Arbeiter b1, b2, b3;
		
		//m = new Mitarbeiter ("Fritz", 1975, 'm', 2000);
		a1 = new Angestellter("Susi",  1970, 'f', 2000, 2200);
		a2 = new Angestellter("Maria", 1975, 'f', 1990, 2000);
		a3 = new Angestellter("Franz", 1979, 'm', 1995, 2500);
		a4 = new Angestellter("Karl",  1973, 'm', 1999, 1600);
		b1 = new Arbeiter("Alex",      1969, 'm', 2005, 80, 15);
		b2 = new Arbeiter("Max",       1972, 'm', 2010, 40, 18);
		b3 = new Arbeiter("Michael",   1989, 'm', 2010, 90, 20);
		System.out.println(a1.berechneGehalt());   //2200
		System.out.println(a2.berechneGehalt());   //2000
		System.out.println(a3.berechneGehalt());   //2500
		System.out.println(a4.berechneGehalt());   //1600
		System.out.println(b1.berechneGehalt());   //1200
		System.out.println(b2.berechneGehalt());   // 720
		System.out.println(b3.berechneGehalt());   //1800
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
	*/
}
