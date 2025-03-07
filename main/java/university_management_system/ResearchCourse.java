package university_management_system;

public class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String courseName, String department, int credits, String researchTopic) {
        super(courseName, department, credits);
        this.researchTopic = researchTopic;
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getCourseName() + " is evaluated based on research work on: " + researchTopic + ".");
    }
}
