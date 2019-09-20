package org.virtusa.expenseTracker.expService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.expenseTracker.expModel.Food;
import org.virtusa.expenseTracker.expRepository.FoodRepository;
@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	public List<Food> getAllFood()
	{
		return (List<Food>) foodRepository.findAll();
	}

	public List<Food> addFoodList(List<Food> food) {
		foodRepository.saveAll(food);
		return (List<Food>) foodRepository.findAll();
	}

}
