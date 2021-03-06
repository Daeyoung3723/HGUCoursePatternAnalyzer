package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	public String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};
	// total number of students
	private int numOfStudents;
	
	// total number of courses
	private int numOfCourses;
	
	// save student list from the lines
	private Student[] students;
	
	// save course list from the lines
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = new Student[numOfStudents];
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = new Course[numOfCourses];
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int k = 0;
		students[k++] = new Student(lines[0].split(",")[1].trim());
		for(String line: lines) {
			Student student = new Student(line.split(",")[1].trim());
			if(studentExist(students, student)) {
				continue;
			} else {
				students[k++] = new Student(student.getName());;
			}
		}
		
		return students;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		for(Student stu: students) {
			if(stu == null) {
				break;
			}
			if(student.getName().equals(stu.getName())) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int k = 0;
		courses[k++] = new Course(lines[0].split(",")[2].trim());
		for(String line: lines) {
			Course course = new Course(line.split(",")[2].trim());
			if(courseExist(courses, course)) {
				continue;
			} else {
				courses[k++] = new Course(course.getCourseName());
			}
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		for(Course stu: courses) {
			if(stu == null) {
				break;
			}
			if(course.getCourseName().equals(stu.getCourseName())) {
				return true;
			}
		}

		return false;
	}

}
