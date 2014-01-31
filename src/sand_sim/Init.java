package sand_sim;

/*
 * This is the Init-Class, it's used to start the application
 */

/* 
 * As you can see in the Console, following numbers represent the following blocks:
 * 
 * 0=Air 
 * 1=Stone
 * 2=Sand
 */
public class Init {

	public static void main(String[] args) {
		Display display = new Display(15, 15);
		display.set_zero();
		display.set_test();
		
		Physic physic = new Physic(display);
		
		physic.run();

	}

}
