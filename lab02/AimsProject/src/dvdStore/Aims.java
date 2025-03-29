package dvdStore;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();	//create a new cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers" ,87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		printCartItems(anOrder);
		
		//test hàm xóa sản phẩm
		anOrder.removeDigitalVideoDisc(dvd3);
		
		printCartItems(anOrder);
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
