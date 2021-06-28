package prolab2.pkg1;


import javax.swing.JFrame;

public class FrameOlusturma{
	
	JFrame jf = new JFrame();
	
	
	public FrameOlusturma(int secim) 
	{
		OyunAlani p = new OyunAlani(secim);
		jf.setSize(1200,1125);
		jf.setTitle("Oyun Alaný");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		
		jf.add(p);
		jf.addKeyListener(p);
		jf.setVisible(true);	
	}

}
