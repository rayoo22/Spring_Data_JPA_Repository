package com.ryankibet.spring_boot_mongodb_tutorial.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("expense") // to save this information to mongodb, we save it as a document
public class Expense {
    @Id // this is the unique identifier of every record
    private String id;

    @Field(name = "name")
    @Indexed(unique = true) // does not store more than one expense with the same name
    private String expenseName;

    @Field(name = "category")
    private ExpenseCategory expenseCategory;

    @Field(name = "amount")
    private BigDecimal expenseAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}
