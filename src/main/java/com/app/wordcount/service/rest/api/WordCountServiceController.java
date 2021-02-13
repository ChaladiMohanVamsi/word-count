package com.app.wordcount.service.rest.api;

import com.app.wordcount.service.models.WordCountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class WordCountServiceController {

    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    @GetMapping(path="/{word}")
    public ResponseEntity<WordCountResponse> getWordCount(@PathVariable("word") String word){
        Integer count = map.getOrDefault(word,0);
        return ResponseEntity.ok(new WordCountResponse(word, count));
    }

    @PutMapping(path="/{word}")
    public ResponseEntity putWord(@PathVariable("word") String word){
        Integer count = map.getOrDefault(word,0);
        if(count==0) map.put(word,1); else map.replace(word, count+1);
        return ResponseEntity.ok().body(String.format("%s in inserted", word));
    }
}
