package com.mrj.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mrj.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Learn AWS","mrj"));
		repository.insert(new Course(2,"Learn Devops","mrj"));
		repository.insert(new Course(3,"Learn Full Stack","mrj"));
		repository.deleteById(1);
	}
	
}
