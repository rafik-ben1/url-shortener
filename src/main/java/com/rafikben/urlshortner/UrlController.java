package com.rafikben.urlshortner;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UrlController {
    @Autowired
    private UrlService urlService;
    @GetMapping("{id}")
    public void redirect (@PathVariable String id, HttpServletResponse res) throws IOException {
        String redirectUrl = this.urlService.getUrl(id);
        res.sendRedirect(redirectUrl);
    }
    @PostMapping("/shorten")
    public Map<String, String> postUrl(@RequestBody Url inputUrl) {
        Map<String, String> res = new HashMap<>();

        if (inputUrl.getUrl() == null) {
            res.put("error", "provide a url dump ass");
            return res;
        }

        String shortenedUrl = this.urlService.postUrl(inputUrl);

        res.put("shortenedUrl",shortenedUrl );


        return res;
    }
}
