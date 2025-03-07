package resume_screening_system;

public class SoftwareEngineer extends JobRole {
    private String primaryProgrammingLanguage;

    public SoftwareEngineer(String candidateName, int experienceYears, String primaryProgrammingLanguage) {
        super(candidateName, experienceYears);
        this.primaryProgrammingLanguage = primaryProgrammingLanguage;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating Software Engineer Resume:");
        System.out.println("Candidate: " + candidateName + ", Experience: " + experienceYears + " years");
        System.out.println("Primary Language: " + primaryProgrammingLanguage);
        System.out.println("✔ Eligible: " + (experienceYears >= 2 && primaryProgrammingLanguage.equalsIgnoreCase("Java")));
    }
}
