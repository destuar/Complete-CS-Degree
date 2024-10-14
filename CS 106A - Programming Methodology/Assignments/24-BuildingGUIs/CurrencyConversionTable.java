/*
 * File: CurrencyConversionTable.java
 * ----------------------------------
 * This file provides a general abstraction for reading currency
 * conversion rates from a data file.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

/**
 * This class exports methods for converting from one currency to
 * another based on data from a file.
 */

public class CurrencyConversionTable {

/**
 * Constructs a new <code>CurrencyConversionTable</code> from the
 * data in the specified file.  The table consists of lines in the
 * following form:
 * 
 *<pre><code>
 *   currency=rate
 *</code></pre>
 *
 * where <code>currency</code> is the name of the currency and
 * <code>rate</code> is a floating-point value specifying the
 * equivalent value of one unit of that currency in the standard
 * currency, which is typically US Dollars, even though that is
 * nowhere enforced in the structure.
 * 
 * <p>This method throws an <code>ErrorException</code> if the
 * file cannot be found or contains data errors.
 */
	public CurrencyConversionTable(String filename) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			rateTable = new TreeMap<String,Double>();
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				int equals = line.indexOf('=');
				if (equals == -1) {
					throw new ErrorException("Missing = on exchange rate line");
				}
				String currency = line.substring(0, equals).trim();
				double rate = Double.parseDouble(line.substring(equals + 1).trim());
				rateTable.put(currency, rate);
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		} catch (NumberFormatException ex) {
			throw new ErrorException("Illegal number in data file");
		}
	}

/**
 * Returns an array of the currency names in alphabetical order.
 * 
 * @return An array of the currency names in alphabetical order
 */
	public String[] getCurrencyNames() {
		Set<String> currencies = rateTable.keySet();
		return currencies.toArray(new String[currencies.size()]);
	}

/**
 * Returns the current rate for the specified currency name.
 * If the name does not exist, this method throws an
 * <code>ErrorException</code>
 * 
 * @return An array of the currency names in alphabetical order
 */
	public double getRate(String currencyName) {
		if (!rateTable.containsKey(currencyName)) {
			throw new ErrorException("No currency named " + currencyName);
		}
		return rateTable.get(currencyName);
	}

/* Instance variables */
	private TreeMap<String,Double> rateTable;

}
