package org.virtusa.expenseTracker.expRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.expenseTracker.expModel.Entertainment;
@Repository
public interface EntertainmentRepository extends CrudRepository<Entertainment, Integer>{

}
