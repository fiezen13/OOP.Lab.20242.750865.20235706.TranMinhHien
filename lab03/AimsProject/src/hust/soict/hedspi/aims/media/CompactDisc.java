package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }

    // Add a track
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track added successfully.");
        }
    }

    // Remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully.");
        } else {
            System.out.println("Track does not exist in the list.");
        }
    }

    // Calculate total length
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Implement play() method
    @Override
    public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        for (Track track : tracks) {
            track.play();
        }
    }
}