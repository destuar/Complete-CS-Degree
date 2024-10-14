/*
 * File: TMCourse.java
 * -------------------
 * This class defines the data structure for a course for use with
 * the TeachingMachine program.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class TMCourse {

/**
 * Creates a new course for the teaching machine by reading the
 * data in the specified file.  The file format for the data is
 * defined in Handout #56 ("Data-Driven Programs").
 *
 * @param filename The name of the data file
 */

	public TMCourse(String filename) {
		questions = new TreeMap<Integer,TMQuestion>();
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			title = rd.readLine();
			while (true) {
				TMQuestion question = TMQuestion.readQuestion(rd);
				if (question == null) break;
				questions.put(question.getQuestionNumber(), question);
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException("Can't open " + filename);
		}
	}

/**
 * Returns the title of the course.
 *
 * @return The title of the course
 */
	public String getTitle() {
		return title;
	}

/**
 * Returns the question corresponding to a particular question
 * number, or <code>null</code> if no such question exists.
 * 
 * @param number The question number
 * @return The <code>TMQuestion</code> object with that number
 */
	public TMQuestion getQuestion(int number) {
		return questions.get(number);
	}

/* Instance variables */

	private String title;
	private Map<Integer,TMQuestion> questions;

}
