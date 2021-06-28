package prolab2.pkg1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class OyunAlani extends JPanel implements KeyListener
{
	int[][] harita = new Dijkstra().getKoor();
	int x = 75;
	int y = 150;
	boolean oyuncuHareketEttiMi = false;
	
	JLabel skor = new JLabel("Skor : 0");
	ArrayList<Color> colors = new ArrayList<Color>();
	Oyuncu oyuncu;
	ArrayList<Dusman> dusmanlar = new ArrayList<Dusman>();
	ArrayList<ImageIcon> altinImageIconList = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> mantarImageIconList = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> dusmanImageIconList = new ArrayList<ImageIcon>();
	
	Obje altin = new Altin();
	Obje mantar = new Mantar();
	Timer timer = new Timer();
	
	TimerTask mantarTask = new TimerTask() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(!oyuncu.OyunBittiMi())
			{
				mantar.objeUret(altin.objectLocation);
				repaint();
			}
		}
	};
	
	TimerTask altinTask = new TimerTask() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(!oyuncu.OyunBittiMi())
			{
				altin.objeUret(mantar.objectLocation);
				repaint();
			}
		}
	};
	
	public void startTime()
	{
		timer.schedule(mantarTask, 5000,7000);
		timer.schedule(altinTask, 3000,6000);
		
	}
	
	public OyunAlani(int karakterSecim)
	{
		if(karakterSecim == 0)
		{
			System.out.println("Gozluklu þirin baþarýyla ulaþtý");
			oyuncu = new Gozluklu("Player 1" , "Gözlüklü Þirin",6,5);
		}
		else if(karakterSecim == 1) 
		{
			System.out.println("Güçlü þirin baþarýyla ulaþtý");
			oyuncu = new Guclu("Player 2" , "Güçlü Þirin",6,5);
		}
		
		this.setBackground(Color.black);
		try 
		{
			FileReader flRead = new FileReader("harita.txt");
			BufferedReader bfReader = new BufferedReader(flRead);
			String Satir;
			
			while(true)
			{
				Satir = bfReader.readLine();
				if(Satir == null)
					break;
				else 
				{
					if(Satir.startsWith("Karakter"))
					{
						String karakter;
						karakter = Satir.split(":")[1].split(",")[0];
						if(karakter.equals("Gargamel"))							
							dusmanlar.add(new Gargamel("Enemy", Satir.split(":")[1].split(",")[0], Satir.split(":")[2]));
						else if(karakter.equals("Azman"))						
							dusmanlar.add(new Azman("Enemy", Satir.split(":")[1].split(",")[0], Satir.split(":")[2]));
						else {
							System.out.println("else");
						}
						System.out.println(Satir.split(":")[1].split(",")[0]);
					}
				}
			}
			
			bfReader.close();
			flRead.close();
		} 
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			System.out.println("Hata satýr : 111");
		}
		colors.add(Color.yellow);
		colors.add(Color.green);
		colors.add(Color.cyan);
		colors.add(Color.magenta);
		startTime();
	}
	
	public void enemyMove()
	{
		for(int j = 0; j < dusmanlar.size(); j++)
		{
			try {
				for(int i = 0; i < dusmanlar.get(j).getAdimIlerle(); i++)
				{
					dusmanlar.get(j).enKisaYol(x, y,oyuncu.getKarakterX(),oyuncu.getKarakterY());
					dusmanlar.get(j).setKarakterY(dusmanlar.get(j).getPath().get(0).get(0));
					dusmanlar.get(j).setKarakterX(dusmanlar.get(j).getPath().get(0).get(1));
					oyuncuHareketEttiMi = false;
					repaint();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			repaint();
		}
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(!oyuncu.OyunBittiMi())
		{
			for(int i = 0; i < 11; i++)
			{
				for(int j = 0; j < 13; j++)
				{
					if(harita[i][j] == 0)
						g.setColor(Color.darkGray);
					else 
						g.setColor(Color.white);
					
					g.fillRect(x, y, 75, 75);
					x += 75;				
				}
				y += 75;
				x = 75;
			}
			
			x = 75;
			y = 150;
			for(int i = 0; i < 10; i++)
			{
				y += 75;
				g.setColor(Color.black);
				g.drawLine(x, y, x + 13 * 75, y);	
			}
			
			x = 75;
			y = 150;
			for(int i = 0; i < 12; i++)
			{
				x += 75;
				g.setColor(Color.black);
				g.drawLine(x, y, x, y + 11 * 75);
			}
			
			x = 75;
			y = 150;
			
			g.setColor(Color.red);
			g.fillRect(x + 3 * 75, y, 75, 75);
			g.fillRect(x + 10 * 75, y, 75, 75);
			g.fillRect(x, y + 5 * 75, 75, 75);
			g.fillRect(x + 3 * 75, y + 10 * 75, 75, 75);
			
			g.setColor(Color.green);
			g.fillRect(x + 12 * 75, y + 7 * 75, 75, 75);
			
			g.setColor(Color.blue);
			g.fillRect(x + 6 * 75, y + 5 * 75, 75, 75);
			
			drawPath(g);
			
			g.drawImage(new ImageIcon(oyuncu.getOyuncuTUR() + ".png").getImage(), oyuncu.getKarakterX() * 75 + x, oyuncu.getKarakterY() * 75 + y, null);
			
			for(int dusmanSayisi = 0; dusmanSayisi < dusmanlar.size(); dusmanSayisi++)
			{
				dusmanImageIconList.add(new ImageIcon(dusmanlar.get(dusmanSayisi).getDusmanTur() + ".png"));
				g.drawImage(dusmanImageIconList.get(dusmanSayisi).getImage(), dusmanlar.get(dusmanSayisi).getKarakterX() * 75 + x, dusmanlar.get(dusmanSayisi).getKarakterY() * 75 + y, null);	
				
			}
			
			for(int mantarSayisi = 0; mantarSayisi < mantar.getObjects().size(); mantarSayisi++)
			{
				mantarImageIconList.add(new ImageIcon(mantar.getClass().getSimpleName() + ".png"));
				g.drawImage(mantarImageIconList.get(mantarSayisi).getImage(), mantar.getObjects().get(mantarSayisi).getObjeX() * 75 + x, mantar.getObjects().get(mantarSayisi).getObjeY() * 75 + y, null);
			}
			
			for(int altinSayisi = 0; altinSayisi < altin.getObjects().size(); altinSayisi++)
			{
				altinImageIconList.add(new ImageIcon(altin.getClass().getSimpleName() + ".png"));
				g.drawImage(altinImageIconList.get(altinSayisi).getImage(), altin.getObjects().get(altinSayisi).getObjeX() * 75 + x, altin.getObjects().get(altinSayisi).getObjeY() * 75 + y, null);
			}
			
			g.drawImage(new ImageIcon("Sirine.png").getImage(), 12 * 75 + x, 7 * 75 + y, null);
			
			skor.setText("Skor : " + oyuncu.getSkor());
			skor.setBounds(1000, 10, 200, 100);
			skor.setFocusable(false);
			skor.setForeground(Color.gray);
			skor.setBackground(Color.black);
			skor.setFont(new Font(" " , Font.ITALIC, 25));
			this.setLayout(null);
			this.add(skor);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();	
		try {
			switch (key) {
				case KeyEvent.VK_UP: 
				{
					for(int i = 0; i < oyuncu.getAdimIlerle(); i++)
					{
						if(harita[oyuncu.getKarakterY() - 1][oyuncu.getKarakterX()] == 1)
						{
							oyuncu.setKarakterY(oyuncu.getKarakterY() - 1);
							oyuncuHareketEttiMi = true;
							objectYakaladiMi();
							repaint();
						}
					}
					break;
				}
				
				case KeyEvent.VK_DOWN: 
				{
					for(int i = 0; i < oyuncu.getAdimIlerle(); i++)
					{
						if(harita[oyuncu.getKarakterY() + 1][oyuncu.getKarakterX()] == 1)
						{
							oyuncu.setKarakterY(oyuncu.getKarakterY() + 1);
							oyuncuHareketEttiMi = true;
							objectYakaladiMi();
							repaint();
						}
					}
					break;
				}
				
				case KeyEvent.VK_LEFT: 
				{
					for(int i = 0; i < oyuncu.getAdimIlerle(); i++)
					{
						if(harita[oyuncu.getKarakterY()][oyuncu.getKarakterX() - 1] == 1)
						{
							oyuncu.setKarakterX(oyuncu.getKarakterX() - 1);
							oyuncuHareketEttiMi = true;
							objectYakaladiMi();
							repaint();
						}
					}
					break;
				}
				
				case KeyEvent.VK_RIGHT: 
				{
					for(int i = 0; i < oyuncu.getAdimIlerle(); i++)
					{
						if(harita[oyuncu.getKarakterY()][oyuncu.getKarakterX() + 1] == 1)
						{
							oyuncu.setKarakterX(oyuncu.getKarakterX() + 1);
							oyuncuHareketEttiMi = true;
							objectYakaladiMi();
							repaint();
						}
					}
					break;
				}
			}
		}
		catch (Exception e2) {
			// TODO: handle exception
			
		}
		
		if(oyuncuHareketEttiMi)
		{
			enemyMove();
			for(int i = 0; i < dusmanlar.size();i++)
			{
				if(yakalandiMi(i))
				{
					System.out.println("Yakalandýn!");
					dusmanlar.get(i).setKarakterX(dusmanlar.get(i).getBaslangicX());
					dusmanlar.get(i).setKarakterY(dusmanlar.get(i).getBaslangicY());
					oyuncu.skorAzalt(dusmanlar.get(i).getDusmanTur());
				}
				if(oyuncu.OyunBittiMi())
				{
					this.remove(skor);
					System.out.println("Oyun Bitti!");
					oyuncu.oyunuBitir();
					break;
				}
			}
			oyuncu.PuaniGoster();
		}
	}
	
	public boolean yakalandiMi(int index)
	{
		if(dusmanlar.get(index).getKarakterX() == oyuncu.getKarakterX() && dusmanlar.get(index).getKarakterY() == oyuncu.getKarakterY())
		{
			return true;
		}
		return false;
	}
	
	public void objectYakaladiMi()
	{
		for(int i = 0; i < mantar.getObjects().size(); i++)
		{
			if(mantar.getObjects().get(i).getObjeX() == oyuncu.getKarakterX() && mantar.getObjects().get(i).getObjeY() == oyuncu.getKarakterY())
			{
				System.out.println("Mantar yedi");
				mantar.getObjects().remove(i);
				oyuncu.setSkor(oyuncu.getSkor() + mantar.getPuan());
			}
		}
		for(int i = 0; i < altin.getObjects().size(); i++)
		{
			if(altin.getObjects().get(i).getObjeX() == oyuncu.getKarakterX() && altin.getObjects().get(i).getObjeY() == oyuncu.getKarakterY())
			{
				System.out.println("Altýn yakaladý");
				altin.getObjects().remove(i);
				oyuncu.setSkor(oyuncu.getSkor() + altin.getPuan());
			}
		}
	}
	
	public void drawPath(Graphics g)
	{
		for (int j = 0; j < dusmanlar.size(); j++) 
		{
			g.setColor(colors.get(j));
			for (int i = 1; i < dusmanlar.get(j).getPath().size() - 1; i++) 
			{
				g.fillRect(x + dusmanlar.get(j).getPath().get(i).get(1) * 75 + 1, y + dusmanlar.get(j).getPath().get(i).get(0) * 75 + 1, 74, 74);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
