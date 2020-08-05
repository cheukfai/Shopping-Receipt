package shop.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingReceipt {
	@JsonProperty("productList")
	private String location;

	@JsonProperty("productList")
	private List<Product> productList;
	
	private Double tax;
	private Double calSubTotal;
	private Double calTax;
	private Double calTotal;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Double getCalSubTotal() {
		return calSubTotal;
	}
	public void setCalSubTotal(Double calSubTotal) {
		this.calSubTotal = calSubTotal;
	}
	public Double getCalTax() {
		return calTax;
	}
	public void setCalTax(Double calTax) {
		this.calTax = calTax;
	}
	public Double getCalTotal() {
		return calTotal;
	}
	public void setCalTotal(Double calTotal) {
		this.calTotal = calTotal;
	}
	
	
}
