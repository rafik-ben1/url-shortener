package com.rafikben.urlshortner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {
    @Autowired
    private  UrlRepository urlRepository;

    public String getUrl(Long id){
        Url urlExists = this.urlRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("url not found"));
        return urlExists.getUrl();
    }
    public String postUrl (Url url){
        Optional<Url> urlExists = this.urlRepository.findById(url.getId());
        Url Savedurl = urlExists.orElseGet(() -> this.urlRepository.save(url));
        return "localhost:8080/"+Savedurl.getId();
    }
}
