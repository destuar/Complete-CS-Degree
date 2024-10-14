import acm.program.*;

public class TestLocalizer extends ConsoleProgram {

	public static void main(String[] args) {
		new TestLocalizer().start(args);
	}

	public void run() {
		Localizer myLocalizer = new Localizer("Localizations.txt");
		println("myLocalizer.localize(\"Open\",�\"de\") -> " +
				myLocalizer.localize("Open", "de"));
		println("myLocalizer.localize(\"Open\",�\"fr\") -> " +
				myLocalizer.localize("Open", "fr"));
		println("myLocalizer.localize(\"Open\",�\"es\") -> " +
				myLocalizer.localize("Open", "es"));
		println("myLocalizer.localize(\"Close\",�\"de\") -> " +
				myLocalizer.localize("Close", "de"));
		println("myLocalizer.localize(\"OK\",�\"de\") -> " +
				myLocalizer.localize("OK", "de"));
		println("myLocalizer.localize(\"OK\",�\"fr\") -> " +
				myLocalizer.localize("OK", "fr"));
	}

}
