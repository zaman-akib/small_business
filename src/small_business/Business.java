package small_business;
import java.util.ArrayList;

public class Business {
	private ArrayList<Product> products;
	private static int availableBalance;
	
	public Business() {
		products = new ArrayList<Product>();
		availableBalance = 0;
	}
	
	public void addProduct(Product product) {
		getProducts().add(product);
		System.out.println(product.getName() + " has been added successfully.");
	}
	
	public void deleteProduct(int i) {
		String name = getProducts().get(i).getName();
		getProducts().remove(i);
		System.out.println(name + " has been deleted successfully.");
	}
	
	public void buyProduct(int i, int amount) {
		if(availableBalance < getProducts().get(i).getBuyPrice() * amount) {
			System.out.println("Sorry!!! " + amount + " prodcuts cannot be bought due to the shortage of available balance.");
		}
		else {
			getProducts().get(i).availableNumberInventory += amount;
			availableBalance -= getProducts().get(i).getBuyPrice() * amount;
			System.out.println(getProducts().get(i).getName() + " has been bought successfully.");
		}	
	}
	
	public void sellProduct(int i, int amount) {
		if(amount > getProducts().get(i).availableNumberInventory) {
			System.out.println("Sorry!!! " + amount + " products are not availbe in inventory.");
		}
		else {
			int profit = getProducts().get(i).getSellPrice() - getProducts().get(i).getBuyPrice();
			getProducts().get(i).totalProfit += profit * amount;
			availableBalance += profit * amount;
			getProducts().get(i).availableNumberInventory -= amount;
			System.out.println(getProducts().get(i).getName() + " has been sold successfully.");
		}
	}
	
	public void displayAllProducts() {
		if(getProducts().size() == 0) {
			System.out.println("No product found!!!");
		}
		else {
			System.out.println("Showing the list of all products- ");
			System.out.println("Product Name\t\t" + "Stock Available\t\t" + "Total Profit");
			System.out.println("------------\t\t" + "---------------\t\t" + "------------");
			for(Product p : getProducts()) {
				System.out.println(p.getName() + "\t\t\t" + p.availableNumberInventory + "\t\t\t" + p.totalProfit);
			}
		}
	}
	
	
	public void showAvailableBalance() {
		System.out.println("Available Balance: " + availableBalance);
	}
	
	public void showProductNames() {
		if(getProducts().size() == 0) {
			System.out.println("No product found!!!");
		}
		else {
			int i = 1;
			for(Product p : getProducts()) {
				System.out.println("\t" + i + ". " + p.getName());
				i++;
			}
		}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

}
