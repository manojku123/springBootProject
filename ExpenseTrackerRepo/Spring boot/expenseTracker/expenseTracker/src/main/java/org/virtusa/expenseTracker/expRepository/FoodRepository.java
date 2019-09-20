package org.virtusa.expenseTracker.expRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.expenseTracker.expModel.Food;
@Repository
public interface FoodRepository  extends CrudRepository<Food, Integer>{

}
