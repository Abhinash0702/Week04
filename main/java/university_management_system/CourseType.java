package university_management_system;

public abstract class CourseType {
    private String courseName;
    private String department;
    private int credits;

    public CourseType(String courseName, String department, int credits) {
        this.courseName = courseName;
        this.department = department;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public int getCredits() {
        return credits;
    }

    public abstract void displayEvaluationMethod();

    @Override
    public String toString() {
        return courseName + " (" + department + ", " + credits + " credits)";
    }
}

