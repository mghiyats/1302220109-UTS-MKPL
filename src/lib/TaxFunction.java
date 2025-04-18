package lib;

public class TaxFunction {

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
                                   int deductible, boolean isMarried, int numberOfChildren) {

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }

        int annualIncome = calculateAnnualIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking);
        int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
        int taxableIncome = annualIncome - deductible - nonTaxableIncome;

        int tax = (int) Math.round(0.05 * taxableIncome);

        return Math.max(tax, 0);
    }

    private static int calculateAnnualIncome(int salary, int otherIncome, int monthsWorked) {
        return (salary + otherIncome) * monthsWorked;
    }

    private static int calculateNonTaxableIncome(boolean isMarried, int children) {
        int base = 54000000;
        int marriageAllowance = isMarried ? 4500000 : 0;
        int childrenAllowance = children * 1500000;

        return base + marriageAllowance + childrenAllowance;
    }
}
