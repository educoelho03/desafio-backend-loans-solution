package tech.ecoelho.backend.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.ecoelho.backend.domain.dto.CustomerLoanRequest;
import tech.ecoelho.backend.domain.dto.CustomerLoanResponse;
import tech.ecoelho.backend.service.LoanService;

@RestController
public class loanController {

    private final LoanService loanService;

    public loanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest loanRequest){
        var response = loanService.checkLoanAvailability(loanRequest);

        return ResponseEntity.ok(response);
    }
}
