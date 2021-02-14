package com.app.wordcount.service.repository;

public interface WordCountRespository {

    void insertNewWord(String word);
    Integer getWordCount(String word);
    void incrementWordCount(String word);
}
