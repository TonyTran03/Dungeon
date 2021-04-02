import java.awt.*;
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
			System.out.println("Z. Wake up?");
			System.out.println("X. Sleep");
			char temp = scan.nextLine().toUpperCase().charAt(0);

			if (temp == 'Z') {
				clearScreen();
				System.out.println("\033[0;33m" + "You woke up." + "\033[0m");
				whileTrue = false;
			} else if (temp == 'X') {
				clearScreen();
				System.out.println("You can't be sleeping, there's adevnture waiting to happen!");
			} else {
				System.out.println("");
				clearScreen();
			}
		}

		System.out.println(
				"\"You're not from Rehtta, are you, bud? Got a name?\" \n\n What is your name? (Cannot be changed later)");
		specialCharacter protagonist = new specialCharacter(scan.nextLine()); // created a new object called
																				// 'protagonist' to have a name and base
																				// stats
		clearScreen();
		System.out.println("\033[0;33m" + protagonist.getName() + "\033[0m" + " Could you be... Ahhhh! A Slime.");
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
				System.out.println("\033[0;33m" + protagonist.getName() + "\033[0m");
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
		combat.fight(protagonist, 0);

		whileTrue = true;
		while (whileTrue == true) {
			int counter = 0;
			trigger();
			switch (counter) {
			case 1:
				System.out.println("You hit your foot off the wall");
				System.out.println("Empty...");
				break;
			case 2:
				combat.fight(protagonist);
				break;
			case 3:
				break;
			}
		}
	}

	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	// while loop this to keep triggering events
	public static int trigger() {
		Random ran = new Random();
		int counter = 0;
		int encounter = ran.nextInt(100);

		// do nothing
		if ((encounter <= 50) && (encounter >= 0)) {
			counter = 1;
			return counter;
		}
		// fight a monster
		else if ((encounter > 50) && (encounter <= 75)) {
			counter = 2;
			return counter;
			// find a chest
		} else if ((encounter > 75) && (encounter < 90)) {
			counter = 3;
			return counter;
			// boss
		} else {
			counter = 4;
			return counter;
		}
	}
}