package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    // Constructor
    public CompactDisc(String title, String category, String director, int length, String artist, float cost) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks  = new ArrayList<>();
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
    public StringBuffer play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			
			StringBuffer info = new StringBuffer("");
			info.append("Playing CD: " + this.getTitle() + "\n" + "CD length: " + this.getLength() + "\n");
			
			for (Track t : tracks) {
				try {
					StringBuffer trackInfo = t.play();
					info.append(trackInfo + "\n");
				} catch (PlayerException e) {
					throw e;
				}
			}
			return info;
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
		
	}
    
    @Override
    public String toString() {
        return "CD: " + getTitle() + "- Category: " + getCategory() + " - Artist: " + artist + " - Cost: " + getCost() + " $";
    }
}