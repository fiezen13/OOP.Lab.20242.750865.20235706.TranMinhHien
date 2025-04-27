package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();	//create a new cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers" ,87, 24.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 19.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		// Thêm từng DVD (phiên bản gốc)
        anOrder.addDigitalVideoDisc(dvd1);
        // Thêm mảng DVD (overload 1)
        DigitalVideoDisc[] dvdArray = {dvd2, dvd3};
        anOrder.addDigitalVideoDisc(dvdArray);

        // Thêm 2 DVD (o)
        anOrder.addDigitalVideoDisc(
            new DigitalVideoDisc("Inception", "Sci-Fi", 20.99f),
            new DigitalVideoDisc("Frozen", "Animation", 17.99f)
        );
        
        printCartItems(anOrder);
        anOrder.print();
	}
	
	public static void printCartItems(Cart c) {
		DigitalVideoDisc[] items = c.getItemsOrdered();	//get list private
		int qty = c.getQtyOrdered();	//get private qtyOrdered
		System.out.println("The current list");
		if(qty==0) {
			System.out.println("Cart Empty!");
		} else {
			System.out.println("The number of items: " + qty);
			for(int i = 0; i < qty; i++) {
				DigitalVideoDisc dvd = items[i];
				System.out.printf("%d. %s/%s/Cost: %.2f\n", i+1, dvd.getTitle(), dvd.getCategory(), dvd.getCost());
			}
			System.out.println("Total Cost: " + c.totalCost());
		}
	}
}

