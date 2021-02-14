package com.app.wordcount.service.serviceprovider;

import com.app.wordcount.service.repository.WordCountRespositoryImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Business logic layer for word-count service.
 * @author "mohan vamsi <mohanvamsi75@gmail.com>"
 */
@Log4j2
@Component
public class WordCountServiceDelegate {

    @Autowired
    private WordCountRespositoryImpl wordCountRespositoryImpl;

    /**
     * Method to return the count of a given word.
     * @param word
     * @return {@link Integer }
     */
    public Integer getWordCount(String word){
        log.traceEntry("{}",word);
        Integer wordCount = wordCountRespositoryImpl.getWordCount(word);
        if(wordCount==null) wordCount=0;
        return log.traceExit(wordCount);
    }

    /**
     * Method to insert a word by verifying if it already exists.
     * @param word
     */
    public void insertWord(String word){
        log.traceEntry("{}", word);
        Integer wordCount = getWordCount(word);
        //wordCount is 0 implies that word is not already present in data store, So insert new word.
        if(wordCount==0) wordCountRespositoryImpl.insertNewWord(word);
        //Word already exists, So increment the existing count.
        else wordCountRespositoryImpl.incrementWordCount(word);
        log.traceExit();
    }
}
