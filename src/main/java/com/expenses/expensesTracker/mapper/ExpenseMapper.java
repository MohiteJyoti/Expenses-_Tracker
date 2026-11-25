package com.expenses.expensesTracker.mapper;

import com.expenses.expensesTracker.dto.ExpenseRequest;
import com.expenses.expensesTracker.dto.ExpenseResponse;
import com.expenses.expensesTracker.model.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    // Used by create (POST)
    public Expense toEntity(ExpenseRequest request) {
        Expense expense = new Expense();
        expense.setTitle(request.title());
        expense.setCategory(request.category());
        expense.setAmount(request.amount());
        expense.setDate(request.date());
        return expense;
    }

    // Used by update (PUT): copies request values onto an existing entity
    public void updateEntity(Expense expense, ExpenseRequest request) {
        expense.setTitle(request.title());
        expense.setCategory(request.category());
        expense.setAmount(request.amount());
        expense.setDate(request.date());
    }

    // Used by every endpoint that returns data
    public ExpenseResponse toResponse(Expense expense) {
        return new ExpenseResponse(
                expense.getId(),
                expense.getTitle(),
                expense.getCategory(),
                expense.getAmount(),
                expense.getDate());
    }
}
