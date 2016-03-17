package lesson1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

public class Project8 extends Applet{
	
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
	
	static Color housebase = Color.BLUE;
	static Color roof = Color.GRAY;
	static Color door = Color.CYAN;
	static Color window = Color.MAGENTA;
	static Color windowCross = Color.YELLOW;
	static Color doorKnob = Color.BLACK;
	
	static int baseWidth = 300,
			   baseHeight = 300,
			   roofWidth = 300,
			   roofHeight = 200,
			   roofStartAngle = 0,
			   roofEndAngle = 180,
			   doorWidth = 100, 
			   doorHeight = 200, 
			   windowWidth = 100, 
			   windowHeight = 100, 
			   GrilleLength = 100,
			   knobWidth = 10,
			   knobHeight = 10;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int screen_width = (int)(screenSize.getWidth());
	static int screen_height = (int)(screenSize.getHeight());
	
	public void init(){
		this.setSize(new Dimension(screen_width, screen_height));
		this.setBackground(bgcolor);
		
	}
	
	public void paint(Graphics graphics){
		this.g = graphics;
		
		int times = 10;
		
		for(int i = 0; i <= times; i++){
			
			int xPos = ran.nextInt(screen_width);
			int yPos = ran.nextInt(screen_height);
			
			drawHouse(xPos, yPos);
		}
	}// End of paint method

	public static void drawHouseNoRoof(int Base_x, int Base_y){		
		drawBase(Base_x, Base_y, baseWidth, baseHeight);
		drawDoor(Base_x, Base_y, doorWidth, doorHeight);
		drawWindow(Base_x, Base_y, windowWidth, windowHeight, GrilleLength);
	}// End of drawHouse method
	
	public static void drawHouseNoWindow(int Base_x, int Base_y){
		drawBase(Base_x, Base_y, baseWidth, baseHeight);
		drawRoof(Base_x, Base_y, roofWidth, roofHeight, roofStartAngle, roofEndAngle);
		drawDoor(Base_x, Base_y, doorWidth, doorHeight);
		drawCross(Base_x, Base_y, GrilleLength);
	}// End of drawHouse method
	
	public static void drawHouseNoDoorNoRoof(int Base_x, int Base_y){
		drawBase(Base_x, Base_y, baseWidth, baseHeight);
		drawWindow(Base_x, Base_y, windowWidth, windowHeight, GrilleLength);
	}// End of drawHouse method
	
	public static void drawHouse(int Base_x, int Base_y){	
		drawBase(Base_x, Base_y, baseWidth, baseHeight);
		drawRoof(Base_x, Base_y, roofWidth, roofHeight, roofStartAngle, roofEndAngle);
		drawDoor(Base_x, Base_y, doorWidth, doorHeight);
		drawWindow(Base_x, Base_y, windowWidth, windowHeight, GrilleLength);
	}// End of drawHouse method
	
	public static void drawBase(int Base_x, int Base_y, int house_Width, int house_Height){
		int House_big_rect_x = Base_x,
			House_big_rect_y = Base_y - 100,	// Originally 	House_big_rect_y = Base_y,
			House_big_rect_w = house_Width,
			House_big_rect_h = house_Height;
		
		g.setColor(housebase);
		g.fillRect(House_big_rect_x, House_big_rect_y, House_big_rect_w, House_big_rect_h);
	}// End of drawBase
	
	public static void drawRoof(int Base_x, int Base_y, int roof_Width, int roof_Height, int roof_Start_Angle, int roof_Arc_Length){
		int House_roof_x = Base_x,
			House_roof_y = Base_y - 200,
			House_roof_w = roof_Width,
			House_roof_h = roof_Height,
			House_roof_start_angle = roof_Start_Angle,
			House_roof_arc_length = roof_Arc_Length;
		
		g.setColor(roof);
		g.fillArc(House_roof_x, House_roof_y, House_roof_w, House_roof_h, House_roof_start_angle, House_roof_arc_length);
	}//End of drawRoof

	public static void drawDoor(int Base_x, int Base_y, int door_Width, int door_Height){
		int House_door_x = Base_x + 100,
			House_door_y = Base_y,		// Originally Base_y + 100;
			House_door_w = door_Width,
			House_door_h = door_Height;
		
		g.setColor(door);
		g.fillRect(House_door_x, House_door_y, House_door_w, House_door_h);
		drawDoorKnob(Base_x, Base_y, 10, 10);
	}//End of drawDoor
	
	public static void drawDoorKnob(int Base_x, int Base_y, int knob_Width, int knob_Height){
		int knob_xPos = Base_x + 185,
			knob_yPos = Base_y + 100,
			knob_width = knob_Width,
			knob_height = knob_Height;
		
		g.setColor(doorKnob);
		g.fillOval(knob_xPos, knob_yPos, knob_width, knob_height);
	}// End of drawDoorKnob

	public static void drawWindow(int Base_x, int Base_y, int window_Width, int window_Height, int length){
		drawGlass(Base_x, Base_y, window_Width, window_Height);
		drawCross(Base_x, Base_y, length);
	}//End of drawWindow
	
	public static void drawGlass(int Base_x, int Base_y, int window_Width, int window_Height){
		int Door_window_x = Base_x + 100,
			Door_window_y = Base_y, 	// Originally Door_window_y = Base_y + 100,
			Door_window_w = window_Width,
			Door_window_h = window_Height;
		
		g.setColor(window);
		g.fillOval(Door_window_x, Door_window_y, Door_window_w, Door_window_h);
	}//End of drawWindow

	public static void drawCross(int Base_x, int Base_y, int length){
		drawVreticalGrille(Base_x, Base_y, length);
		drawHorizontalGrille(Base_x, Base_y, length);
	}//End of drawCross
	
	public static void drawVreticalGrille(int Base_x, int Base_y, int length){
		int Window_vert_x1 = Base_x + 150,	
				Window_vert_y1 = Base_y,		// Originally 100
				Window_vert_x2 = Base_x + 150,
				Window_vert_y2 = Base_y + length;	// Originally 200
		g.setColor(windowCross);
		g.drawLine(Window_vert_x1, Window_vert_y1, Window_vert_x2, Window_vert_y2);
	}// End of drawVerticalGrille
	
	public static void drawHorizontalGrille(int Base_x, int Base_y, int length){
		int Window_horiz_x1 = Base_x + 100,	
			Window_horiz_y1 = Base_y + 50,	// Originally 150
			Window_horiz_x2 = Base_x + 100 + length,
			Window_horiz_y2 = Base_y + 50;	// Originally 150
		g.setColor(windowCross);
		g.drawLine(Window_horiz_x1, Window_horiz_y1, Window_horiz_x2, Window_horiz_y2);
	}// End of drawHorizontalGrille
}// End of class
