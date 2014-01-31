package sand_sim;

public class Physic {
	int tickrate = 60;
	boolean running = false;
	private Display display;
	int x_length;
	int y_length;
	int[][] feld;
	boolean didChange;
	
	Physic(Display display){
		this.display = display;
		x_length = display.x_length;
		y_length = display.y_length;
	}
	
	public void run(){				// Caps Ticks and Frames per Second
		boolean running = true;
		double lastTime = System.currentTimeMillis();
		double waitMillis = 600;// Amount of Milliseconds to wait between ticks
		
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
		
		for(i=y_length-1;i>=1;i--){
			for(j=1;j<x_length;j++){
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
