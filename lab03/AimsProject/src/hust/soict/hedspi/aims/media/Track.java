package hust.soict.hedspi.aims.media;

import java.util.Objects;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    // COnstructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // OVerride equals to compare tracks by title and length
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false;

        Track track = (Track) obj;
        return Objects.equals(title, track.title) && length == track.length; 
    }

    //play() method
    @Override
    public StringBuffer play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());

            StringBuffer info = new StringBuffer("");
            info.append("Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength());
            return info;
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

    }
}