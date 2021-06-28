/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg1;

import java.util.ArrayList;

public class Dusman extends Karakter{
    
	private String dusmanID;
    private String dusmanAdi;
    private String dusmanTur;
    private int adimIlerle;
    private int baslangicX;
    private int baslangicY;
 
    ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
    
	public Dusman(){
    
    }
    
    public Dusman(String karakterId,String karakterAdi,String girisKapisi)
    {
    	super();
    	setKarakterID(karakterId);
    	setKarakterAD(karakterAdi);
    	setTur("Düþman");
    	
    	if(girisKapisi.equals("A"))
    	{
    		setKarakterX(3);
    		setKarakterY(0);
    		setBaslangicX(3);
    		setBaslangicY(0);
    	}
    	else if (girisKapisi.equals("B")) 
    	{
    		setKarakterX(10);
    		setKarakterY(0);
    		setBaslangicX(10);
    		setBaslangicY(0);
		}
    	else if (girisKapisi.equals("C")) 
    	{
    		setKarakterX(0);
    		setKarakterY(5);
    		setBaslangicX(0);
    		setBaslangicY(5);
		}
    	else if (girisKapisi.equals("D")) 
    	{
    		setKarakterX(3);
    		setKarakterY(10);
    		setBaslangicX(3);
    		setBaslangicY(10);
		}
    	
    	super.getInfo();
    }
    

    public int getAdimIlerle() {
		return adimIlerle;
	}

	public void setAdimIlerle(int adimIlerle) {
		this.adimIlerle = adimIlerle;
	}

	/**
     * @return the dusmanID
     */
    public String getDusmanID() {
        return dusmanID;
    }

    /**
     * @param dusmanID the dusmanID to set
     */
    public void setDusmanID(String dusmanID) {
        this.dusmanID = dusmanID;
    }

    /**
     * @return the dusmanAdi
     */
    public String getDusmanAdi() {
        return dusmanAdi;
    }

    /**
     * @param dusmanAdi the dusmanAdi to set
     */
    public void setDusmanAdi(String dusmanAdi) {
        this.dusmanAdi = dusmanAdi;
    }

    public ArrayList<ArrayList<Integer>> getPath() {
		return path;
	}

	public void setPath(ArrayList<ArrayList<Integer>> path) {
		this.path = path;
	}

	/**
     * @return the dusmanTur
     */
    public String getDusmanTur() {
        return dusmanTur;
    }

    /**
     * @param dusmanTur the dusmanTur to set
     */
    public void setDusmanTur(String dusmanTur) {
        this.dusmanTur = dusmanTur;
    }

	public int getBaslangicY() {
		return baslangicY;
	}

	public void setBaslangicY(int baslangicY) {
		this.baslangicY = baslangicY;
	}

	public int getBaslangicX() {
		return baslangicX;
	}

	public void setBaslangicX(int baslangicX) {
		this.baslangicX = baslangicX;
	}
	
	@Override
	public void enKisaYol(int x, int y, int oyuncuX, int oyuncuY)
	{
		Dijkstra dj = new Dijkstra();
		setPath(dj.findPath(new Dijkstra().indexToNumber(getKarakterX(), getKarakterY()), new Dijkstra().indexToNumber(oyuncuX, oyuncuY)));
		
	}
}
