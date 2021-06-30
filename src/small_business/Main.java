package small_business;

public class Main {

	public static void main(String[] args) {
		Business business1 = new Business();
		
		Menu menu = new Menu();
		
		while(true) {
			menu.showOptions(business1);
		}
	}
}
