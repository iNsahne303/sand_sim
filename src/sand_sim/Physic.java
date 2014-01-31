package sand_sim;
/*
 * This is the Physic-class, it gets the field-content and "simulates" the falling sand
 * 
 */
import java.util.Scanner;

public class Physic {
	double waitMillis = 600;		// Amount of Milliseconds to wait between ticks
	boolean running = false;
	private Display display;
	int x_length;
	int y_length;
	int[][] feld;
	boolean didChange;
	int n;
	
	Physic(Display display){
		this.display = display;
		x_length = display.x_length;
		y_length = display.y_length;
		this.n = display.n;
	}
	
	public void init(){				// Fills the array with the user input
		Scanner user_input = new Scanner(System.in);
		int i=1;
		int j=1;
		feld = display.feld;
		String temp;
		
		for(i=1;i<=n;i++){
				temp=user_input.next();
				for(j=1;j<=n;j++){
					feld[i][j] = temp.charAt(j-1) - '0';
			}
		}
		user_input.close();
	}
	
	public void run(){				// Caps Ticks and Frames per Second
		boolean running = true;
		double lastTime = System.currentTimeMillis();
		
		
		while(running == true){
			if((lastTime+waitMillis)<System.currentTimeMillis()){// Ticks once if more than x Milliseconds have past since the last tick
				running = this.tick();// Ticks the game and stops the while-loop when no block got moved
				lastTime = System.currentTimeMillis();// Reset lastTime
			}
		}
	}
	
	public boolean tick(){			// Calls display.draw() and moves every sandblock once
		display.draw();
		int i = 0;
		int j = 0;
		didChange = false;			// Boolean to test if there was at least one block that moved
		feld = display.feld;
		
		for(i=n-1;i>=1;i--){
			for(j=1;j<=n;j++){
				if(feld[i][j]==2 && feld[i+1][j]==0){
					feld[i][j]=0;
					feld[i+1][j]=2;
					display.setFeld(feld);
					didChange = true;
				}
			}
		}
		return didChange;			// If no block got moved, this will return false and stop physic.run() 
	}
	
}
