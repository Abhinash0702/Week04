package resume_screening_system;

public abstract class JobRole {
    protected String candidateName;
    protected int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public abstract void evaluateResume();

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}
