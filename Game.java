import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		// System objects
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();

		// Game variables
		String[] enemies = {"Skeleton", "Zombie", "Mummy", "Fallen Angel", "Dragon", "Robot"};
		int maxEnemyHealth = 300;
		int enemyAttackDamage = 50;

		// Player variables
		int health = 500;
		int attackDmg = 50;
		int numHealthPots = 3;
		int healthPotionHealAmount = 50;
		int healthPotionDropChance = 50; // Percentage

		boolean running = true;
		
		System.out.println("-----------------------------------");

		System.out.println("Welcome to Hell!");

		// Label
		GAME:
		while (running) {
			System.out.println("-----------------------------------");

			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");

			while (enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run");

				String input = scanner.nextLine();
				if (input.equals("1")) {
					int damageDealt = rand.nextInt(attackDmg);
					int damageTaken = rand.nextInt(enemyAttackDamage);

					enemyHealth -= damageDealt;
					health -= damageTaken;

					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage!");
					System.out.println("\t> You recieved " + damageTaken + " in retaliation!");

					if (health < 1) {
						System.out.println("\t You have taken too much damage, you are too weak to go on!");
						break;
					}
				} else if (input.equals("2")) {

					if (numHealthPots > 0) {
						health += healthPotionHealAmount;
						numHealthPots--;
						System.out.println("\t> You drank a health potion, healed for: " + healthPotionHealAmount + "."
								+ "\n\t> You now have " + health + " HP."
								+ "\n\t> You now have " + numHealthPots + " health potions left.\n");
					} else {
						System.out.println("\t> You have no health potions, defeat enemies for a chance to get one!");
					}

				} else if (input.equals("3")) {
					System.out.println("\t> You ran away from the " + enemy + "!");
					continue GAME;
				} else {
					System.out.println("\tInvalid command!");
				}
			}
			if (health < 1) {
				System.out.println("You are too weak for battle!");
				break;
			}
			System.out.println("-------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + " HP left # ");
			// If the random number is less than 50 it drops.
			if (rand.nextInt(100) < healthPotionDropChance) {
				numHealthPots++;
				System.out.println(" # The " + enemy + " dropped a health potion. # ");
				System.out.println(" # You now have " + numHealthPots + " health potion(s). # ");
			}
			System.out.println("--------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit Hell");
			String input = scanner.nextLine();

			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid command!");
				input = scanner.nextLine();
				scanner.close();

			}
			if (input.equals("1")) {
				System.out.println("You continue your adventure.");
			} else if (input.equals("2")) {
				System.out.println("You exited Hell.");
				break;
			}
		}
		System.out.println("######################");
		System.out.println("# THANKS FOR PLAYING #");
		System.out.println("######################");
	}
}

