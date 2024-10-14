/*
 * File: TeachingMachine.java
 * --------------------------
 * This program executes a programmed instruction course.
 */

import acm.program.*;
import acm.util.*;

public class TeachingMachine extends ConsoleProgram {

	public void run() {
		TMCourse course = readCourseFile();
		stepThroughCourse(course);
	}

/**
 * Prompts the user for a course name and then reads in the
 * data for that course from the associated data file.  If the
 * <code>TMCourse</code> constructor signals an error, the
 * user is asked to supply a new course name.
 *
 * @return A <code>TMCourse</code> object for the desired course
 */
	private TMCourse readCourseFile() {
		while (true) {
			try {
				String courseName = readLine("Enter course name: ");
				return new TMCourse(courseName + ".txt");
			} catch (ErrorException ex) {
				println(ex.getMessage());
			}
		}
	}

/**
 * Steps through the questions in the order specified by the course.
 *
 * @param course A <code>TMCourse</code> object for the desired course
 */
	private void stepThroughCourse(TMCourse course) {
		println(course.getTitle());
		int questionNumber = 1;
		while (questionNumber != 0) {
			TMQuestion question = course.getQuestion(questionNumber);
			if (question == null) {
				throw new ErrorException("Missing question " + questionNumber);
			}
			for (String line : question.getQuestionText()) {
				println(line);
			}
			String answer = readLine();
			int nextQuestion = question.lookupAnswer(answer);
			if (nextQuestion == -1) {
				println("I don't understand that response.");
			} else {
				questionNumber = nextQuestion;
			}
		}
		println("Done");
	}

}

