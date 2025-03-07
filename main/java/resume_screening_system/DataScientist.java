package resume_screening_system;

public class DataScientist extends JobRole {
    private boolean knowsMachineLearning;

    public DataScientist(String candidateName, int experienceYears, boolean knowsMachineLearning) {
        super(candidateName, experienceYears);
        this.knowsMachineLearning = knowsMachineLearning;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating Data Scientist Resume:");
        System.out.println("Candidate: " + candidateName + ", Experience: " + experienceYears + " years");
        System.out.println("Machine Learning Knowledge: " + (knowsMachineLearning ? "Yes" : "No"));
        System.out.println("✔ Eligible: " + (experienceYears >= 3 && knowsMachineLearning));
    }
}

