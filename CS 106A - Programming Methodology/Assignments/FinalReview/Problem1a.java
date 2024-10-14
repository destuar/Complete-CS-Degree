import acm.program.*;

public class Problem1a extends ConsoleProgram {

	public static void main(String[] args) {
		new Problem1a().start(args);
	}

	public void run() {
		practice1();
		println();
		practice2();
	}
	
	public void practice1() {
		println("Practice final 1:");
		int[] list = { 10, 20, 30, 40, 50 };
		mystery(list);
		println("list = " + arrayToString(list));
	}

	public void practice2() {
		println("Practice final 2:");
		int[] array = new int[13];
		for (int i = 1; i <= 12; i++) {
			for (int j = i; j > 0; j--) {
				array[j] += j;
			}
		}
		println("array = " + arrayToString(array));
	}

	private void mystery(int[] array) {
		int tmp = array[array.length - 1];
		for (int i = 1; i < array.length; i++) {
			array[i] = array[i - 1];
		}
		array[0] = tmp;
	}
	
	private String arrayToString(int[] array) {
		String str = "{";
		for (int i = 0; i < array.length; i++) {
			if (i > 0) str += ",";
			str += " " + array[i];
		}
		str += " }";
		return str;
	}

}
