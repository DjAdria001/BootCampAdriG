
package UD09;

public class Movie {
    public static String title;
    private int duration;
    private int minAge;
    private String director;
    private static final String FILE_NAME = "occupiedSeats"+title+".txt";
    

    public Movie(String title, int duration, int minAge, String director) {
        this.title = title;
        this.duration = duration;
        this.minAge = minAge;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getMinAge() {
        return minAge;
    }

    public String getDirector() {
        return director;
    }
}