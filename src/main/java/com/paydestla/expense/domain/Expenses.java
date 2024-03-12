package com.paydestla.expense.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
public class Expenses {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @NotNull(message = "expenseDate is required")
    private LocalDate expenseDate;
    @NotNull(message = "expenseValue is required")
    private Double expenseValue;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double vat;
    private String expenseReason;
    @NotNull(message = "userId is required")
    private String userId;
}
