package com.madhavasok.travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madhavasok.travels.models.Expense;
import com.madhavasok.travels.services.ExpenseService;

@Controller
public class TravelController {

	private final ExpenseService expenseService;
	public TravelController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses/show";
	}
	
	@GetMapping("/expenses/show")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> listOfExpenses = expenseService.allExpenses();
		System.out.println(listOfExpenses.get(0).getName());
		model.addAttribute("expenses", listOfExpenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		System.out.println("Successful");
		return "redirect:/expenses/show";
		
	}
	
	@RequestMapping(value = "/expenses/{id}/edit", method = RequestMethod.GET)
	public String editPage(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		System.out.println(expense.getName());
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@RequestMapping(value = "/expenses/{id}", method = RequestMethod.PUT)
	public String edit(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses/show";
        }
		
	}
	
	@DeleteMapping("/expenses/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses/show";
    }
	
	@RequestMapping(value = "/expenses/{id}/show", method = RequestMethod.GET)
	public String showExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		System.out.println(expense.getName());
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	
	
	
	
	

	
	
	
	
		
	
	}

