import acm.program.*;

public class TwoPair extends ConsoleProgram {

	public static void main(String[] args) {
		new TwoPair().start(args);
	}

	public void run() {
		testTwoPair(new int[] { 1, 2, 3, 4, 5 });
		testTwoPair(new int[] { 1, 1, 3, 4, 5 });
		testTwoPair(new int[] { 1, 1, 3, 3, 5 });
		testTwoPair(new int[] { 1, 5, 3, 1, 5 });
		testTwoPair(new int[] { 1, 1, 1, 4, 4 });
		testTwoPair(new int[] { 2, 2, 2, 2, 6 });
	}
	
	private void testTwoPair(int[] dice) {
		print("checkTwoPairCategory({ ");
		for (int i = 0; i < 5; i++) {
			if (i > 0) print(", ");
			print(i);
		}
		print(" }) -> ");
		println(checkTwoPairCategory(dice));
	}

	private boolean checkTwoPairCategory(int[] dice) {
		int[] counts = new int[6 + 1];
		for (int i = 0; i < 5; i++) {
			counts[dice[i]]++;
		}
		int pairCount = 0;
		for (int i = 1; i <= 6; i++) {
			if (counts[i] == 2) pairCount++;
		}
		return pairCount == 2;
	}

}
