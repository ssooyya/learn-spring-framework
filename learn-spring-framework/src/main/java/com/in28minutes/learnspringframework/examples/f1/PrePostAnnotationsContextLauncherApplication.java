package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		super();
		System.out.println("All dependencies are ready");
		this.someDependency = someDependency;
	}
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("CleanUp");
	}
}

@Component
class SomeDependency {

	public void getReady() {
		// TODO Auto-generated method stub
		System.out.println("Some logic using SomeDependency");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(
				PrePostAnnotationsContextLauncherApplication.class);) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}
	}
}