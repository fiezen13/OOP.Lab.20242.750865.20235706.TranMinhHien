package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor
    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    // Getters
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}