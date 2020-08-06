package shop.model;

import java.util.List;

public class RegionTaxIDetail {
	private String regionName;
	private Double taxRate;
	private List<String> exemptProductList;
	
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}
	public List<String> getExemptProductList() {
		return exemptProductList;
	}
	public void setExemptProductList(List<String> exemptItemList) {
		this.exemptProductList = exemptItemList;
	}
	@Override
	public String toString() {
		return "RegionTaxIDetail [regionName=" + regionName + ", taxRate=" + taxRate + ", exemptProductList="
				+ exemptProductList + "]";
	}
	
	
}
