public class FinancialForecasting {

    // Method to calculate future value using iteration
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  // Initial amount
        double annualGrowthRate = 0.05;  // Annual growth rate (5%)
        int years = 10;  // Number of years to forecast

        double futureValue = calculateFutureValueIterative(presentValue, annualGrowthRate, years);
        System.out.println("The future value after " + years + " years is: " + futureValue);
    }
}
