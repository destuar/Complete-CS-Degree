/* FILE: Problem4.java
 * ----------------------
 * This program contains the required method mostFrequentKmer that
 * returns the Kmer found most often in a given DNA sequence.
 * A "K-mer" is a length-K subsequence of DNA bases, where K is
 * a specified value.
 */

import acm.program.*;
import java.util.*;

public class Problem4 extends ConsoleProgram {
	
	// For testing only
	public void run() {
		println(mostFrequentKmer("KRBOORBOKRB", 3));
		println(mostFrequentKmer("BOBOK", 2));
	}
	
	private String mostFrequentKmer(String dnaString, int k) {
		// Build a map of kmers to frequencies
		HashMap<String, Integer> kmerCounts = new HashMap<>();

		for (int i = 0; i < dnaString.length() - k + 1; i++) {
			String currentKmer = dnaString.substring(i, i + k);
			
			// Update the count for this in our map
			int currentVal = 0;
			if (kmerCounts.containsKey(currentKmer)) {
				currentVal = kmerCounts.get(currentKmer);
			}
			kmerCounts.put(currentKmer, currentVal + 1);
		}

		// Find the most frequent kmer
		int maxCount = 0;
		String mostFrequentKmer = "";
		for (String kmer : kmerCounts.keySet()) {
			if (kmerCounts.get(kmer) > maxCount) {
				maxCount = kmerCounts.get(kmer);
				mostFrequentKmer = kmer;
			}
		}

		return mostFrequentKmer;
	}

}
