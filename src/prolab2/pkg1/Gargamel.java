package prolab2.pkg1;

public class Gargamel extends Dusman
{
	
    public Gargamel()
    {
    	
    }
    
    public Gargamel(String dusmanID, String dusmanAdi, String girisKapisi)
    {
    	super(dusmanID, dusmanAdi,girisKapisi);
    	setDusmanID(dusmanID);
    	setDusmanAdi(dusmanAdi);
    	setDusmanTur(this.getClass().getSimpleName());
    	setAdimIlerle(2);
    }
    	
    	
}
