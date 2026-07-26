package com.expenses.expensesTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expenses.expensesTracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
