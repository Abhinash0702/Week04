package resume_screening_system;

public class ProductManager extends JobRole {
    private int managedProjects;

    public ProductManager(String candidateName, int experienceYears, int managedProjects) {
        super(candidateName, experienceYears);
        this.managedProjects = managedProjects;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating Product Manager Resume:");
        System.out.println("Candidate: " + candidateName + ", Experience: " + experienceYears + " years");
        System.out.println("Projects Managed: " + managedProjects);
        System.out.println("✔ Eligible: " + (experienceYears >= 5 && managedProjects >= 2));
    }
}
