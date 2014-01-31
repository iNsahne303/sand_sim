package sand_sim;

public class Display {
	
	int[][] feld;
	int y_length;
	int x_length;
	
	Display(int i, int j) {
		feld = new int[i+1][j+1];
		y_length = i+1;
		x_length = j+1;
	}
	
	public void set_zero() {		// Sets every coordinate in "feld" to zero
		int i = 0;
		int j = 0;

		for(i=1;i<y_length;i++){
			for(j=1;j<x_length;j++){
				feld[i][j] = 0;
			}
		}
	}
	
	public void set_test() {		// Sets blocks into "feld" for testing purpose
		for(int i=1;i<=15;i++){
			feld[15][i]=1;
		}
		feld[12][5] = 1;
		feld[12][8] = 1;
		feld[11][9] = 1;
		
		feld[2][2] = 2;
		feld[3][4] = 2;
		feld[4][5] = 2;
		feld[1][5] = 2;
		feld[4][1] = 2;
		feld[7][3] = 2;
		feld[8][1] = 2;
		feld[7][8] = 2;
		feld[9][9] = 2;
		feld[2][10] = 2;
	} 
	
	public void draw() {			// Draws the content of "feld" on the screen
		int i = 1;
		int j = 1;
		
		System.out.print("  ");		
		for(i=1;i<y_length;i++){
			System.out.print(" \n  |");
			for(j=1;j<x_length;j++){
				System.out.print(" " + feld[i][j] + " |");
			}
			System.out.print("\n  ");
		}
		System.out.println(" \n\n  ");
	}
	
	public int[][] getFeld() {
		return feld;
	}

	public void setFeld(int[][] feld) {
		this.feld = feld;
	}
	
}
