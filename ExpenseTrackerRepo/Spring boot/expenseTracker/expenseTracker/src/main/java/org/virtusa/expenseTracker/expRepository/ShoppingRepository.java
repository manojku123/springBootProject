package org.virtusa.expenseTracker.expRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.expenseTracker.expModel.Shopping;
@Repository
public interface ShoppingRepository extends CrudRepository<Shopping, Integer>{

}
