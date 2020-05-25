package br.com.codenation.model;

public class OrderItem {

	private Long productId;
	private Long quantity;
	
	public OrderItem(Long productId, Long quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public Long getQuantity() {
		return quantity;
	}
}
