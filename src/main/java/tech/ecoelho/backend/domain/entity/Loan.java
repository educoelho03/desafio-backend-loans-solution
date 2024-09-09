package tech.ecoelho.backend.domain.entity;

import tech.ecoelho.backend.exception.LoanNotAvailableException;

public class Loan {

    private final Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable(){
        return basicLoanAvailable();
    }

    public boolean isGuaranteedLoanAvailable(){
        if (customer.incomeIsBiggerOrEqualThan(3000)){
            return true;
        }

        return customer.incomeIsBetween(3000, 5000)
                && customer.ageIsBiggerThan(30)
                && customer.isLocationFrom("SP");
    }

    public boolean isConsignedLoanAvailable(){
        customer.incomeIsBiggerOrEqualThan(5000);
        return true;
    }

    public double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()){
            return 4.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getGuaranteedLoanInterestRate() {
        if (isGuaranteedLoanAvailable()){
            return 3.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getConsigmentLoanInterestRate() {
        if (isConsignedLoanAvailable()){
            return 2.0;
        }
        throw new LoanNotAvailableException();
    }

    private boolean basicLoanAvailable() {
        if (customer.incomeIsBiggerOrEqualThan(3000.0)) {
            return true;
        }

        return customer.incomeIsBetween(3000.00, 5000.00)
                && customer.ageIsBiggerThan(30)
                && customer.isLocationFrom("SP");
    }
}
