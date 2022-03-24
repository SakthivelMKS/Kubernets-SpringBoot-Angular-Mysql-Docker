package com.student;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import StudentServiceImpl.StudentServiceImp;

@SpringBootApplication
@EnableJpaAuditing
public class StudentApplication extends SpringBootServletInitializer   {

	   public static void main(String[] args) {
		   System.out.println("Test==> sratrt");
	      SpringApplication.run(StudentApplication.class, args);
	      System.out.println("Test==>end");
	   }

	    
	 @Bean
	    public StudentServiceImp studentMapper() {
	        return new StudentServiceImp ();
	    }
	 

}


