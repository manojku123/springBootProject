package org.virtusa.expenseTracker.expService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.expenseTracker.expModel.Others;
import org.virtusa.expenseTracker.expRepository.OthersRepository;

@Service
public class OthersService {

	@Autowired
	private OthersRepository otherRepository;

	public List<Others> getAllOthers() {
		return (List<Others>) otherRepository.findAll();
	}

	public List<Others> addOtherList(List<Others> others) {
		otherRepository.saveAll(others);
		return (List<Others>) otherRepository.findAll();
		
		
	}
}
