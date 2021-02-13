package com.app.wordcount.service.serviceprovider;

import com.app.wordcount.service.repository.WordCountRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordCountServiceDelegate {

    @Autowired
    private WordCountRespositoryImpl wordCountRespositoryImpl;

    public Integer getWordCount(String word){
        Integer wordCount = wordCountRespositoryImpl.getWordCount(word);
        if(wordCount==null) wordCount=0;
        return wordCount;
    }

    public void insertWord(String word){
        Integer wordCount = getWordCount(word);
        if(wordCount==0) wordCountRespositoryImpl.insertNewWord(word);
        else wordCountRespositoryImpl.incrementWordCount(word);
    }
}
