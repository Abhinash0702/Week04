package throwvsthrows;

public class ThrowVsThrows {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {

       if(amount < 0 || rate < 0){
           throw new IllegalArgumentException();
       }
        return (amount*rate*years )/100;
    }
    public static void main(String[] args) {

        try{
           double si = calculateInterest(1000,-1,3);
            System.out.println(si);
        } catch (IllegalArgumentException e) {
            System.out.println("Enter Positive value ! ");
            System.out.println(e);
        }
    }
}
