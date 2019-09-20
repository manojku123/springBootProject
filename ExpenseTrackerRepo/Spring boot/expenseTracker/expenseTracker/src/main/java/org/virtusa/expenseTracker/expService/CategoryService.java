package org.virtusa.expenseTracker.expService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.expenseTracker.expModel.ExpCategory;
import org.virtusa.expenseTracker.expRepository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository catRepository;
	
	public List<ExpCategory> getAllCategory(){
		return (List<ExpCategory>) catRepository.findAll();
	}
	public String test()
	{
		return "hello";
	}
}
