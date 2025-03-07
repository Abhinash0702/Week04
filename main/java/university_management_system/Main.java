package university_management_system;

public class Main {
    public static void main(String[] args) {
        // Creating exam-based courses
        ExamCourse math101 = new ExamCourse("Math 101", "Mathematics", 4, 70);
        ExamCourse physics101 = new ExamCourse("Physics 101", "Science", 3, 80);

        // Creating assignment-based courses
        AssignmentCourse english201 = new AssignmentCourse("English 201", "Arts", 3, 5);
        AssignmentCourse history202 = new AssignmentCourse("History 202", "Humanities", 3, 6);

        // Creating research-based courses
        ResearchCourse aiResearch = new ResearchCourse("AI Research", "Computer Science", 5, "Machine Learning");
        ResearchCourse quantumComputing = new ResearchCourse("Quantum Computing", "Physics", 5, "Quantum Algorithms");

        // Managing courses using the generic Course class
        Course<ExamCourse> examCourseCatalog = new Course<>();
        examCourseCatalog.addCourse(math101);
        examCourseCatalog.addCourse(physics101);

        Course<AssignmentCourse> assignmentCourseCatalog = new Course<>();
        assignmentCourseCatalog.addCourse(english201);
        assignmentCourseCatalog.addCourse(history202);

        Course<ResearchCourse> researchCourseCatalog = new Course<>();
        researchCourseCatalog.addCourse(aiResearch);
        researchCourseCatalog.addCourse(quantumComputing);

        // Displaying courses from each catalog
        System.out.println("=== Exam-Based Courses ===");
        examCourseCatalog.displayCourses();

        System.out.println("\n=== Assignment-Based Courses ===");
        assignmentCourseCatalog.displayCourses();

        System.out.println("\n=== Research-Based Courses ===");
        researchCourseCatalog.displayCourses();

        // Using wildcard method to display all courses dynamically
        System.out.println("\n=== Displaying All Courses Using Wildcard ===");
        CourseUtils.displayAllCourses(examCourseCatalog.getCourses());
        CourseUtils.displayAllCourses(assignmentCourseCatalog.getCourses());
        CourseUtils.displayAllCourses(researchCourseCatalog.getCourses());
    }
}
