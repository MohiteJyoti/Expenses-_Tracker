package com.expenses.expensesTracker.service;

import com.expenses.expensesTracker.model.Expense;


import java.util.List;
public interface ExpenseService {

    Expense createExpense(Expense expense);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, Expense updatedExpense);

    void deleteExpense(Long id);
}
