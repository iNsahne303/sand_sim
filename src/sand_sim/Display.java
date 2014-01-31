package sand_sim;
/*
 * This is the Display-class, it contains and displays the field
 * 
 */
public class Display {
	
	int[][] feld;
	int y_length;
	int x_length;
	int n;
	
	Display(int i, int j, int n) {
		feld = new int[i+1][j+1];
		y_length = i+1;
		x_length = j+1;
		this.n = n;
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
