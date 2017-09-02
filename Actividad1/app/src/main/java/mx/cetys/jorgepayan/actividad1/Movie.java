package mx.cetys.jorgepayan.actividad1;

/**
 * Created by jorge.payan on 8/25/17.
 */

public class Movie {

    private String name;
    private int duration;
    private String director;
    private String genre;
    private int yearOfRelease;

    public Movie(String name, int duration, String director, String genre, int yearOfRelease) {
        this.name = name;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
