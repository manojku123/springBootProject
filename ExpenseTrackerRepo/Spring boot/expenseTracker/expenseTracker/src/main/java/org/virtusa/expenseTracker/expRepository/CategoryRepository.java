package org.virtusa.expenseTracker.expRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.expenseTracker.expModel.ExpCategory;
@Repository
public interface CategoryRepository  extends CrudRepository<ExpCategory, Integer>{

}
