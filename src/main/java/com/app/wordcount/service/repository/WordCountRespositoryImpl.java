package com.app.wordcount.service.repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * Data Access Layer of word-count service.
 * @author "mohan vamsi <mohanvamsi75@gmail.com>"
 */
@Log4j2
@Repository
public class WordCountRespositoryImpl implements WordCountRespository{

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;
    private ValueOperations valueOperations;

    public WordCountRespositoryImpl(RedisTemplate<String, Integer> redisTemplate) {
        this.redisTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
    }

    /**
     * Method call to insert new key value pait to redis data-store.
     * @param word
     */
    @Override
    public void insertNewWord(String word) {
        log.traceEntry();
        valueOperations.set(word, 1);
        log.traceExit();
    }

    /**
     * Method call to get the value of key in redis data-store.
     * @param word
     * @return {@link Integer}
     */
    @Override
    public Integer getWordCount(String word) {
        log.traceEntry();
        return log.traceExit((Integer) valueOperations.get(word));
    }

    /**
     * Method call to increment value by 1 of a key in redis data-store.
     * @param word
     */
    @Override
    public void incrementWordCount(String word) {
        log.traceEntry();
        valueOperations.increment(word);
        log.traceExit();
    }
}
