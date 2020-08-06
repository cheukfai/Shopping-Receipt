package shop.model;

import java.util.List;

public class CountryInfo {
	private String country;
	private List<RegionTaxIDetail> RegionTaxIDetails;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<RegionTaxIDetail> getRegionTaxIDetails() {
		return RegionTaxIDetails;
	}
	public void setRegionTaxIDetails(List<RegionTaxIDetail> regionTaxIDetails) {
		RegionTaxIDetails = regionTaxIDetails;
	}
	@Override
	public String toString() {
		return "CountryInfo [country=" + country + ", RegionTaxIDetails=" + RegionTaxIDetails + "]";
	}
	
	
}
