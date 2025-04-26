package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.store.*;

public class StoreTest {
    public static void main(String[] args) {
        // Create a store
        Store store = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");

        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);

        // Display DVDs in the store
        store.displayStore();

        // Remove a DVD from the store
        store.removeDVD(dvd1);

        // Try to remove a DVD that is not in the store
        store.removeDVD(dvd3);

        // Display DVDs in the store again
        store.displayStore();
    }
}