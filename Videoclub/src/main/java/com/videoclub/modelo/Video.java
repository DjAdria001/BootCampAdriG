package com.videoclub.modelo;

public class Video {
    private int id;
    private String title;
    private String director;
    private int cliId;

    public Video(int id, String title, String director, int cliId) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.cliId = cliId;
    }

}
