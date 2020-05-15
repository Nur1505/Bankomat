package glavni;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	
	static Scanner unos=new Scanner(System.in);
	

	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{Racun.zapisi();
	
		for(;;)
		{int opcija=vracaBrojOpcije();	
			if(opcija==1)
			{
				opcija1();		
			}else if(opcija==2)
			{
				System.out.println("Broj racuna sa kojeg se vrsi transfer: ");
				int brojSourceRacuna=unosBrojaRacuna();
				System.out.println("Broj racuna na koji se vrsi transfer: ");
				int brojTargetRacuna=unosBrojaRacuna();
				System.out.println("Iznos za transfer: ");
				double iznos=unosIznosaNaRacunu();
				Racun.TransferNovca(brojSourceRacuna, brojTargetRacuna,iznos);
				
			}
			else if(opcija==3)
			{Racun.informacije();
			}
			else if(opcija==4)
			{	new FileOutputStream("Racuni.txt").close();
				Racun.save();break;}
			else{nemaOpcijeIspis();}
		}
		
	}
	public static int unosBrojaRacuna()
	{
		System.out.println("Broj racuna: ");
		int brojRacuna=unos.nextInt();
		return brojRacuna;
	}
	public static String unosImenaKorisnika()
	{
		System.out.println("Korisnicko ime: ");
		String imeKorisnika=unos.next();
		return imeKorisnika;
	}
	public static double unosIznosaNaRacunu()
	{
		System.out.println("Iznos : ");
		double iznosNaRacunu=unos.nextDouble();
		return iznosNaRacunu;
	}
	public static Racun opcija1() throws ClassNotFoundException, IOException
	{
		int uneseniBrojRacuna=unosBrojaRacuna();
		String imeKorisnika=unosImenaKorisnika();
		double iznosNaRacunu=unosIznosaNaRacunu();
		Racun racun = new Racun(uneseniBrojRacuna,imeKorisnika,iznosNaRacunu);
		racun.dodajRacunNaListu();
		
		return racun;
	}
	public static String nemaOpcijeIspis()
	{
		return "Broj koji ste unijeli nije ponudjen.";
	}
	public static int vracaBrojOpcije()
	{
		int opcija;
		 System.out.println("");
			System.out.println("Unesite broj u zavisnosti od zeljene opcije:");
			System.out.println("1=Kreiranje novog racuna.");
			System.out.println("2=Transfer novca.");
			System.out.println("3=Ispis informacija.");
			System.out.println("4=Zatvori i sacuvaj uneseno.");
			
			opcija=unos.nextInt(); 
			if((opcija!=1)&&(opcija!=2)&&(opcija!=3)&&(opcija!=4))
			{Main.nemaOpcijeIspis();}	
		return opcija;
	}
}
