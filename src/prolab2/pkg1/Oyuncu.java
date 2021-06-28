package prolab2.pkg1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Oyuncu extends Karakter{
    private String oyuncuID;
    private String oyuncuAdi;
    private String oyuncuTUR;
    private int Skor; 
    private int puanDusmeYuzde;
    private int adimIlerle;
    abstract void skorAzalt(String karakterTur);
    
   
	public Oyuncu()
	{
    
    }
	
    public Oyuncu(String karakterId,String karakterAdi)
    {
    	super();
        setKarakterID(karakterId);
        setKarakterAD(karakterAdi);
        setTur("Oyuncu"); 
        super.getInfo();
    }
    
	public void PuaniGoster()
    {
    	System.out.println(getSkor());
    }
	
	public boolean OyunBittiMi()
	{
		if(getSkor() <= 0)
		{
			return true;
		}
		else if(getKarakterX() == 12 && getKarakterY() == 7)
		{
			return true;
		}
		return false;
	}
	
	@Override
	void enKisaYol(int x, int y, int oyuncuX, int oyuncuY) 
	{
		System.out.println(this.getClass().getSimpleName() + " Sýnýfý için En Kýsa Yol metodu kullanýlamýyor!");
	}
	
	public void oyunuBitir()
	{
		JFrame jframe = new JFrame();
		JPanel jf = new JPanel();
		
		jframe.setSize(500,320);
		jframe.setTitle("Oyun Bitti");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jf.setLayout(null);
		
		
		JLabel skor = new JLabel("Skor : " + getSkor());
		
		if(getSkor() <= 0)
		{
			JLabel oyunBitti = new JLabel("Kaybettin!");
			oyunBitti.setBounds(130, 135, 250, 150);
			oyunBitti.setForeground(Color.white);
			oyunBitti.setFont(new Font("Comic Sans" , Font.BOLD, 45));
			
			skor.setBounds(160, 180, 250, 150);
			skor.setForeground(Color.white);
			skor.setFont(new Font("Comic Sans" , Font.BOLD, 30));
			
			ImageIcon kaybetImg = new ImageIcon("kaybet.jpeg");
			JLabel kaybetImg1 = new JLabel(kaybetImg);
			kaybetImg1.setBounds(0, -20, 500, 300);
			
			jf.setBackground(Color.black);
			jf.add(oyunBitti);
			jf.add(skor);
			jf.add(kaybetImg1);
			
		}
		else if(getSkor() > 0)
		{
			JLabel oyunBitti = new JLabel("Kazandýn!");
			oyunBitti.setBounds(130, 135, 250, 150);
			oyunBitti.setForeground(Color.white);
			oyunBitti.setFont(new Font("Comic Sans" , Font.BOLD, 45));
			
			skor.setBounds(160, 180, 250, 150);
			skor.setForeground(Color.white);
			skor.setFont(new Font("Comic Sans" , Font.BOLD, 30));
			
			ImageIcon kazanImg = new ImageIcon("kazan.jpeg");
			JLabel kazanImg1 = new JLabel(kazanImg);
			kazanImg1.setBounds(0, -10, 500, 300);
			
			jf.setBackground(Color.white);
			jf.add(oyunBitti);
			jf.add(skor);
			jf.add(kazanImg1);
		}
		
		jframe.add(jf);
		jframe.setVisible(true);
	}
	
	
	///Get ve Set Metotlarý
	public int getAdimIlerle() {
			return adimIlerle;
	}
	public void setAdimIlerle(int adimIlerle) {
			this.adimIlerle = adimIlerle;
	}
	
	public int getPuanDusmeYuzde() {
		return puanDusmeYuzde;
	}
	public void setPuanDusmeYuzde(int puanDusmeYuzde) {
		this.puanDusmeYuzde = puanDusmeYuzde;
	}

    public String getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(String oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public String getOyuncuTUR() {
        return oyuncuTUR;
    }

    public void setOyuncuTUR(String oyuncuTUR) {
        this.oyuncuTUR = oyuncuTUR;
    }

    public int getSkor() {
        return Skor;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    } 
}
