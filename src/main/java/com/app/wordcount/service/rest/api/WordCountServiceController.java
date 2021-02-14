package com.app.wordcount.service.rest.api;

import com.app.wordcount.service.models.WordCountResponse;
import com.app.wordcount.service.serviceprovider.WordCountServiceDelegate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Class for handling REST endpoints for word-count service.
 *
 * @author "mohan vamsi <mohanvamsi75@gmail.com>"
 */
@RestController
@Log4j2
@Api("Rest endpoints for word-count service.")
@RequestMapping("/api")
public class WordCountServiceController {

    @Autowired
    private WordCountServiceDelegate wordCountServiceDelegate;

    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    /**
     * Rest Endpoint to get the count of a given word.
     * @param word
     * @return {@link ResponseEntity<WordCountResponse>}
     */
    @ApiOperation("Rest endpoint to get the count of a given word.")
    @GetMapping(path="/word/{wordVariable}")
    public ResponseEntity<WordCountResponse> getWordCount(@PathVariable("wordVariable") String word){
        log.traceEntry("{}",word);
        Integer count = wordCountServiceDelegate.getWordCount(word);
        return log.traceExit(ResponseEntity.ok(new WordCountResponse(word, count)));
    }

    /**
     * Rest Endpoint to inset a word.
     * @param word
     * @return {@link ResponseEntity}
     */
    @ApiOperation("Rest endpoint to insert a word.")
    @PutMapping(path="/word/{wordVariable}")
    public ResponseEntity putWord(@PathVariable("wordVariable") String word){
        log.traceEntry("{}", word);
        wordCountServiceDelegate.insertWord(word);
        return log.traceExit(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(String.format("%s in inserted", word)));
    }
}
