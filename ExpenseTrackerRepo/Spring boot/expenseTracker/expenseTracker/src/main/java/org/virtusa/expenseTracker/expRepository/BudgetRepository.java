package org.virtusa.expenseTracker.expRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.expenseTracker.expModel.BudgetLimit;
@Repository
public interface BudgetRepository extends CrudRepository<BudgetLimit, Integer>{

}
