import java.io.*;
import java.util.*;

public class storyBoard {
	public static void startScreen() {
		Scanner scan = new Scanner(System.in);
		try {
			File plot = new File("story.txt");
			Scanner plot1 = new Scanner(plot);
			String line = plot1.nextLine();
			System.out.println(line);
		} catch (FileNotFoundException er) {
			System.out.println("File not Found");
		}

		boolean whileTrue = true;
		while (whileTrue == true) {
			System.out.println("Z. Sleep");
			System.out.println("X. Wake up?");
			char temp = scan.nextLine().toUpperCase().charAt(0);

			if (temp == 'X') {
				clearScreen();
				System.out.println("\033[0;33m" + "You woke up." + "\033[0m");
				whileTrue = false;
			} else if (temp == 'Z') {
				clearScreen();
				System.out.println("You can't be sleeping, there's adevnture waiting to happen!");
			} else {
				System.out.println("");
				clearScreen();
			}
		}

		System.out.println(
				"\"You're not from Germany, are you, bud? Got a name?\" \n\n What is your name? (Cannot be changed later)");
		// created a new object called 'protagonist' to have a name and base stats
		specialCharacter protagonist = new specialCharacter(scan.nextLine());
		clearScreen();
		System.out.println("\033[0;33m" + protagonist.name + "\033[0m" + " Could you be... Ahhhh! A Slime.");
		System.out.println("Roll for your stats and fend off the slime\n\nZ. New stats\nX. Done");
		protagonist.statrolls(); // .statrolls can be found in specialCharater
		protagonist.printStatReroll();
		whileTrue = true;
		while (whileTrue == true) {
			char temp = scan.nextLine().toUpperCase().charAt(0);
			if (temp == 'Z') {
				clearScreen();
				System.out.println("Z. Roll For your Stats");
				System.out.println("X. Done");
				protagonist.statrolls();
				protagonist.printStatReroll();

			} else if (temp == 'X') {
				clearScreen();
				System.out.println("\033[0;33m" + protagonist.name+ "\033[0m");
				protagonist.printStat();
				whileTrue = false;
				System.out.println("\nStats saved!");
				try {
					Thread.sleep(3000); // wait 3 seconds
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				clearScreen();
			} else {
				clearScreen();
				System.out.println("Roll For your Stats with Z; press X when you're done\n\nCurrent stats: \n");
				protagonist.printStatReroll();
			}

		}
	

		// specialCharacter protagonist = new specialCharacter("Tony");
		// protagonist.testing();
		//TODO: remove later ^^^
		
		boolean notLose = true;
		if(notLose == true){
			notLose = protagonist.engage(0); //first fight is forced to be a slime. Passing in String, int
		}
		else{
			Main.main(new String[2]);
		}
		clearScreen();
		System.out.println("Thank you for saving me! You're one you're own\n"); //TODO FIX PLOT LOL
	
		try {
			Thread.sleep(2000); //wait 2 seconds
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		boolean path = true;
		while (path == true) {
		clearScreen();
	
		System.out.println("\033[0;33m" + protagonist.name+ "\033[0m");
		protagonist.printStat(); //display users stats before venturing
		System.out.println("x. Explore");
		scan = new Scanner(System.in);
		String stalls = scan.nextLine();

			int counter = 0;
			counter = trigger();
			switch (counter) {
			case 1:
				System.out.println("You hit your foot off the wall");
				System.out.println("Empty...");
				break;
			case 2:
				protagonist.engage (-999); //fight random enemy from creature class
				break;
			case 3:
				System.out.println("There will be new spells to Learn in the future");
				break;		
			case 4:
				protagonist.engage (4); //fight boss
				break;
			}

		}
	}

	// while loop this to keep triggering events
	public static int trigger() {
		Random ran = new Random();
		int counter = 0;
		int encounter = ran.nextInt(100);

		
		if ((encounter >= 0) && (encounter <= 10)) {// do nothing (10%)
			counter = 1;
		}
	
		else if ((encounter > 10) && (encounter <= 75)) {	// fight a monster(65%)
			counter = 2;
			
		}else if ((encounter > 75) && (encounter < 80)) {// find a chest (5%)
			counter = 3;
			
		} else {
			counter = 4; // boss(20%) -> Demo purpose. Running is an option because of the demo.
		}
		return counter;
	}
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}