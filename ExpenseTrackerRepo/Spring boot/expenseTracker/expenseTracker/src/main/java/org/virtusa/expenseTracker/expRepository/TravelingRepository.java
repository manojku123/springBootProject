package org.virtusa.expenseTracker.expRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.expenseTracker.expModel.Traveling;
@Repository
public interface TravelingRepository extends CrudRepository<Traveling, Integer>{

}
