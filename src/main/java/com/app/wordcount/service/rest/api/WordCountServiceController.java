package com.app.wordcount.service.rest.api;

import com.app.wordcount.service.models.WordCountResponse;
import com.app.wordcount.service.serviceprovider.WordCountServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class WordCountServiceController {

    @Autowired
    private WordCountServiceDelegate wordCountServiceDelegate;

    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    @GetMapping(path="/word/{wordVariable}")
    public ResponseEntity<WordCountResponse> getWordCount(@PathVariable("wordVariable") String word){
        Integer count = wordCountServiceDelegate.getWordCount(word);
        return ResponseEntity.ok(new WordCountResponse(word, count));
    }

    @PutMapping(path="/word/{wordVariable}")
    public ResponseEntity putWord(@PathVariable("wordVariable") String word){
        wordCountServiceDelegate.insertWord(word);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(String.format("%s in inserted", word));
    }
}
