package com.paydestla.expense.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "EXPENSES")
@NoArgsConstructor
@Data
public class ExpensesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "ID",nullable = false, insertable = false, updatable = false)
    @GenericGenerator(name = "native")
    private Long id;
    @Column(name = "EXPENSE_DATE")
    private LocalDateTime expenseDate;
    @Column(name = "EXPENSE_VALUE")
    private Double expenseValue;
    @Column(name = "VAT")
    private Double vat;
    @Column(name = "EXPENSE_REASON")
    private String expenseReason;
    @Column(name = "USER_ID")
    private String userId;
}
