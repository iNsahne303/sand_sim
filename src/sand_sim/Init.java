package sand_sim;

import java.util.Scanner;

/*
 * This is the Init-Class, it's used to start the application
 */

/* 
 * As you can see in the Console, following numbers represent the following blocks:
 * 0=Air 
 * 1=Stone
 * 2=Sand
 */
public class Init {

	public static void main(String[] args) {
		int n;
		Scanner user_input = new Scanner(System.in);
																// Sets field-size & creates display-object+field
		System.out.print("Field X by X, choose X: ");
		n = user_input.nextInt();
		Display display = new Display(n, n, n);
		display.set_zero();
																//	Creates physic-object and starts the "simulation"
		Physic physic = new Physic(display);
		physic.init();
		physic.run();
		user_input.close();
		System.out.println("\n\nTerminating application...done");// Prints exit message
	}
}
