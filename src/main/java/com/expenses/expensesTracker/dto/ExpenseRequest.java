package com.expenses.expensesTracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ExpenseRequest(
        @NotBlank(message="category is required") String category,
        @NotBlank(message = "Title is required") String title,
        @Positive(message = "Amount must be greater than 0") double amount,
        @NotNull(message = "Date is required") LocalDate date
) {}

