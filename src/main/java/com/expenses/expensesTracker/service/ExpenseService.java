package com.expenses.expensesTracker.service;

import com.expenses.expensesTracker.dto.ExpenseRequest;
import com.expenses.expensesTracker.dto.ExpenseResponse;
import com.expenses.expensesTracker.model.Expense;


import java.util.List;
public interface ExpenseService {

    ExpenseResponse  createExpense(ExpenseRequest request);

    List<ExpenseResponse> getAllExpenses();

    ExpenseResponse  getExpenseById(Long id);

    ExpenseResponse  updateExpense(Long id, ExpenseRequest request);

    void deleteExpense(Long id);
}
