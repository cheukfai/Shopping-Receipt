package shop.model;

import java.util.List;

public class RegionTaxIDetail {
	private String regionName;
	private Double taxRate;
	private List<String> exemptItemList;
	
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
	public List<String> getExemptItemList() {
		return exemptItemList;
	}
	public void setExemptItemList(List<String> exemptItemList) {
		this.exemptItemList = exemptItemList;
	}
	@Override
	public String toString() {
		return "RegionTaxIDetail [regionName=" + regionName + ", taxRate=" + taxRate + ", exemptItemList="
				+ exemptItemList + "]";
	}
	
	
}
