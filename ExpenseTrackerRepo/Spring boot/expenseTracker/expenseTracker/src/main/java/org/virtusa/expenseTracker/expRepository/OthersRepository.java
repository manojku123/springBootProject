package org.virtusa.expenseTracker.expRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.expenseTracker.expModel.Others;
@Repository
public interface OthersRepository extends CrudRepository<Others, Integer>{

}
