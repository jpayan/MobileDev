package mx.cetys.jorgepayan.actividad1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jorge.payan on 8/25/17.
 */

public class Movie implements Parcelable{

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

    public Movie(Parcel in) {
        name = in.readString();
        duration = in.readInt();
        director = in.readString();
        genre = in.readString();
        yearOfRelease = in.readInt();
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

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(duration);
        dest.writeString(director);
        dest.writeString(genre);
        dest.writeInt(yearOfRelease);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

}
