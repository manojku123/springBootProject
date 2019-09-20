package org.virtusa.expenseTracker.expController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.virtusa.expenseTracker.expModel.BudgetLimit;
import org.virtusa.expenseTracker.expModel.Entertainment;
import org.virtusa.expenseTracker.expModel.ExpCategory;
import org.virtusa.expenseTracker.expModel.Food;
import org.virtusa.expenseTracker.expModel.Others;
import org.virtusa.expenseTracker.expModel.Shopping;
import org.virtusa.expenseTracker.expModel.Traveling;
import org.virtusa.expenseTracker.expService.BudgetService;
import org.virtusa.expenseTracker.expService.CategoryService;
import org.virtusa.expenseTracker.expService.EntertainmentService;
import org.virtusa.expenseTracker.expService.FoodService;
import org.virtusa.expenseTracker.expService.OthersService;
import org.virtusa.expenseTracker.expService.ShoppingService;
import org.virtusa.expenseTracker.expService.TravelingService;
import org.virtusa.expenseTracker.expService.TruncateDatabaseService;

@RestController
@RequestMapping(path="/expense")
public class ExpenseController {
	
	@Autowired
	private CategoryService catService;
	@Autowired
	private ShoppingService shopService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private EntertainmentService entService;
	@Autowired
	private TravelingService travelService;
	@Autowired
	private OthersService otherService;
	@Autowired
	private BudgetService budgetService;
	@Autowired
	private TruncateDatabaseService truncateService;
	
	//truncate tables of database*******************************
	@GetMapping("/truncate")
	public void truncateTables()
	{
		truncateService.truncate();
	}
	//get category data from db**********************************
	@GetMapping("/category")
	public List<ExpCategory> getAllCategory()
	{
		return catService.getAllCategory();
	}
	//get shopping data from db***********************
	@GetMapping("/shopping")
	public List<Shopping> getShopping()
	{
		return shopService.getAllShopping();
	}
	
	//get food data from db******************************
	@GetMapping("/food")
	public List<Food> getFood()
	{
		return foodService.getAllFood();
		
	}
	//get entertainment data from db******************************
	@GetMapping("/entertainment")
	public List<Entertainment> getEntertainment()
	{
		return entService.getAllEntertainment();
	}
	//get traveling data from db******************************
	@GetMapping("/traveling")
	public List<Traveling> getTraveling()
	{
		return travelService.getAllTraveling();
	}
	//get others data from db******************************
	@GetMapping("/others")
	public List<Others> getOthers()
	{
		return otherService.getAllOthers();
	}	
	
	//get budget data from db******************************
		@GetMapping("/budget")
		public List<BudgetLimit> getBudget()
		{
			return budgetService.getBudget();
		}	
	//adding shopping data to db*******************************
		@PostMapping("/shopping")
		@ResponseStatus(HttpStatus.OK)
		public List<Shopping> addShopping(@RequestBody List<Shopping> shopping)
		{
			List<Shopping> temp=shopService.getAllShopping();
			int count = temp.size()+1;
			for(Shopping s: shopping)
			{
				int itemNO=count++;
				s.setItemNo(itemNO);
			}
			return shopService.addShoppingList(shopping);
			
		}
		
	//adding Entertainment data to db*******************************
		@PostMapping("/entertainment")
		@ResponseStatus(HttpStatus.OK)
		public List<Entertainment> addEntertainment(@RequestBody List<Entertainment> entertaiment)
		{
			List<Entertainment> temp=entService.getAllEntertainment();
			int count = temp.size()+1;
			for(Entertainment s: entertaiment)
			{
				int itemNO=count++;
				s.setItemNo(itemNO);
			}	
			return entService.addEntertainmentList(entertaiment);
		}
		
	//adding traveling data to db*******************************
		@PostMapping("/traveling")
		@ResponseStatus(HttpStatus.OK)
		public List<Traveling> addTraveling(@RequestBody List<Traveling> traveling)
		{
			List<Traveling> temp=travelService.getAllTraveling();
			int count = temp.size()+1;
			for(Traveling s: traveling)
			{
				int itemNO=count++;
				s.setItemNo(itemNO);
			}
			return travelService.addTravelingList(traveling);
		}
	//adding food data to db*******************************
		@PostMapping("/food")
		@ResponseStatus(HttpStatus.OK)
		public List<Food> addFood(@RequestBody List<Food> food)
		{
			List<Food> temp=foodService.getAllFood();
			int count = temp.size()+1;
			for(Food s: food)
			{
				int itemNO=count++;
				s.setItemNo(itemNO);
			}
			return foodService.addFoodList(food);
		}		
	//adding others data to db*******************************
		@PostMapping("/others")
		@ResponseStatus(HttpStatus.OK)
		public List<Others> addOthers(@RequestBody List<Others> others)
		{
			List<Others> tempOtherList = otherService.getAllOthers();
			int count = tempOtherList.size()+1;
			for(Others s: others)
			{
				int itemNO=count++;
				s.setItemNo(itemNO);
			}
			return otherService.addOtherList(others);
		}
	//adding budget limit data to db****************************
		@PostMapping("/addbudget")
		@ResponseStatus(HttpStatus.OK)
		public void addBudget(@RequestBody List<BudgetLimit> budget)
		{
			budgetService.addBudget(budget);
		}
}
