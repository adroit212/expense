package com.paydestla.expense.repository;

import com.paydestla.expense.model.ExpensesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpensesEntity, Long> {
}
