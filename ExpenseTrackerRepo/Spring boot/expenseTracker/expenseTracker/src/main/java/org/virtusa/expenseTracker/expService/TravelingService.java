package org.virtusa.expenseTracker.expService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.expenseTracker.expModel.Traveling;
import org.virtusa.expenseTracker.expRepository.TravelingRepository;

@Service
public class TravelingService {

@Autowired
private TravelingRepository travelRepository;

public List<Traveling> getAllTraveling() {
	return (List<Traveling>) travelRepository.findAll();
}

public List<Traveling> addTravelingList(List<Traveling> traveling) {
	travelRepository.saveAll(traveling);
	return (List<Traveling>) travelRepository.findAll();
}
}
