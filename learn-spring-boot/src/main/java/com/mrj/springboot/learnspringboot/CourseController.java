package com.mrj.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses()
	{
		return Arrays.asList(new Course(1,"Learn AWS","mrj"),new Course(2,"Learn DevOps","mrj"),new Course(3,"Learn Azure","mrj"),new Course(4,"Learn GCP","mrj"));
	}
}
