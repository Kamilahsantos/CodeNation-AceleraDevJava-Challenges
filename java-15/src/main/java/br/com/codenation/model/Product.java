package br.com.codenation.model;

public class Product {

	private Long id;

	private String name;

	private Double value;

	private Boolean isSale;

	public Product(Long id, String name, Double value, Boolean isSale) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.isSale = isSale;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getValue() {
		return value;
	}

	public Boolean getIsSale() {
		return isSale;
	}

}
