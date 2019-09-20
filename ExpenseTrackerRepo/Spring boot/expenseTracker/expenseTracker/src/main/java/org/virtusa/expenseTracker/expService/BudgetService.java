package org.virtusa.expenseTracker.expService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.expenseTracker.expModel.BudgetLimit;
import org.virtusa.expenseTracker.expRepository.BudgetRepository;

@Service
public class BudgetService {

	@Autowired
	private BudgetRepository budgetRepository ;
	
	public void addBudget(List<BudgetLimit> budget)
	{
		budgetRepository.saveAll(budget);
	}
	public List<BudgetLimit> getBudget()
	{
		return (List<BudgetLimit>) budgetRepository.findAll();
	}
}
