package prolab2.pkg1;

import java.util.ArrayList;

public abstract class Obje 
{
	private ArrayList<Obje> objects = new ArrayList<Obje>();
	ArrayList<Integer> objectLocation = new ArrayList<Integer>();
	public abstract void objeUret(ArrayList<Integer> location);
	
	private int location;
	private int objeX;
	private int objeY;
	private int puan;
	
	public Obje()
	{
		
	}
	
	/// Get ve Set Metotlarý
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public ArrayList<Obje> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Obje> objects) {
		this.objects = objects;
	}

	public int getObjeX() {
		return objeX;
	}

	public void setObjeX(int objeX) {
		this.objeX = objeX;
	}

	public int getObjeY() {
		return objeY;
	}

	public void setObjeY(int objeY) {
		this.objeY = objeY;
	}

	public int getPuan() {
		return puan;
	}

	public void setPuan(int puan) {
		this.puan = puan;
	}

}
