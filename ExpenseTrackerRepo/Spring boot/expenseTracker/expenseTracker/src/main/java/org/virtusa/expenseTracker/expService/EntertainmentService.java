package org.virtusa.expenseTracker.expService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.expenseTracker.expModel.Entertainment;
import org.virtusa.expenseTracker.expRepository.EntertainmentRepository;

@Service
public class EntertainmentService {

	@Autowired
	private EntertainmentRepository entRepository;

	public List<Entertainment> getAllEntertainment() {
		return (List<Entertainment>) entRepository.findAll();
	}

	public List<Entertainment> addEntertainmentList(List<Entertainment> entertaiment) {
		entRepository.saveAll(entertaiment);
		return (List<Entertainment>) entRepository.findAll();
	}

	
}
