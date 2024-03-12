package com.paydestla.expense.domain;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Expenses {
    private Long id;
    private LocalDateTime expenseDate;
    private Double expenseValue;
    private Double vat;
    private String expenseReason;
    private String userId;
}
