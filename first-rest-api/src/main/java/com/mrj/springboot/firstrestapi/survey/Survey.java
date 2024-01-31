package com.mrj.springboot.firstrestapi.survey;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Survey {
	
	private String id;
	private String title;
	private String desc;
	private List<Question> questions;
	
	public Survey(String id, String title, String desc, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.questions = questions;
	}
	
	public Survey()
	{
		
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDesc() {
		return desc;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public Optional<Question> getQuestionById(String questionId)
	{
		Predicate<? super Question> predicate = ques -> ques.getId().equalsIgnoreCase(questionId);
		return questions.stream().filter(predicate).findFirst();
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", desc=" + desc + ", questions=" + questions + "]";
	}

	public boolean deleteQuestionById(String questionId) {
		return questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
	}
	
}
