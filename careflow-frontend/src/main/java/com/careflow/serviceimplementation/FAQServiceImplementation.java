package com.careflow.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careflow.entity.FAQ;
import com.careflow.repository.FAQRepository;
import com.careflow.service.FAQService;

@Service
public class FAQServiceImplementation implements FAQService {
	@Autowired
	private FAQRepository repo;
	 @Override
	    public FAQ saveFAQ(FAQ faq) {
	        return repo.save(faq);
	    }
	    @Override
	    public List<FAQ> getAllFAQs() {
	        return repo.findAll();
	    }
	    @Override
	    public FAQ getFAQById(Long id) {
	        return repo.findById(id).orElse(null);
	    }
	    @Override
	    public void deleteFAQ(Long id) {
	        repo.deleteById(id);
	    }

}
