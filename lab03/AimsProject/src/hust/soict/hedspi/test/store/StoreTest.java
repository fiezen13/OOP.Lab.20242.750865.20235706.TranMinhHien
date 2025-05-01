package hust.soict.hedspi.test.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.*;

public class StoreTest {
    public static void main(String[] args) {
        // Create a store
        Store store = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(0, "The Lion King", null, null, 0, 0);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(1, "Star Wars", null, null, 0, 0);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(2, "Aladdin", null, null, 0, 0);

        // Add DVDs to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);

        // Display DVDs in the store
        store.displayStore();

        // Remove a DVD from the store
        store.removeMedia(dvd1);

        // Try to remove a DVD that is not in the store
        store.removeMedia(dvd3);

        // Display DVDs in the store again
        store.displayStore();
    }
}