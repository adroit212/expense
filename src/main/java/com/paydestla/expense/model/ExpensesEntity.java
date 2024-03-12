package com.paydestla.expense.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "EXPENSES")
@NoArgsConstructor
@Data
public class ExpensesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false, insertable = false, updatable = false)
    private Long id;
    @Column(name = "EXPENSE_DATE")
    private LocalDate expenseDate;
    @Column(name = "EXPENSE_VALUE")
    private Double expenseValue;
    @Column(name = "VAT")
    private Double vat;
    @Column(name = "EXPENSE_REASON")
    private String expenseReason;
    @Column(name = "USER_ID")
    private String userId;
}
