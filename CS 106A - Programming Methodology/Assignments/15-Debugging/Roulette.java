/*
 * File: Roulette.java
 * -------------------
 * This program simulates a small part of the casino game of
 * roulette.
 */

import acm.program.*;
import acm.util.*;

public class Roulette extends ConsoleProgram {

/** Amount of cash with which the player starts */
	private static final int STARTING_MONEY = 100;

/** Amount wagered in each game */
	private static final int WAGER_AMOUNT = 10;

/** Runs the program */
	public void run() {
		giveInstructions();
		rgen.setSeed(1);
		playRoulette();
	}

/**
 * Plays roulette until the user runs out of money.
 */
	private void playRoulette() {
		int money = STARTING_MONEY;
		while (money > 0) {
			println("You now have $" + money + ".");
			String bet = readLine("Enter betting category: ");
			int outcome = spinRouletteWheel();
			if (isWinningCategory(outcome, bet)) {
				println("That number is " + bet + " so you win.");
				money += WAGER_AMOUNT;
			} else {
				println("That number is not " + bet + " so you lose.");
				money -= WAGER_AMOUNT;
			}
		}
		println("You ran out of money.");
	}

/**
 * Simulates the spinning of the roulette wheel.  The method
 * returns the number of the slot into which the ball fell.
 */
	private int spinRouletteWheel() {
		int r = rgen.nextInt(0, 36);
		println("The ball lands in " + r + ".");
		return r;
	}

/*
 * Returns true if the outcome matches the category specified
 * by bet.  If the player chooses an illegal betting
 * category, this function always returns false.
 */
	private boolean isWinningCategory(int outcome, String bet) {
		if (bet.equalsIgnoreCase("odd")) {
			return outcome % 2 == 1;
		} else if (bet.equalsIgnoreCase("even")) {
			return (outcome % 2 == 0 && outcome != 0);
		} else if (bet.equalsIgnoreCase("low")) {
			return (1 <= outcome && outcome <= 18);
		} else if (bet.equalsIgnoreCase("high")) {
			return (19 <= outcome && outcome <= 36);
		} else {
			return (false);
		}
	}

/**
 * Welcomes the player to the game and gives instructions on
 * the rules of roulette.
 */
	private void giveInstructions() {
		println("Welcome to the roulette table!");
		println("Roulette is played with a large wheel divided into");
		println("compartments numbered from 0 to 36.  Each player");
		println("places bets on a large playing field marked with the");
		println("numbers on the wheel and various categories.  In this");
		println("game, the only legal bets are the following categories:");
		println("odd, even, low, or high.  Note that 0 is not in any");
		println("of these categories.  After the bet is placed, the");
		println("wheel is spun, and a marble is dropped inside,");
		println("which bounces around until it lands in a compartment.");
		println("If the compartment matches the betting category you");
		println("chose, you win back your wager plus an equal amount.");
		println("If not, you lose your wager.");
	}

/* Private instance variables */

	private RandomGenerator rgen = new RandomGenerator();
}
