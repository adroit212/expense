package com.paydestla.expense.repository;

import com.paydestla.expense.model.ExpensesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpensesEntity, Long> {
    List<ExpensesEntity> findByUserId(String userId);
}
