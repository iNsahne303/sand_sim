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
	
	public void run(){			// Caps Ticks and Frames per Second
		boolean running = true;
		double lastTime = System.currentTimeMillis();
		
		while(running == true){
			if((lastTime+600)<System.currentTimeMillis()){
				this.tick();
				lastTime = System.currentTimeMillis();
			}
		}
	}
	
	public void tick(){
		display.draw();
		int i = 0;
		int j = 0;
		didChange = false;
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
		if(didChange == false){
			this.running = false;
		}
	}
	
}
