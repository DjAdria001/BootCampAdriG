package com.arcade.tetris.controller;

import com.arcade.tetris.model.Score;
import com.arcade.tetris.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PostMapping
    public Score save(@RequestBody Score score) {
        return service.saveScore(score);
    }

    @GetMapping
    public List<Score> getTop() {
        return service.getTopScores();
    }
}