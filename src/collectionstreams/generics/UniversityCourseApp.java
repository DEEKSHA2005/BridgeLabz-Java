package collectionstreams.generics;

import java.util.ArrayList;
import java.util.List;


abstract class CourseType {

    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }


    public abstract void evaluationMethod();
}


class ExamCourse extends CourseType {

    public ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluationMethod() {
        System.out.println(getCourseName() + " - Evaluation: Written Exam");
    }
}

class AssignmentCourse extends CourseType {

    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluationMethod() {
        System.out.println(getCourseName() + " - Evaluation: Assignments");
    }
}

class ResearchCourse extends CourseType {

    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluationMethod() {
        System.out.println(getCourseName() + " - Evaluation: Research Project");
    }
}


class Course<T extends CourseType> {

    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }
}


class CourseUtil {


    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.evaluationMethod();
        }
    }
}


public class UniversityCourseApp {

    public static void main(String[] args) {


        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics"));
        examCourses.addCourse(new ExamCourse("Physics"));


        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Software Engineering"));
        assignmentCourses.addCourse(new AssignmentCourse("Data Structures"));


        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("Artificial Intelligence"));
        researchCourses.addCourse(new ResearchCourse("Machine Learning"));

        System.out.println("---- Exam Courses ----");
        CourseUtil.displayCourses(examCourses.getCourses());

        System.out.println("\n---- Assignment Courses ----");
        CourseUtil.displayCourses(assignmentCourses.getCourses());

        System.out.println("\n---- Research Courses ----");
        CourseUtil.displayCourses(researchCourses.getCourses());
    }
}
