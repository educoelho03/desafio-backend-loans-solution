package tech.ecoelho.backend.domain.dto;

import java.util.List;

public record CustomerLoanResponse(String customer, List<LoanResponse> loans) {
}
