package glavni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class TestBankomat {
	
	static Scanner unos=new Scanner(System.in);
	@Test
	public void testPrimanjeNovca() throws ClassNotFoundException, IOException
	{
		Racun racun= new Racun(1,"Ana",20);
		racun.primanjeNovca(10);
		assertEquals(30,racun.getIznosNaRacunu(),0);
	}
	@Test
	public void testSlanjeNovca() throws ClassNotFoundException, IOException
	{
		Racun racun= new Racun(1,"Ana",20);
		racun.slanjeNovca(10);
		assertEquals(10,racun.getIznosNaRacunu(),0);
	}
	@Test
	public void testDaLiPostojiRacun() throws ClassNotFoundException, IOException
	{	Racun racun= new Racun(1,"Ana",20);
		Racun racun1= new Racun(1,"Ana",20);
		Racun.ListaRacuna.add(racun1);
		Racun.ListaRacuna.add(racun);
		int rjesnje=Racun.validacijaBrojaRacuna(racun.brojRacuna);
		assertEquals(1,rjesnje,0);
	}
	@Test 
	public void testDaLiRacunImaDovoljnoNovca() throws ClassNotFoundException, IOException
	{
		Racun racun= new Racun(1,"Ana",20);
		
		boolean rjesnje=racun.daLiRacunImaDovoljnoNovca(30);
		assertEquals(false,rjesnje);
		
	}	
	
	@Test 
	public void transferovanJeNovacNaTarget() throws ClassNotFoundException, IOException
	{
		Racun racun= new Racun(0,"Ana",20);
		Racun rac= new Racun(2,"Ana",30);
		Racun.ListaRacuna.add(rac);
		Racun.ListaRacuna.add(racun);
		Racun.TransferNovca(2, 0, 10);
		double rjesnje = racun.getIznosNaRacunu();
		assertEquals(30,rjesnje,0);
	}
	@Test 
	public void transferovanJeNovacSaSourcea() throws ClassNotFoundException, IOException
	{
		Racun racun2= new Racun(3,"Ana",20);
		Racun racun3= new Racun(4,"Ana",30);
		Racun.ListaRacuna.add(racun2);
		Racun.ListaRacuna.add(racun3);
		Racun.TransferNovca(4, 3, 10);
		double rjesnje = racun3.getIznosNaRacunu();
		assertEquals(20,rjesnje,0);
	}
	
	@Test
	public void unosBrojaRacunaUnijeti_0()
	{
		int broj;
		broj=Main.unosBrojaRacuna();
		assertEquals(0,broj);
	}
	@Test
	public void unosImenaKorisnikaUnijeti_a()
	{
		String ime;
		ime=Main.unosImenaKorisnika();
		assertEquals("a",ime);
	}
	@Test
	public void unosIznosaRacunaUnijeti_0()
	{
		double broj;
		broj=Main.unosIznosaNaRacunu();
		assertEquals(0,broj,0);
	}
	
	@Test
	public void vracanjeBrojaOpcijeTest_Unijeti_1 ()
	{
		assertEquals(1,Main.vracaBrojOpcije());
	}
		
	@Test
	public void nemaOpcijeTestIspis ()
	{
		assertEquals("Broj koji ste unijeli nije ponudjen.",Main.nemaOpcijeIspis());
	}
	
		
	@Test
	public void vracanjeKreiranogRacuna45Amila1000 () throws ClassNotFoundException, IOException
	{
		Racun racun45=new Racun(45, "Amila", 1000);
		boolean test;
		test=false;
		Racun racunProba= new Racun();
		racunProba=Main.opcija1();
		if(racun45.getImeMsterije().equals(racunProba.getImeMsterije())&&(racun45.getIznosNaRacunu()==racunProba.getIznosNaRacunu())&&(racun45.brojRacuna==racunProba.brojRacuna))
		{
			test=true;
		}	
		assertTrue(test);
	}	
		
	@Test
	public void informacijeTest() throws  IOException, ClassNotFoundException
	{Racun racun46=new Racun(45, "Amila", 1000);
		assertTrue(racun46.informacije());
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
