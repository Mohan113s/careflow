package com.careflow.service;

import java.util.List;

import com.careflow.entity.FAQ;

public interface FAQService {
	FAQ saveFAQ(FAQ faq);
    List<FAQ> getAllFAQs();
    FAQ getFAQById(Long id);
    void deleteFAQ(Long id);
}
