package small_business;

public class Product {
	private String name;
	private int buyPrice;
	private int sellPrice;
	int availableNumberInventory;
	int totalProfit;
	
	public Product(String name, int buyPrice, int sellPrice, int availableNumberInventory) {
		this.name = name;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.availableNumberInventory = availableNumberInventory;
		totalProfit = 0;
	}

	public String getName() {
		return name;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}
	
	public void productDetails() {
		System.out.println("Product Name: " + name);
		System.out.println("Buy Price: " + buyPrice);
		System.out.println("Sell Price: " + sellPrice);
		System.out.println("Available number in inventory to sell: " + availableNumberInventory);
		System.out.println("Total profit: " + totalProfit);
	}
}
