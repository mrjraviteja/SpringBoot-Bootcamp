package com.mrj.spring.learnspringframework.game;

// @Component
public class PacManGame implements GamingConsole{
	
	public void up()
	{
		System.out.println("PacManGame Up");
	}
	
	public void down()
	{
		System.out.println("PacManGame Down");
	}
	
	public void left()
	{
		System.out.println("PacManGame Left");
	}
	
	public void right()
	{
		System.out.println("PacManGame Right");
	}
	
}
