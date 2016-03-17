package lesson1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

public class HouseSingleMethod extends Applet{
	
	/** 
	 * 
	 *	Name: Benjamin DosSantos 
	 *	Assignment: Loops - Objects
	 *	Project Description: a.	The Loop project creates 
	 *  a pre-drawn house made of different Graphics draw calls.
	 *  The houses are generated 10 times at random x and y 
	 *  positions between (0,0) and (screen_width, screen_height). 
	 * 
	 **/
	
	Color bgcolor = Color.GREEN;
	static Random ran = new Random();
	
	static Graphics g;
	
	public void init(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screen_width = (int)(screenSize.getWidth());
		int screen_height = (int)(screenSize.getHeight());
		
		this.setSize(new Dimension(screen_width, screen_height));
		this.setBackground(bgcolor);
		
	}
	
	public void paint(Graphics graphics){
		this.g = graphics;
		drawHouse();
	}// End of paint method
	
	public static void drawHouse(){
		int Base_x = 100,
			Base_y = 200;

		
		for(int count = 0; count <= 10; count++){
			
			
			Base_x = ran.nextInt(1000);
			Base_y = ran.nextInt(1000);
			
			int House_big_rect_x = Base_x,
			House_big_rect_y = Base_y - 100,	// Originally 	House_big_rect_y = Base_y,
			House_big_rect_w = 300,
			House_big_rect_h = 300,
			House_roof_x = Base_x,
			House_roof_y = Base_y - 200,
			House_roof_w = 300,
			House_roof_h = 200,
			House_roof_start_angle = 0,
			House_roof_arc_length = 180,
			House_door_x = Base_x + 100,
			House_door_y = Base_y,		// Originally Base_y + 100;
			House_door_w = 100,
			House_door_h = 200,
			Door_window_x = Base_x + 100,
			Door_window_y = Base_y, 	// Originally Door_window_y = Base_y + 100,
			Door_window_w = 100,
			Door_window_h = 100,
			Window_vert_x1 = Base_x + 150,	
			Window_vert_y1 = Base_y,		// Originally 100
			Window_vert_x2 = Base_x + 150,
			Window_vert_y2 = Base_y + 100,	// Originally 200
			Window_horiz_x1 = Base_x + 100,	
			Window_horiz_y1 = Base_y + 50,	// Originally 150
			Window_horiz_x2 = Base_x + 200,
			Window_horiz_y2 = Base_y + 50;	// Originally 150
			
			Color housebase = Color.BLUE;
			Color roof = Color.GRAY;
			Color door = Color.CYAN;
			Color window = Color.MAGENTA;
			Color windowCross = Color.YELLOW;
			
			g.setColor(housebase);
			g.fillRect(House_big_rect_x, House_big_rect_y, House_big_rect_w, House_big_rect_h);
			
			g.setColor(roof);
			g.fillArc(House_roof_x, House_roof_y, House_roof_w, House_roof_h, House_roof_start_angle, House_roof_arc_length);
			
			g.setColor(door);
			g.fillRect(House_door_x, House_door_y, House_door_w, House_door_h);
			
			g.setColor(window);
			g.fillOval(Door_window_x, Door_window_y, Door_window_w, Door_window_h);
			
			g.setColor(windowCross);
			g.drawLine(Window_vert_x1, Window_vert_y1, Window_vert_x2, Window_vert_y2);
			g.drawLine(Window_horiz_x1, Window_horiz_y1, Window_horiz_x2, Window_horiz_y2);
	
		}// End of for 10
	}// End of drawHouse method
	
}// End of class
