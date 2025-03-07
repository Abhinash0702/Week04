package resume_screening_system;

public class Main {
    public static void main(String[] args) {
        // Creating job role instances
        SoftwareEngineer se1 = new SoftwareEngineer("Alice Johnson", 4, "Java");
        SoftwareEngineer se2 = new SoftwareEngineer("Bob Smith", 1, "Python");

        DataScientist ds1 = new DataScientist("Charlie Brown", 5, true);
        DataScientist ds2 = new DataScientist("David White", 2, false);

        ProductManager pm1 = new ProductManager("Emma Davis", 6, 3);
        ProductManager pm2 = new ProductManager("Frank Green", 4, 1);

        // Creating Resume Processors
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        softwareEngineerResumes.addResume(se1);
        softwareEngineerResumes.addResume(se2);

        Resume<DataScientist> dataScientistResumes = new Resume<>();
        dataScientistResumes.addResume(ds1);
        dataScientistResumes.addResume(ds2);

        Resume<ProductManager> productManagerResumes = new Resume<>();
        productManagerResumes.addResume(pm1);
        productManagerResumes.addResume(pm2);

        // Processing each category
        System.out.println("\n=== Software Engineer Resumes ===");
        softwareEngineerResumes.processResumes();

        System.out.println("\n=== Data Scientist Resumes ===");
        dataScientistResumes.processResumes();

        System.out.println("\n=== Product Manager Resumes ===");
        productManagerResumes.processResumes();

        // Using wildcard method to process all resumes together
        System.out.println("\n=== Processing All Resumes Dynamically ===");
        ResumeScreeningUtils.processAllResumes(softwareEngineerResumes.getResumes());
        ResumeScreeningUtils.processAllResumes(dataScientistResumes.getResumes());
        ResumeScreeningUtils.processAllResumes(productManagerResumes.getResumes());

        // Evaluating a single resume dynamically
        System.out.println("\n=== Evaluating a Single Resume ===");
        ResumeScreeningUtils.evaluateSingleResume(se1);
    }
}
