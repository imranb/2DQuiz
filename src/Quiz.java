import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*; 
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Kuiz i thjeshtë 
 * 
 * @author Imran Berisha
 * @version 1.0
 */

@SuppressWarnings("serial")
public class Quiz extends JPanel implements MouseListener{
	
	// konstruktori
	public Quiz(){
	addMouseListener(this);
	}

	static String s[] = new String[100];		// numri i rreshtave ne txt file
	static int start = 0;						
	static int fillimi,fundi;
	static String pergjigja;
	static int t1 = 0;		// klikimi i 'butonit' (false)	
	static int t2 = 0;		// stringu ne txt file (true)
	
	
	// ngjyrat
	static Color color = new Color(207, 228, 127);	
	static Color colord = new Color(230, 212, 58);		
	static Color color1 = new Color(230, 212, 58);		
	static Color color2 = new Color(230, 212, 58);
	static Color color3 = new Color(230, 212, 58);
	static Color color4 = new Color(230, 212, 58);
	static Color color5 = new Color(65, 132, 143);
	
	static int rezultati = 0;		// numri i pergjigjeve te sakta
	static int gabim = 0;			// numri i pergjigjeve te gabuara
	
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		// prapavija (background)
		Color c1 = new Color(0x86BBEA);
		Color c2 = new Color(0x3093C7);
		GradientPaint backgroundgradient = new GradientPaint(this.getWidth()/2, this.getHeight()/2, c1,
															 this.getWidth()/2, 0, c2);
		g2d.setPaint(backgroundgradient);
		g2d.fillRect(0, 0, getWidth(), getHeight());		
		
		// path-i i txt file-it
		String filePath = "C:/Users/Imran Berisha/workspace/Loja2D/src/QuizQuestions.txt";
		// leximi i txt file-it
		try {
		    LineNumberReader lineReader = new LineNumberReader(new FileReader(filePath));
		    String lineText;

		    while ((lineText = lineReader.readLine()) != null) {
		        int lineNumber = lineReader.getLineNumber();
		        s[lineNumber - 1] = lineText.toString();
		
	        }
		   		 
		    lineReader.close();
		} catch (IOException ex) {
		    System.err.println(ex);
		}
		
		if(t2 == 0){			// nese true vizatohen, ngjyrosen e mbushen katroret
			
			RoundRectangle2D roundedRectangle1 = new RoundRectangle2D.Float(90, 75, 650, 50, 18, 18);
			RoundRectangle2D roundedRectangle2 = new RoundRectangle2D.Float(230, 200, 350, 40, 18, 18);
			RoundRectangle2D roundedRectangle3 = new RoundRectangle2D.Float(230, 260, 350, 40, 18, 18);
			RoundRectangle2D roundedRectangle4 = new RoundRectangle2D.Float(230, 320, 350, 40, 18, 18);
			RoundRectangle2D roundedRectangle5 = new RoundRectangle2D.Float(230, 380, 350, 40, 18, 18);
			RoundRectangle2D roundedRectangle6 = new RoundRectangle2D.Float(400, 460, 180, 40, 18, 18);
			
			g2d.setColor(new Color(110, 207, 225));
			g2d.draw(roundedRectangle1);
			g2d.draw(roundedRectangle2);
			g2d.draw(roundedRectangle3);
			g2d.draw(roundedRectangle4);
			g2d.draw(roundedRectangle5);
			g2d.draw(roundedRectangle6);
			
			g2d.setColor(color);
			g2d.fill(roundedRectangle1);
			g2d.setColor(color1);
			g2d.fill(roundedRectangle2);
			g2d.setColor(color2);
			g2d.fill(roundedRectangle3);
			g2d.setColor(color3);
			g2d.fill(roundedRectangle4);
			g2d.setColor(color4);
			g2d.fill(roundedRectangle5);
			g2d.setColor(color5);
			g2d.fill(roundedRectangle6);
			
			// fonti i pyetjeve
			Font f = new Font("Trebuchet MS", Font.PLAIN, 18);
			g2d.setColor(Color.DARK_GRAY);
			g2d.setFont(f);
	
			g2d.drawString(s[start], 95, 105);		// vizatimi i stringjeve te pyetjeve
	
			int shtesa = 0;
			fillimi = start + 1;
			fundi = start + 5;
			pergjigja = s[start + 5];
			
			for(int i = fillimi;i<fundi;i++){
				
				// fonti i opsioneve
				Font f1 = new Font("Trebuchet MS", Font.BOLD, 20);
				g2d.setColor(Color.DARK_GRAY);
				g2d.setFont(f1);
				
				g2d.drawString(s[i], 235, 225 + shtesa);	// vizatimi i stringjeve te opsioneve
				
				shtesa = shtesa + 60;
			}
			
			g2d.drawString("Next", 457, 488);		// stringu Next
		}
		
