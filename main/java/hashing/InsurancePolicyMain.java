package hashing;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class InsurancePolicy {
    private String policyholderName;
    private LocalDate startDate;
    private LocalDate expiryDate;

    public InsurancePolicy(String policyholderName, LocalDate startDate, LocalDate expiryDate) {
        this.policyholderName = policyholderName;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policyholder: " + policyholderName + ", Start Date: " + startDate + ", Expiry Date: " + expiryDate;
    }
}

class InsurancePolicySystem {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> policyOrderMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, String> policiesSortedByExpiry = new TreeMap<>();

    // Store a new policy
    public void addPolicy(String policyNumber, InsurancePolicy policy) {
        policyMap.put(policyNumber, policy);
        policyOrderMap.put(policyNumber, policy);
        policiesSortedByExpiry.put(policy.getExpiryDate(), policyNumber);
    }

    // Retrieve a policy by its number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<String> listExpiringPolicies() {
        List<String> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Map.Entry<LocalDate, String> entry : policiesSortedByExpiry.entrySet()) {
            long daysUntilExpiry = ChronoUnit.DAYS.between(today, entry.getKey());
            if (daysUntilExpiry >= 0 && daysUntilExpiry <= 30) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<String> listPoliciesForPolicyholder(String policyholderName) {
        List<String> policiesForHolder = new ArrayList<>();
        for (Map.Entry<String, InsurancePolicy> entry : policyMap.entrySet()) {
            if (entry.getValue().getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policiesForHolder.add(entry.getKey());
            }
        }
        return policiesForHolder;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, InsurancePolicy>> iterator = policyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, InsurancePolicy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                iterator.remove();
                policiesSortedByExpiry.remove(entry.getValue().getExpiryDate());
                policyOrderMap.remove(entry.getKey());
            }
        }
    }

    // Display all policies
    public void displayPolicies() {
        System.out.println("All Policies: ");
        for (String policyNumber : policyOrderMap.keySet()) {
            System.out.println("Policy Number: " + policyNumber + ", " + policyOrderMap.get(policyNumber));
        }
    }
}

public class InsurancePolicyMain {
    public static void main(String[] args) {
        InsurancePolicySystem policySystem = new InsurancePolicySystem();

        // Create some sample policies
        InsurancePolicy policy1 = new InsurancePolicy("John Doe", LocalDate.of(2023, 1, 1), LocalDate.of(2025, 1, 1));
        InsurancePolicy policy2 = new InsurancePolicy("Jane Smith", LocalDate.of(2022, 6, 15), LocalDate.of(2023, 6, 15));
        InsurancePolicy policy3 = new InsurancePolicy("Alice Brown", LocalDate.of(2023, 3, 10), LocalDate.of(2023, 8, 10));

        // Add policies to the system
        policySystem.addPolicy("POL123", policy1);
        policySystem.addPolicy("POL124", policy2);
        policySystem.addPolicy("POL125", policy3);

        // Display all policies
        policySystem.displayPolicies();

        // Retrieve a policy by its number
        System.out.println("\nPolicy details for POL123: " + policySystem.getPolicyByNumber("POL123"));

        // List all policies expiring within the next 30 days
        System.out.println("\nPolicies expiring within the next 30 days: " + policySystem.listExpiringPolicies());

        // List policies for a specific policyholder
        System.out.println("\nPolicies for John Doe: " + policySystem.listPoliciesForPolicyholder("John Doe"));

        // Remove expired policies
        policySystem.removeExpiredPolicies();

        // Display all policies after removal
        System.out.println("\nAll policies after removing expired ones:");
        policySystem.displayPolicies();
    }
}

