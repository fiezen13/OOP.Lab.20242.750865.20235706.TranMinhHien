package hust.soict.hedspi.aims.media;

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
        return length == track.length && title.equalsIgnoreCase(track.title);
    }

    //play() method
    @Override
    public void play() {
        System.out.println("Playing Track: " + this.title);
        System.out.println("Track length: " + this.length);
    }
}