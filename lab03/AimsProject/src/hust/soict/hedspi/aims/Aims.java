package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class Aims {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        // Add different types of Media to the list
        mediaList.add(new Book(101, "Java Basics", "Education", 10.5f));
        mediaList.add(new DigitalVideoDisc(102, "Inception"));
        mediaList.add(new CompactDisc(103, "Top Hits", "Music", 15.0f, 0, "Various Artists", null));

        // Iterate through the list and print information using toString()
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}