		if(t2 == 1){		// nese perfunduan pyetjet, paraqet rezultatin
			
			Font f = new Font("Sans Serif", Font.ITALIC, 50);
			g2d.setColor(new Color(37, 37, 47));
			g2d.setFont(f);
			
			g2d.drawString("Loja përfundoi", 240, 150);
			
			Font f2 = new Font("Sans Serif", Font.PLAIN, 40);
			g2d.setColor(new Color(9, 77, 48));
			g2d.setFont(f2);
			
			g2d.drawString("Pergjigjet", 90, 250);
			g2d.drawString("e sakta: ", 100, 290);
			g2d.drawString(""+rezultati, 155, 340);
			
			g2d.drawString("Pergjigjet", 505, 250);
			g2d.drawString("e gabuara: ", 500, 290);
			g2d.drawString(""+gabim, 580, 340);
		}
	}
	
	// main per testim
	public static void main(String []args){
		
		
		JFrame frame = new JFrame("Kuizi");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().add(new Quiz());
		frame.setAlwaysOnTop(true);
	}

	// inicializimi i klikimit te mausit
	@Override
	public void mouseClicked(MouseEvent e) {
		int string = new Integer(pergjigja).intValue();	  // numer qe tregon cila eshte pergjigja e sakte ne txt file
		
		
		if(e.getX()> 400 && e.getX() < 580 && e.getY()>460 && e.getY() < 500){		// nese klikohet next
			if(s[start + 6] != null){
			start = start + 6;
			color1 = colord;
			color2 = colord;
			color3 = colord;
			color4 = colord;
			t1 = 0;
			}else{
				t2 = 1;
			}
		}

	
		if(t1 == 0){
			if(e.getX()> 230 && e.getX() < 580 && e.getY()>200 && e.getY() < 240){		// nese klikohet a)
				if(string == 1){
					color1 = Color.GREEN;
					rezultati++;
					t1 = 1;
				}else{
					color1 = Color.RED;
					gabim++;
					t1 = 1;
				}
			}
			if(e.getX()> 230 && e.getX() < 580 && e.getY()>260 && e.getY() < 300){	// nese klikohet b)
				if(string == 2){
					color2 = Color.GREEN;
					rezultati++;
					t1 = 1;
				}else{
					color2 = Color.RED;
					gabim++;
					t1 = 1;
				}
			}
			if(e.getX()> 230 && e.getX() < 580 && e.getY()>320 && e.getY() < 360){	// nese klikohet c)
				if(string == 3){
					color3 = Color.GREEN;
					rezultati++;
					t1 = 1;
				}else{
					color3 = Color.RED;
					gabim++;
					t1 = 1;
				}
			}
			if(e.getX()> 230 && e.getX() < 580 && e.getY()>380 && e.getY() < 420){	// nese klikohet d)
				if(string == 4){
					color4 = Color.GREEN;
					rezultati++;
					t1 = 1;
				}else{
					color4 = Color.RED;
					gabim++;
					t1 = 1;
				}
			}
		
		}
		
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
