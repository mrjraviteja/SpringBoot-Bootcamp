package com.mrj.springboot.firstrestapi.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {
	
	private SurveyService surveyService;
	
	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys()
	{
		return surveyService.retrieveAllSurveys();
	}
	
	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSurveyById(@PathVariable String surveyId)
	{
		Survey surveyresponse = surveyService.retrieveSurveyById(surveyId);
		if(surveyresponse == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return surveyresponse;
	}
	
	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveAllQuestions(@PathVariable String surveyId)
	{
		Survey surveyresponse = surveyService.retrieveSurveyById(surveyId);
		if(surveyresponse == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return surveyService.retrieveAllSurveyQuestions(surveyresponse);
	}
	
	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveQuestionById(@PathVariable String surveyId,@PathVariable String questionId)
	{
		Survey surveyresponse = surveyService.retrieveSurveyById(surveyId);
		if(surveyresponse == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Question questionresponse = surveyService.retrieveQuestionById(surveyresponse,questionId);
		if(questionresponse == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return questionresponse;
	}
	
	@RequestMapping(value= "/surveys/{surveyId}/questions",method = RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId,@RequestBody Question question)
	{
		String questionId = surveyService.addNewSurveyQuestion(surveyId,question);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId).toUri();
		return ResponseEntity.created(location ).build();
	}
	
	@RequestMapping(value="/surveys/{surveyId}/questions/{questionId}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteQuestionById(@PathVariable String surveyId,@PathVariable String questionId)
	{
		Survey surveyresponse = surveyService.retrieveSurveyById(surveyId);
		if(surveyresponse == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		surveyService.deleteQuestionById(surveyresponse,questionId);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/surveys/{surveyId}/questions/{questionId}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateQuestionById(@PathVariable String surveyId,@PathVariable String questionId,@RequestBody Question question)
	{
		Survey surveyresponse = surveyService.retrieveSurveyById(surveyId);
		if(surveyresponse == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		surveyService.updateQuestionById(surveyresponse,questionId,question);
		return ResponseEntity.noContent().build();
	}
	
}
