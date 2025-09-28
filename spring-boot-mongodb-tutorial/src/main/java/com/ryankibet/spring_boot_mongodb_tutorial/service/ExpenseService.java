package com.ryankibet.spring_boot_mongodb_tutorial.service;

import com.mongodb.client.model.ReturnDocument;
import com.ryankibet.spring_boot_mongodb_tutorial.model.Expense;
import com.ryankibet.spring_boot_mongodb_tutorial.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {

        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense) {
        // we first find the expense we are looking for, the update it
        // else if not found it throws an error
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense by id %s", expense.getId())));

        // updating
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        // save the instance that's updated
        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {

        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException
                        (String.format("Cannot find expense by name %s", name))
        );
    }

    public void deleteExpense() {}
}
