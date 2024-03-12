package com.paydestla.expense.controller;

import com.paydestla.expense.domain.Expenses;
import com.paydestla.expense.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expenses> createExpense(@Valid @RequestBody Expenses expenses){
        return ResponseEntity.ok(expenseService.create(expenses));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Expenses>> findByUserId(@PathVariable String userId){
        return ResponseEntity.ok(expenseService.findByUserId(userId));
    }
}
