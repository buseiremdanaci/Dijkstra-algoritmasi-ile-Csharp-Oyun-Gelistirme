package prolab2.pkg1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main implements ActionListener{
	
	JButton gozBut = new JButton("Gözlüklü Þirin");
	JButton gucBut = new JButton("Güçlü Þirin");
	JFrame jf = new JFrame();
	
	public void secimEkraný()
	{
		
		JPanel jp = new JPanel();
		ImageIcon gozlukluImg = new ImageIcon("t.png");
		JLabel gozLabel = new JLabel(gozlukluImg);
		gozLabel.setBounds(-50, 32, 300, 600);
		
		ImageIcon gucluImg = new ImageIcon("g.png");
		JLabel gucLabel = new JLabel(gucluImg);
		gucLabel.setBounds(330, 32, 300, 600);
		
		ImageIcon gokyuzuImg = new ImageIcon("gt.jpg");
		JLabel gokyuzuImg1 = new JLabel(gokyuzuImg);
		gokyuzuImg1.setBounds(0, 0, 600, 600);
		
		
		JLabel bilgi = new JLabel("Oyuna Baþlamak Ýçin Þirin Seçiniz");
		bilgi.setBounds(182, 360, 250, 75);
		bilgi.setForeground(Color.white);
		bilgi.setFont(new Font("Comic Sans", Font.ITALIC, 15));
		
		jf.setSize(600,600);
		jf.setTitle("Seçim Ekraný");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		
		jp.setLayout(null);
		jp.setBackground(Color.white);
		jp.setSize(700,600);
		
		gozBut.setBounds(145, 415, 150, 50);
		gozBut.setBackground(Color.black);
		gozBut.setFont(new Font("Comic Sans", Font.ITALIC, 15));
		gozBut.setFocusable(false);
		gozBut.setForeground(Color.white);
		gozBut.addActionListener(this);
		
		
		gucBut.setBounds(305, 415, 150, 50);
		gucBut.setBackground(Color.black);
		gucBut.setFont(new Font("Comic Sans", Font.ITALIC, 15));
		gucBut.setFocusable(false);
		gucBut.setForeground(Color.white);
		gucBut.addActionListener(this);
		
		jp.add(bilgi);
		jp.add(gucLabel);
		jp.add(gucBut);
		jp.add(gozLabel);
		jp.add(gozBut);
		jp.add(gokyuzuImg1);
		jf.add(jp);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		main mn = new main();
		mn.secimEkraný();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == gozBut)
		{
			System.out.println("Gozluklu Þirin Seçildi");
			jf.setVisible(false);
			FrameOlusturma kListen = new FrameOlusturma(0);
			
		}
		else if (e.getSource() == gucBut) 
		{
			System.out.println("Güçlü Þirin Seçildi");
			jf.setVisible(false);
			FrameOlusturma kListen = new FrameOlusturma(1);
		}
	}

}
