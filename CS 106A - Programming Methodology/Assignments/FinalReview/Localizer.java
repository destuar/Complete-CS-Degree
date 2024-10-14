import acm.util.*;
import java.io.*;
import java.util.*;

/**
 * This class localizes strings for an internationalized application.
 */
public class Localizer {

/**
 * Creates a new Localizer from the data in the specified file.
 */
	public Localizer(String filename) {
		map = new HashMap<String,String>();
		try {
			BufferedReader rd
			  = new BufferedReader(new FileReader(filename));
			String word = null;
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				int equalSign = line.indexOf('=');
				if (equalSign == -1) {
					word = line;
				} else {
					String language = line.substring(0, equalSign);
					String translation = line.substring(equalSign + 1);
					map.put(word + "+" + language, translation);
				}
			}
		} catch (Exception ex) {
			throw new ErrorException(ex);
		}
	}

/**
 * Looks up the localization of the English word.
 */
	public String localize(String word, String language) {
		String key = word + "+" + language;
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return word;
		}
	}

/* Private instance variables */
	private HashMap<String,String> map;

}
