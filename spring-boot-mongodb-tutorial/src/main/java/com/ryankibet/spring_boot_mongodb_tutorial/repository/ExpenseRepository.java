package com.ryankibet.spring_boot_mongodb_tutorial.repository;

import com.ryankibet.spring_boot_mongodb_tutorial.model.Expense;
// when performing database operations, MongoRepository will execute all functions related to the
// operations, hence there is no need of writing the database operations
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    // we can do a query that going to look for the expense by name
    @Query("{'name' : ?0}")
    Optional<Expense> findByName(String name);
}