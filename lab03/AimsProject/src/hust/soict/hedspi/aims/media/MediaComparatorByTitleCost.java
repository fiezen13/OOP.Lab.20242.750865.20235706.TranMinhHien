package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo title (alphabet)
        int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // Nếu title giống nhau, so sánh theo cost
        return Double.compare(m2.getCost(), m1.getCost());
    }
}
