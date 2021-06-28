package prolab2.pkg1;

public class Azman extends Dusman
{	
	
	public Azman()
	{
	   
	}
   
	public Azman(String dusmanID, String dusmanAdi, String girisKapisi)
	{
		super(dusmanID, dusmanAdi,girisKapisi);
    	setDusmanID(dusmanID);
    	setDusmanAdi(dusmanAdi);
    	setDusmanTur(this.getClass().getSimpleName());
    	setAdimIlerle(1);
	}
  
}
