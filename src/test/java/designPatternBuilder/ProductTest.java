package designPatternBuilder;

public class ProductTest {

	public static void main(String[] args) {

		// UC: only mandatory fields
		Product p = new Product.ProductBuilder("apple", 1000).build();
		System.out.println(p.toString());

		// UC2: mandatory + non-mandatory fields
		Product p1 = new Product.ProductBuilder("Samsung", 500).setCategory("Mbile").setDescription("this is mobile")
				.setDiscount(10).setFreeShipping(false).setStock(10).build();
		System.out.println(p1.toString());

		p1.setDiscount(20);
		System.out.println(p1.toString());

		System.out.println(p1.getCategory());
		
		// UC 3: 
		Product p2 = new Product.ProductBuilder("shorts", 100).setCategory("fashion").setFreeShipping(true).setStock(1)
				.build();
		System.out.println(p2);

		p2.setDescription("this is good shorts");
		System.out.println(p2);
	}

}
