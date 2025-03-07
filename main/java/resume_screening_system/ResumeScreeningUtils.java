package resume_screening_system;

import java.util.List;

public class ResumeScreeningUtils {
    public static void processAllResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.evaluateResume();
            System.out.println("--------------------------------");
        }
    }

    public static <T extends JobRole> void evaluateSingleResume(T resume) {
        System.out.println("\nEvaluating Resume for: " + resume.getCandidateName());
        resume.evaluateResume();
        System.out.println("✅ Screening Complete.");
    }
}

