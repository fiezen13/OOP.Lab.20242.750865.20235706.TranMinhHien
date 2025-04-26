package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.*;

import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc disc) {
        if (disc != null) {
            itemsInStore.add(disc);
            System.out.println("The DVD has been added to the store: " + disc.getTitle());
        } else {
            System.out.println("Cannot add a null DVD to the store.");
        }
    }

    // Method to remove a DVD from the store
    public void removeDVD(DigitalVideoDisc disc) {
        if (itemsInStore.contains(disc)) {
            itemsInStore.remove(disc);
            System.out.println("The DVD has been removed from the store: " + disc.getTitle());
        } else {
            System.out.println("The DVD is not available in the store.");
        }
    }

    // Method to display all DVDs in the store
    public void displayStore() {
        System.out.println("Items currently in the store:");
        for (DigitalVideoDisc disc : itemsInStore) {
            System.out.println("- " + disc.getTitle());
        }
    }
}