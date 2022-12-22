import java.util.Scanner;

public class DepositCalculator
{
    private static final int DEFAULT_PLACES = 2;
    private static final double DEFAULT_YEAR_RATE = 0.06;
    private static final int NUMBER_OF_MONTHS_IN_YEAR = 12;

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / NUMBER_OF_MONTHS_IN_YEAR),
            NUMBER_OF_MONTHS_IN_YEAR * depositPeriod);
        return round(pay, DEFAULT_PLACES);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount + amount * yearRate * depositPeriod;
        return round(pay, DEFAULT_PLACES);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositResultAmount() {
        int depositPeriod;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int depositStartAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositResultAmount = 0;
        if (action == 1) {
            depositResultAmount = calculateSimplePercent(depositStartAmount, DEFAULT_YEAR_RATE, depositPeriod);
        } else if (action == 2) {
            depositResultAmount = calculateComplexPercent(depositStartAmount, DEFAULT_YEAR_RATE, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositStartAmount + " за " + depositPeriod + " лет превратятся в "
            + depositResultAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositResultAmount();
    }
}
