package com.mrj.springboot.firstrestapi.survey;

import java.util.List;

public class Question {
	private String id;
	private String desc;
	private List<String> options;
	private String correctAnswer;
	
	public Question(String id, String desc, List<String> options, String correctAnswer) {
		super();
		this.id = id;
		this.desc = desc;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}
	
	public Question()
	{
		
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	public List<String> getOptions() {
		return options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", desc=" + desc + ", options=" + options + ", correctAnswer=" + correctAnswer
				+ "]";
	}
	
}
