/*
 * File: TMQuestion.java
 * ---------------------
 * This file defines a class to represent a single question.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

/** 
 * This class models a single question in the course data base.
 */

class TMQuestion {

/**
 * Creates a new question by reading its data from the specified reader.
 * If no data is left in the reader, this method returns <code>null</code>
 * instead of an <code>TMQuestion</code> value.  Note that this is a
 * static method, which means that you need to call
 *
 *<pre><code>
 *     TMQuestion.readQuestion(rd)
 *</code></pre>
 *
 * @param rd The reader from which the question data is read 
 */

	public static TMQuestion readQuestion(BufferedReader rd) {
		try {
			String line = rd.readLine();
			if (line == null) return null;
			TMQuestion question = new TMQuestion();
			question.questionNumber = Integer.parseInt(line);
			question.questionText = new ArrayList<String>();
			while (true) {
				line = rd.readLine();
				if (line.equals(MARKER)) break;
				question.questionText.add(line);
			}
			question.answerTable = new HashMap<String,Integer>();
			while (true) {
				line = rd.readLine();
				if (line == null || line.length() == 0) break;
				parseAnswerLine(question, line);
			}
			return question;
		} catch (IOException ex) {
			throw new ErrorException(ex);
		} catch (NumberFormatException ex) {
			throw new ErrorException("Illegal question number");
		}
	}

/**
 * Returns the number of this question.
 */
	public int getQuestionNumber() {
		return questionNumber;
	}

/**
 * Returns an ArrayList containing the text for this question.
 */
	public ArrayList<String> getQuestionText() {
		return questionText;
	}

/**
 * Looks up the answer in the table of possible answers for this question.
 * If a match is found, the number of the associated next question is
 * returned.  If not, the method returns -1.
 */
	public int lookupAnswer(String answer) {
		Integer value = answerTable.get(answer.toUpperCase());
		if (value == null) return -1;
		return value;
	}

/**
 * This method scans the answer line to separate the text of the answer
 * from the number of the next question.  The value of the next question
 * is entered into the HashMap stored as part of this TMQuestion structure.
 */
	private static void parseAnswerLine(TMQuestion question, String line) {
		int colon = line.indexOf(":");
		if (colon == -1) {
			throw new ErrorException("Missing colon in " + line);
		}
		String response = line.substring(0, colon).toUpperCase().trim();
		int nextQuestion = Integer.parseInt(line.substring(colon + 1).trim());
		question.answerTable.put(response, new Integer(nextQuestion));
	}

/* Private constants */
	private static String MARKER = "-----";

/* Instance variables */
	private int questionNumber;
	private ArrayList<String> questionText;
	private HashMap<String,Integer> answerTable;
}
