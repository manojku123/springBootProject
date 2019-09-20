package org.virtusa.expenseTracker.expService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.expenseTracker.expRepository.EntertainmentRepository;
import org.virtusa.expenseTracker.expRepository.FoodRepository;
import org.virtusa.expenseTracker.expRepository.OthersRepository;
import org.virtusa.expenseTracker.expRepository.ShoppingRepository;
import org.virtusa.expenseTracker.expRepository.TravelingRepository;
@Service
public class TruncateDatabaseService {

	@Autowired
	private ShoppingRepository sRepository;
	@Autowired
	private TravelingRepository tRepository;
	@Autowired
	private EntertainmentRepository eRepository;
	@Autowired
	private FoodRepository fRepository;
	@Autowired
	private OthersRepository oRepository;
	public void truncate() {
		sRepository.deleteAll();
		tRepository.deleteAll();
		eRepository.deleteAll();
		fRepository.deleteAll();
		oRepository.deleteAll();
	}

}
