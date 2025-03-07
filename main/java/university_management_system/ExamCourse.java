package university_management_system;

public class ExamCourse extends CourseType {
    private int examWeightage;

    public ExamCourse(String courseName, String department, int credits, int examWeightage) {
        super(courseName, department, credits);
        this.examWeightage = examWeightage;
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getCourseName() + " is evaluated based on exams (" + examWeightage + "% weightage).");
    }
}
