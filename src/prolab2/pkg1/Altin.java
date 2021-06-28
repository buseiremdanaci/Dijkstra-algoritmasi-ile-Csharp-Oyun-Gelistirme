package prolab2.pkg1;

import java.util.ArrayList;
import java.util.Random;

public class Altin extends Obje
{ 
    Random r = new Random();
    private int[] koordinat;
	
    public Altin()
    {
    	super();
    	setPuan(5);
    }
    
    @Override
	public void objeUret(ArrayList<Integer> mantarLocations)
    {
    	getObjects().clear();
    	objectLocation.clear();
    	for (int i = 0; i < 5; i++) 
    	{
    		getObjects().add(new Altin());
    		while (true) 
    		{
    			getObjects().get(i).setLocation(r.nextInt(78));
    			if(!mantarLocations.contains(getObjects().get(i).getLocation()))
    			{
    				mantarLocations.add(getObjects().get(i).getLocation());
    				break;
    			}
			}
    		objectLocation.add(getObjects().get(i).getLocation());
    		koordinat = new Dijkstra().numberToIndex(getObjects().get(i).getLocation());
    		getObjects().get(i).setObjeX(koordinat[0]);
    		getObjects().get(i).setObjeY(koordinat[1]);
		}
		
	}
}
