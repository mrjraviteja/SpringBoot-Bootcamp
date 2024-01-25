package com.mrj.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mrj.spring.learnspringframework.enterprise.example.web.MyWebController;
import com.mrj.spring.learnspringframework.game.GameRunner;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		// MarioGame game = new MarioGame();
		// SuperContraGame game = new SuperContraGame();
		
		// GamingConsole game = new PacManGame();
		// GameRunner runner = new GameRunner(game);
		
		// GameRunner runner = context.getBean(GameRunner.class);
		// runner.run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}
}
