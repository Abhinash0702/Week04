package university_management_system;

public class AssignmentCourse extends CourseType {
    private int assignmentCount;

    public AssignmentCourse(String courseName, String department, int credits, int assignmentCount) {
        super(courseName, department, credits);
        this.assignmentCount = assignmentCount;
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getCourseName() + " is evaluated based on " + assignmentCount + " assignments.");
    }
}
