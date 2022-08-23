package com.madhavasok.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.madhavasok.travels.models.Expense;
import com.madhavasok.travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expRepo;
	
	public ExpenseService(ExpenseRepository expRepo) {
		this.expRepo = expRepo;
	}
	
	public List<Expense> allExpenses(){
		return this.expRepo.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return expRepo.save(expense);
	}
	
	public Expense findExpense(long id) {
		Optional<Expense> optionalExpense = expRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
	public Expense updateExpense(Expense expense) {
		return expRepo.save(expense);
	}

	public void deleteExpense(Long id) {
		expRepo.deleteById(id);
	}
	

}
