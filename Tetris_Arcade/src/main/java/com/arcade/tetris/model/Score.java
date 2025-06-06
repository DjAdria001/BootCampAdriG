package com.arcade.tetris.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("scores")
public class Score {

    @Id
    private String id;
    private String initials;
    private int points;

    public Score() {}

    public Score(String initials, int points) {
        this.initials = initials;
        this.points = points;
    }

    public String getId() { return id; }
    public String getInitials() { return initials; }
    public void setInitials(String initials) { this.initials = initials; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
}