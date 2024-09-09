package tech.ecoelho.backend.service;

import tech.ecoelho.backend.domain.dto.CustomerLoanRequest;
import tech.ecoelho.backend.domain.dto.CustomerLoanResponse;
import tech.ecoelho.backend.domain.dto.LoanResponse;
import tech.ecoelho.backend.domain.entity.Loan;
import tech.ecoelho.backend.domain.entity.LoanType;

import java.util.ArrayList;
import java.util.List;

public class LoanService {

    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest) {

        var customer = loanRequest.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsignedLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsigmentLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CustomerLoanResponse(loanRequest.name(), loans);
    }
}
