package com.careflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FAQ {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
public FAQ() {
	super();
	// TODO Auto-generated constructor stub
}
public FAQ(Long id, String question, String answer) {
	super();
	this.id = id;
	this.question = question;
	this.answer = answer;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
private String question;
private String answer;

}
