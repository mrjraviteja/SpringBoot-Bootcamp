package com.mrj.springboot.firstrestapi.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {
	
	private static List<Survey> surveys = new ArrayList<>();
	
	static {
		Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                        "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", Arrays.asList(
                        "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", Arrays.asList(
                        "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
 
        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));
 
        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);
 
        surveys.add(survey);
	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey retrieveSurveyById(String surveyId) {
		Predicate<? super Survey> predicate = survey -> survey.getId().equalsIgnoreCase(surveyId);
		Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();
		if(optionalSurvey.isEmpty())
		{
			return null;
		}
		return optionalSurvey.get();
	}

	public List<Question> retrieveAllSurveyQuestions(Survey surveyresponse) {
		return surveyresponse.getQuestions();
	}

	public Question retrieveQuestionById(Survey surveyresponse, String questionId) {
		Optional<Question> resp = surveyresponse.getQuestionById(questionId);
		if(resp.isEmpty())
		{
			return null;
		}
		return resp.get();
	}

	public String addNewSurveyQuestion(String surveyId, Question question) {
		Survey s = retrieveSurveyById(surveyId);
		List<Question> questions = s.getQuestions();
		question.setId(generateRandomId());
		questions.add(question);
		return question.getId();
	}

	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}
	
	public String deleteQuestionById(Survey surveyresponse, String questionId) {
		boolean removed = surveyresponse.deleteQuestionById(questionId);
		
		if(!removed)
		{
			return null;
		}
		return questionId;
	}

	public void updateQuestionById(Survey surveyresponse, String questionId, Question question) {
		List<Question> questions = surveyresponse.getQuestions();
		questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
		questions.add(question);
	}
}
;