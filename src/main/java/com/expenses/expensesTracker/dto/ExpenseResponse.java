package com.expenses.expensesTracker.dto;

import java.time.LocalDate;

public record ExpenseResponse(Long id,
                              String category ,
                              String title,
                              double amount,
                              LocalDate date) {
}
