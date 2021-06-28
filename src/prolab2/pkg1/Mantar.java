package prolab2.pkg1;

import java.util.ArrayList;
import java.util.Random;

public class Mantar extends Obje
{
	Random r = new Random();
	private int[] koordinat;
	
	public Mantar() 
	{
		super();
		setPuan(50);
	}
	
	@Override
	public void objeUret(ArrayList<Integer> altinLocation) 
	{
		getObjects().clear();
		objectLocation.clear();
		for (int mantarSayisi = 0; mantarSayisi < 1; mantarSayisi++)
		{
			getObjects().add(new Mantar());
			while (true) 
			{
				getObjects().get(mantarSayisi).setLocation(r.nextInt(78));
				if(!altinLocation.contains(getObjects().get(mantarSayisi).getLocation()))
    			{
					altinLocation.add(getObjects().get(mantarSayisi).getLocation());
    				break;
    			}
			}
			objectLocation.add(getObjects().get(mantarSayisi).getLocation());
			koordinat = new Dijkstra().numberToIndex(getObjects().get(mantarSayisi).getLocation());
			getObjects().get(mantarSayisi).setObjeX(koordinat[0]);
			getObjects().get(mantarSayisi).setObjeY(koordinat[1]);
		}
	}
}
