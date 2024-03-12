package com.paydestla.expense.service;

import com.paydestla.expense.domain.Expenses;
import com.paydestla.expense.model.ExpensesEntity;
import com.paydestla.expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ModelMapper modelMapper;
    private final ExpenseRepository expenseRepository;

    public Expenses save(Expenses expenses){
        ExpensesEntity expensesEntity = modelMapper.map(expenses,ExpensesEntity.class);
        return modelMapper.map(expenseRepository.save(expensesEntity),Expenses.class);
    }

    public Expenses create(Expenses expenses){
        expenses.setVat(getVat(expenses.getExpenseValue()));
        return save(expenses);
    }

    private double getVat(double expenseValue){
        return ((7.5/100) * expenseValue);
    }

    public List<Expenses> findByUserId(String userId){
        return expenseRepository.findByUserId(userId).stream().map(expensesEntity ->
                modelMapper.map(expensesEntity,Expenses.class)).collect(Collectors.toList());
    }
}
