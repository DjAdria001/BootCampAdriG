package com.arcade.tetris.service;

import com.arcade.tetris.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;

    public Score saveScore(Score score) {
        return repository.save(score);
    }

    public List<Score> getTopScores() {
        return repository.findAll()
                         .stream()
                         .sorted((a, b) -> Integer.compare(b.getPoints(), a.getPoints()))
                         .limit(10)
                         .toList();
    }
}