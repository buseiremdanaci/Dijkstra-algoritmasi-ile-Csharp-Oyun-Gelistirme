package prolab2.pkg1;

public class Guclu extends Oyuncu
{
	public Guclu()
	{
		
	}
	
	public Guclu(String oyuncuID, String oyuncuAdi,int karakterX,int karakterY)
	{
		super(oyuncuID, oyuncuAdi);
		setOyuncuID(oyuncuID);
		setOyuncuAdi(oyuncuAdi);
		setOyuncuTUR(this.getClass().getSimpleName());
		setPuanDusmeYuzde(0);
		setAdimIlerle(1);
		setKarakterX(karakterX);
		setKarakterY(karakterY);
		setSkor(50);
	}

	@Override
	void skorAzalt(String karakterTur) 
	{
		// TODO Auto-generated method stub
		if(karakterTur == "Azman")
		{
			setSkor(getSkor() - 5 - (5 * getPuanDusmeYuzde())/100);
		}
		else
		{
			setSkor(getSkor() - 15 - (15 * getPuanDusmeYuzde())/100);
		}
		setPuanDusmeYuzde(getPuanDusmeYuzde() + 20);
	}
	
}
