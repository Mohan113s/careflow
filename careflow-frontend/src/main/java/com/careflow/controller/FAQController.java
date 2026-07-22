package com.careflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careflow.entity.FAQ;
import com.careflow.service.FAQService;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
@RequestMapping("/faqs")
public class FAQController {
	@Autowired
	private FAQService service;
    @PostMapping
    public FAQ saveFAQ(@RequestBody FAQ faq) {
        return service.saveFAQ(faq);
    }
    @GetMapping
    public List<FAQ> getAllFAQs() {
        return service.getAllFAQs();
    }
    @GetMapping("/{id}")
    public FAQ getFAQById(@PathVariable Long id) {
        return service.getFAQById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteFAQ(@PathVariable Long id) {
        service.deleteFAQ(id);
        return "FAQ Deleted Successfully";
    }


}
