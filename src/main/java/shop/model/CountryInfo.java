package shop.model;

import java.util.List;

public class CountryInfo {
	private String country;
	private List<RegionTaxIDetail> regionTaxDetails;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<RegionTaxIDetail> getRegionTaxDetails() {
		return regionTaxDetails;
	}
	public void setRegionTaxDetails(List<RegionTaxIDetail> regionTaxDetails) {
		this.regionTaxDetails = regionTaxDetails;
	}
	@Override
	public String toString() {
		return "CountryInfo [country=" + country + ", regionTaxDetails=" + regionTaxDetails + "]";
	}

	
	
	
}
