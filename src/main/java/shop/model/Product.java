package shop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	@JsonProperty("productName")
	private String productName;
	
	@JsonProperty("price")
	private Double price;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
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
	
}
