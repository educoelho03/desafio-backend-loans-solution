package tech.ecoelho.backend.domain.entity;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    private boolean isPersonalLoanAvailable(){
        return basicLoanAvailable();
    }

    private boolean guaranteedLoanAvailable(){
        if (customer.incomeIsBiggerOrEqualThan(3000)){
            return true;
        }

        return customer.incomeIsBetween(3000, 5000)
                && customer.ageIsBiggerThan(30)
                && customer.isLocationFrom("SP");
    }

    private boolean consignedLoanAvailable(){
        customer.incomeIsBiggerOrEqualThan(5000);
        return true;
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
