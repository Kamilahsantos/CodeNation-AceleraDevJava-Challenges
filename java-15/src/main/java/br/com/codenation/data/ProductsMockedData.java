package br.com.codenation.data;

import java.util.ArrayList;
import java.util.List;

import br.com.codenation.model.Product;

public final class ProductsMockedData {

	private List<Product> products = null;
	private static ProductsMockedData instance = null;

	private ProductsMockedData() {
		this.products = new ArrayList<>();
		this.products.add(new Product(1L, "PlayStation 4 Slim 1TB Console", 250.0, false));
		this.products.add(new Product(2L, "$50 PlayStation Store Gift Card", 50.0, false));
		this.products.add(new Product(3L, "$30 PlayStation Store Gift Card", 30.0, false));
		this.products.add(new Product(4L, "$100 PlayStation Store Gift Card", 100.0, false));
		this.products.add(new Product(5L, "DualShock 4 Wireless Controller for PlayStation 4", 46.0, true));
		this.products.add(new Product(6L, "Playstation Classic Console with 20 Classic Playstation Games", 44.0, true));
		this.products.add(new Product(7L, "NBA 2K20 - PlayStation 4", 36.0, true));
		this.products.add(new Product(8L, "Nintendo Switch Lite - Turquoise", 200.0, true));
		this.products.add(new Product(9L, "Nintendo Switch Lite - Zacian and Zamazenta Edition", 240.0, false));
		this.products.add(new Product(10L,
				"Nintendo Switch with Neon Blue and Neon Red Joy‑Con HAC-001 w/ Mario Kart 8 Deluxe", 372.0, false));
		this.products.add(new Product(11L, "Nintendo Switch Pro Controller", 60.0, false));
		this.products.add(new Product(12L, "Nintendo Wii Console, White (Renewed)", 98.0, true));
		this.products.add(new Product(13L, "Xbox One S Two Controller Bundle (1TB)", 240.0, false));
		this.products
				.add(new Product(14L, "Xbox One S 1TB Console - Star Wars Jedi: Fallen Order Bundle", 227.0, false));
		this.products.add(new Product(15L, "Elite Series 2 Controller - Black", 97.0, true));
		this.products.add(new Product(16L,
				"Turtle Beach Stealth 600 Wireless Surround Sound Gaming Headset for Xbox One", 100.0, false));
		this.products.add(new Product(17L, "Elite Series 2 Controller - Black", 98.0, true));
	}

	public static ProductsMockedData getInstance() {
		if (instance == null) {
			instance = new ProductsMockedData();
		}
		return instance;
	}

	public List<Product> allProducts() {
		return this.products;
	}

}