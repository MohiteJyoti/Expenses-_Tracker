package com.expenses.expensesTracker.service;

import com.expenses.expensesTracker.dto.ExpenseRequest;
import com.expenses.expensesTracker.dto.ExpenseResponse;
import com.expenses.expensesTracker.exception.ResourceNotFoundException;
import com.expenses.expensesTracker.mapper.ExpenseMapper;
import com.expenses.expensesTracker.model.Expense;
import com.expenses.expensesTracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;


    }

    @Override
    public ExpenseResponse createExpense(ExpenseRequest request) {
        Expense expense = expenseMapper.toEntity(request);   // DTO -> entity
        Expense saved = expenseRepository.save(expense);     // save the entity
        return expenseMapper.toResponse(saved);              // entity -> DTO
    }

    @Override
    public List<ExpenseResponse> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        List<ExpenseResponse> responses = new ArrayList<>();
        for (Expense expense : expenses) {
            responses.add(expenseMapper.toResponse(expense));
        }
        return responses;
    }

    @Override
    public ExpenseResponse getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        return expenseMapper.toResponse(expense);
    }

    @Override
    public ExpenseResponse updateExpense(Long id, ExpenseRequest request) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        expenseMapper.updateEntity(expense, request);
        Expense saved = expenseRepository.save(expense);
        return expenseMapper.toResponse(saved);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        expenseRepository.delete(expense);
    }
}