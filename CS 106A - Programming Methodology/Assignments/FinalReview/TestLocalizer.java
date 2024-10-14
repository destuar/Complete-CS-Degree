import acm.program.*;

public class TestLocalizer extends ConsoleProgram {

	public static void main(String[] args) {
		new TestLocalizer().start(args);
	}

	public void run() {
		Localizer myLocalizer = new Localizer("Localizations.txt");
		println("myLocalizer.localize(\"Open\",Ê\"de\") -> " +
				myLocalizer.localize("Open", "de"));
		println("myLocalizer.localize(\"Open\",Ê\"fr\") -> " +
				myLocalizer.localize("Open", "fr"));
		println("myLocalizer.localize(\"Open\",Ê\"es\") -> " +
				myLocalizer.localize("Open", "es"));
		println("myLocalizer.localize(\"Close\",Ê\"de\") -> " +
				myLocalizer.localize("Close", "de"));
		println("myLocalizer.localize(\"OK\",Ê\"de\") -> " +
				myLocalizer.localize("OK", "de"));
		println("myLocalizer.localize(\"OK\",Ê\"fr\") -> " +
				myLocalizer.localize("OK", "fr"));
	}

}
