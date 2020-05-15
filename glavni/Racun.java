package glavni;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

	public class Racun implements Serializable{
	

	

		/**
		 * 
		 */
		private static final long serialVersionUID = 6179497876990317274L;

		static int brojacRacuna=0;
					
		public static ArrayList<Racun>ListaRacuna=new ArrayList<Racun>();
		protected int brojRacuna;
		protected String imeMsterije;
		protected double iznosNaRacunu;
		static int daLiPostojiRacun=0;
		
		Racun()
		{}
		
		Racun(int brojRacuna,String imeMusterije,double iznosNaRacunu) throws IOException, ClassNotFoundException
		{
			this.iznosNaRacunu=iznosNaRacunu;
			this.brojRacuna=brojRacuna;
			this.imeMsterije=imeMusterije;
			
		
		}
		
		public void dodajRacunNaListu()
		{
			if((this.iznosNaRacunu>0)&&(validacijaBrojaRacuna(this.brojRacuna)==0))
			{
				ListaRacuna.add(this);
			}
			
		}
	
		
		public static int validacijaBrojaRacuna(int brojRacuna)
		{int validacija=0;
			 
			for(int i=0; i<ListaRacuna.size(); i++)
			{
				if((brojRacuna==ListaRacuna.get(i).brojRacuna)||(brojRacuna<0))
				{	System.out.println("Unesen je negativan broj ili vec postojuci broj racuna.");
					validacija=1;
					break;
				}else{continue;}
			}
		return validacija;
		}
			
			
		
		

		public void setBrojRacuna(int brojRacuna) {
			this.brojRacuna = brojRacuna;
		}

		public String getImeMsterije() {
			return imeMsterije;
		}

		public void setImeMsterije(String imeMsterije) {
			this.imeMsterije = imeMsterije;
		}

		public double getIznosNaRacunu() {
			return iznosNaRacunu;
		}

		public void setIznosNaRacunu(double iznosNaRacunu) {
			this.iznosNaRacunu = iznosNaRacunu;
			
		}
		protected void slanjeNovca(double iznosZaSlanje)
		{
			double ukupanIznos=getIznosNaRacunu();
			ukupanIznos=ukupanIznos-iznosZaSlanje;
			this.setIznosNaRacunu(ukupanIznos);
			
		}
		protected void primanjeNovca(double primljeniIznos)
		{
			double ukupanIznos=getIznosNaRacunu();
			ukupanIznos=ukupanIznos+primljeniIznos;
			this.setIznosNaRacunu(ukupanIznos);
		}
		protected boolean daLiRacunImaDovoljnoNovca(double iznos)
		{
			if(this.getIznosNaRacunu()>=iznos)
			{return true;}
			else{return false;}
		}
		
		
		
		
		
		
		public static  void TransferNovca(int brojSourceRacuna,int brojTargetRacuna, double iznos) throws IOException
		{int daLiPostojiSourceRacun=0;
		int daLiPostojiTargetRacun=0;
			
			for(int i=0;i<ListaRacuna.size();i++)
			{ 
				if(ListaRacuna.get(i).brojRacuna==brojSourceRacuna)
				{daLiPostojiSourceRacun=1;
					if(ListaRacuna.get(i).daLiRacunImaDovoljnoNovca(iznos)==true)
					{ListaRacuna.get(i).slanjeNovca(iznos); break;}else{System.out.println("Nema dovoljno novca na racunu.");break;}
				}
					
			}
			for(int i=0;i<ListaRacuna.size();i++)
			{
			if(ListaRacuna.get(i).brojRacuna==brojTargetRacuna)
			{daLiPostojiTargetRacun=1;
			ListaRacuna.get(i).primanjeNovca(iznos);break;}}
			
			if(daLiPostojiSourceRacun==0)
			{System.out.println("Unijeli ste nepostojuci broj source racuna");}
			if(daLiPostojiTargetRacun==0)
			{System.out.println("Unijeli ste nepostojuci broj target racuna");}
			
			
			
		}

		
		public static void save() throws IOException
		{
			FileOutputStream fo=new FileOutputStream("Racuni.txt");
			ObjectOutputStream output= new ObjectOutputStream(fo);
			for(int i=0;i<ListaRacuna.size();i++)
			{
			 output.writeObject(ListaRacuna.get(i));
			}
		}
		
		public static void zapisi() throws IOException, ClassNotFoundException
		{	File file=new File ("Racuni.txt");
			
		if (!file.exists()) 
			{file.createNewFile();}
		
		
			FileInputStream fi= new FileInputStream ("Racuni.txt");
			ObjectInputStream input= null;
			try {
				input= new ObjectInputStream (fi);
			} catch (EOFException e) {
				return;
			}
			
			
			while(true)
		{
				try{
				
				
						ListaRacuna.add((Racun)input.readObject());
						brojacRacuna++;
								
				}catch(EOFException e){input.close();break;}
		}}
		
		
		
		public static boolean informacije()
		{ boolean ispis=false;
			for(int i=0;i<ListaRacuna.size();i++)
			{
				System.out.println("Broj racuna: "+ListaRacuna.get(i).brojRacuna);
				System.out.println("Ime korisnika: "+ListaRacuna.get(i).imeMsterije);
				System.out.println("Iznos na racunu: "+ListaRacuna.get(i).iznosNaRacunu);
				System.out.println("");
				ispis=true;
			}
			return ispis;
		}
		
		
		
		
		
	
}
