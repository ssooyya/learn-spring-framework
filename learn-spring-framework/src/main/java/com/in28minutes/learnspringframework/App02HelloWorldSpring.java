package com.in28minutes.learnspringframework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 1: Launch a Spring Context
		try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			// 2: Configure the things that we want Spring to manage -
			// HelloWorldConfiguration - @Configuration
			// name - @Bean

			// 3: Retrieving Beans managed by spring
			System.out.println(context.getBean("name"));

			System.out.println(context.getBean("age"));

			System.out.println(context.getBean("person"));

			System.out.println(context.getBean("person2MethodCall"));

			System.out.println(context.getBean("person3Parameters"));

			System.out.println(context.getBean("address2"));

			System.out.println(context.getBean(Person.class));

			System.out.println(context.getBean(Address.class));

//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}

		;

	}

}
