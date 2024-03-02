package com.rafikben.urlshortner;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private  UrlRepository urlRepository;
    private SequenceRepository sequenceRepository;
    
    public UrlService(UrlRepository urlRepository, SequenceRepository sequenceRepository) {
		super();
		this.urlRepository = urlRepository;
		this.sequenceRepository = sequenceRepository;
	}

	public String generateId() {
    	String id = "";
        Sequence sequence = this.sequenceRepository.findAll().get(0);
        int[] nextIndex = sequence.getNextIndex(); 
    	for(int i=0;i<5;i++ ) {
    		id =  (char) (nextIndex[i])+ id ;    		
    	}
    	nextIndex[0] = nextIndex[0]+1;
    	for(int i=0;i<5;i++) {
    		if(nextIndex[i]==90) {
    			nextIndex[i]=48;
    			nextIndex[i+1]=nextIndex[i+1]+1;
    			if(i!=0) {
    				for(int j = 1 ; j<i;j++ ) {
    					nextIndex[j] = 48;
    				}
    			}
    		}
    	}
    	sequence.setNextIndex(nextIndex);
    	this.sequenceRepository.save(sequence);
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
