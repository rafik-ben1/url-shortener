package com.rafikben.urlshortner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {
    @Autowired
    private  UrlRepository urlRepository;
    
    public String generateId() {
    	String id = "";
    	Random random = new Random();
    	for(int i=0;i<5;i++ ) {
    		id = id + (char) (random.nextInt(90-48)+ 48);
    	}
    	return id;
    }
    
    public String getUrl(String id){
        Url urlExists = this.urlRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("url not found"));
        return urlExists.getUrl();
    }
    public String postUrl (Url url){
        Optional<Url> urlExists = this.urlRepository.findByUrl(url.getUrl());
        
        Url Savedurl = urlExists.orElseGet(() -> {
        	url.setId(this.generateId());
        	return this.urlRepository.save(url);
        });
        return "localhost:8080/"+Savedurl.getId();
    }
}
