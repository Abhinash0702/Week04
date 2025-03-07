import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "[Policy Number: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate +
                ", Coverage: " + coverageType + ", Premium: $" + premiumAmount + "]";
    }
}

public class InsurancePolicyManagementSystem {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Policies (HashSet - Unordered): " + hashSet);
        System.out.println("\nAll Policies (LinkedHashSet - Insertion Order): " + linkedHashSet);
        System.out.println("\nAll Policies (TreeSet - Sorted by Expiry Date): " + treeSet);
    }

    public void displayExpiringSoon() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date next30Days = cal.getTime();

        System.out.println("\nPolicies Expiring Soon (Within 30 Days):");
        for (Policy policy : treeSet) {
            if (!policy.getExpiryDate().after(next30Days)) {
                System.out.println(policy);
            }
        }
    }

    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        System.out.println("\nDuplicate Policies:");
        for (Policy policy : linkedHashSet) {
            if (!seen.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem manager = new InsurancePolicyManagementSystem();

        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.MARCH, 10);
        manager.addPolicy(new Policy("P001", "Alice", cal.getTime(), "Health", 1200.50));

        cal.set(2024, Calendar.FEBRUARY, 15);
        manager.addPolicy(new Policy("P002", "Bob", cal.getTime(), "Auto", 900.00));

        cal.set(2024, Calendar.MARCH, 5);
        manager.addPolicy(new Policy("P003", "Charlie", cal.getTime(), "Home", 1500.75));

        cal.set(2024, Calendar.APRIL, 20);
        manager.addPolicy(new Policy("P004", "David", cal.getTime(), "Health", 800.25));

        // Duplicate Policy
        cal.set(2025, Calendar.MARCH, 10);
        manager.addPolicy(new Policy("P001", "Alice", cal.getTime(), "Health", 1200.50));

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayPoliciesByCoverage("Health");
        manager.findDuplicatePolicies();

        manager.performanceComparison();
    }

    public void performanceComparison() {
        int n = 100000;
        List<Policy> testPolicies = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            cal.add(Calendar.DAY_OF_YEAR, rand.nextInt(365));
            testPolicies.add(new Policy("P" + i, "Holder" + i, cal.getTime(), "Auto", rand.nextDouble() * 1000));
        }

        long start, end;

        // HashSet Performance
        start = System.nanoTime();
        hashSet.addAll(testPolicies);
        end = System.nanoTime();
        System.out.println("\nHashSet - Insertion Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        hashSet.contains(testPolicies.get(n / 2));
        end = System.nanoTime();
        System.out.println("HashSet - Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        hashSet.remove(testPolicies.get(n / 2));
        end = System.nanoTime();
        System.out.println("HashSet - Deletion Time: " + (end - start) / 1e6 + " ms");

        // LinkedHashSet Performance
        start = System.nanoTime();
        linkedHashSet.addAll(testPolicies);
        end = System.nanoTime();
        System.out.println("\nLinkedHashSet - Insertion Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        linkedHashSet.contains(testPolicies.get(n / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet - Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        linkedHashSet.remove(testPolicies.get(n / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet - Deletion Time: " + (end - start) / 1e6 + " ms");

        // TreeSet Performance
        start = System.nanoTime();
        treeSet.addAll(testPolicies);
        end = System.nanoTime();
        System.out.println("\nTreeSet - Insertion Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        treeSet.contains(testPolicies.get(n / 2));
        end = System.nanoTime();
        System.out.println("TreeSet - Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        treeSet.remove(testPolicies.get(n / 2));
        end = System.nanoTime();
        System.out.println("TreeSet - Deletion Time: " + (end - start) / 1e6 + " ms");
    }
}
