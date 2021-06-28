/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg1;

public abstract class Karakter {

    private String karakterID;
    private String karakterAD;
    private String tur;
    private int karakterX;
    private int karakterY;
    
    abstract void enKisaYol(int x, int y, int oyuncuX, int oyuncuY);
    
	public Karakter()
	{
		 
    }
	
	public void getInfo()
	{
		System.out.println("Karakter oluþturuldu");
		System.out.println("Karakter ID : " + karakterID);
		System.out.println("Karakter Adý : " + karakterAD);
		System.out.println("Karakter Türü : " + tur);
	}
	
	///Get ve Set metotlarý
    public String getKarakterID() {
        return karakterID;
    }

    public void setKarakterID(String karakterID) {
        this.karakterID = karakterID;
    }

    public String getKarakterAD() {
        return karakterAD;
    }

    public void setKarakterAD(String karakterAD) {
        this.karakterAD = karakterAD;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
	public int getKarakterX() {
		return karakterX;
	}
	public void setKarakterX(int karakterX) {
		this.karakterX = karakterX;
	}
	public int getKarakterY() {
		return karakterY;
	}
	public void setKarakterY(int karakterY) {
		this.karakterY = karakterY;
	}

}
