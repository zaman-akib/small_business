package small_business;
import java.util.Scanner;

public class Menu {
	public void showOptions(Business business) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose an option from below: ");
		System.out.println("\t1. Add a product");
		System.out.println("\t2. Delete a product");
		System.out.println("\t3. Buy a product");
		System.out.println("\t4. Sell a product");
		System.out.println("\t5. See the list of products");
		System.out.println("\t6. See available balance");
		System.out.println("\t7. Exit");
		
		int option = getValidInteger();
		int index;
		int amount;
		
		while(option < 1 || option > 7){
            System.out.println("Invalid Selection!!!");
            System.out.println("Please choose again: ");
            option = getValidInteger();
        }
		
		switch(option){
	        case 1:
	        	Product p = inputProductDetails();
	        	business.addProduct(p);
	            break;
	        case 2:
	        	if(business.getProducts().size()==0) {
	        		System.out.println("No product found!!!");
	        		break;
	        	}
	        	System.out.println("Select a product to delete: ");
	        	index = selectProduct(business);
	        	business.deleteProduct(index);
	            break;
	        case 3:
	        	if(business.getProducts().size()==0) {
	        		System.out.println("No product found!!!");
	        		break;
	        	}
	        	System.out.println("Select a product to buy: ");
	        	index = selectProduct(business);
	        	System.out.println("Number of products bought: ");
	        	amount = getValidInteger();
	        	business.buyProduct(index, amount);
	            break;
	        case 4:
	        	if(business.getProducts().size()==0) {
	        		System.out.println("No product found!!!");
	        		break;
	        	}
	        	System.out.println("Select a product to sell: ");
	        	index = selectProduct(business);
	        	System.out.println("Number of products sold: ");
	        	amount = getValidInteger();
	        	business.sellProduct(index, amount);
	            break;
	        case 5:
	        	business.displayAllProducts();
	            break;
	        case 6:
	        	business.showAvailableBalance();
	            break;
	        case 7:
	        	System.exit(0);
	            break;
	        default:
	            System.exit(0);
		}
	}
	
	public Product inputProductDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Product Name: ");
		String name = sc.next();
		System.out.print("Enter Buy Price: ");
		int buyPrice = getValidInteger();
		System.out.print("Enter Sell Price: ");
		int sellPrice = getValidInteger();
		System.out.print("Enter Available Number In Inventory: ");
		int availableNumberInventory = sc.nextInt();
		
		Product product = new Product(name, buyPrice, sellPrice, availableNumberInventory);
		return product;	
	}
	
	public int selectProduct(Business b) {
		b.showProductNames();
    	
		Scanner sc = new Scanner(System.in);
		int index = getValidInteger();
		
		System.out.println(b.getProducts().get(index-1).getName() + " selected.");
		return index-1;
	}
	
	public int getValidInteger() {
		int num;
		while(true) {
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()) {
				num = sc.nextInt();
				break;
			}	
			else {
				System.out.println("Invalid input!!! Input should be an integer value.");
				System.out.println("Please enter again: ");
			}
		}
		return num;
	}
}
