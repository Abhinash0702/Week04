package university_management_system;

import java.util.ArrayList;
import java.util.List;

public class Course<T extends CourseType> {
    private List<T> courseList;

    public Course() {
        this.courseList = new ArrayList<>();
    }

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getCourses() {
        return courseList;
    }

    public void displayCourses() {
        for (T course : courseList) {
            System.out.println(course);
            course.displayEvaluationMethod();
        }
    }
}
