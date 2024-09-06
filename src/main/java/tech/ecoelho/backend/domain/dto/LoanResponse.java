package tech.ecoelho.backend.domain.dto;

import tech.ecoelho.backend.domain.entity.LoanType;

public record LoanResponse(LoanType type, double interest_rate) {
}
