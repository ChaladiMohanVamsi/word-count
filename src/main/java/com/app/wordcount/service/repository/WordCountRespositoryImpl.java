package com.app.wordcount.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class WordCountRespositoryImpl implements WordCountRespository{

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;
    private ValueOperations valueOperations;

    public WordCountRespositoryImpl(RedisTemplate<String, Integer> redisTemplate) {
        this.redisTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void insertNewWord(String word) {
        valueOperations.set(word, 1);
    }

    @Override
    public Integer getWordCount(String word) {
        return (Integer) valueOperations.get(word);
    }

    @Override
    public void incrementWordCount(String word) {
        valueOperations.increment(word);
    }
}
