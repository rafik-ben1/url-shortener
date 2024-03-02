package com.rafikben.urlshortner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UrlshortnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlshortnerApplication.class, args);
	}
	  @Autowired
	  SequenceRepository sequenceRepository;

	  @Bean
	  public CommandLineRunner init() {

	      return args -> {
          if(sequenceRepository.count()==0) {
        	  Sequence firstRow = new Sequence();
        	  firstRow.setNextIndex(new int[] {48,48,48,48,48});
        	  sequenceRepository.save(firstRow);
          }
	       for(int i = 48 ; i<90 ; i++) {
	    	   System.out.println((char) i );
	    	   System.out.println("/////////");
	       } 
	      };
	
	  }
}
