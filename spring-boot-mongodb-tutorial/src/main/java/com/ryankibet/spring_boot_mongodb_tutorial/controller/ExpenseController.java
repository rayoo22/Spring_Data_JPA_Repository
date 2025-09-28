package com.ryankibet.spring_boot_mongodb_tutorial.controller;

import com.ryankibet.spring_boot_mongodb_tutorial.model.Expense;
import com.ryankibet.spring_boot_mongodb_tutorial.repository.ExpenseRepository;
import com.ryankibet.spring_boot_mongodb_tutorial.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseService expenseService, ExpenseRepository expenseRepository) {
        this.expenseService = expenseService;
        this.expenseRepository = expenseRepository;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // this controller returns the record/object that has been updated
    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {

        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    //gets what the Expense Service method 'getExpenseByName' wants
    @GetMapping("/name")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
