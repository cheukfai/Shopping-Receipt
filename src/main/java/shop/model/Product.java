package shop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	private String productName;
	private Double price;
	private Integer quantity;
	
	
	
	public Product(String productName, Double price, Integer quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product() {
		
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
}
