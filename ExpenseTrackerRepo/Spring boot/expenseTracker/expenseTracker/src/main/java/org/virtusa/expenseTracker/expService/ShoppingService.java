package org.virtusa.expenseTracker.expService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.expenseTracker.expModel.Shopping;
import org.virtusa.expenseTracker.expRepository.ShoppingRepository;

@Service
public class ShoppingService {

	@Autowired
	private ShoppingRepository shopRepository;

	public List<Shopping> getAllShopping() {
		return (List<Shopping>) shopRepository.findAll();
	}

	public List<Shopping> addShoppingList(List<Shopping> list) {
		
		shopRepository.saveAll(list);
		return (List<Shopping>) shopRepository.findAll();
		
	}
}
