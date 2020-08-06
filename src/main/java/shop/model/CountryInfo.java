package shop.model;

import java.util.HashMap;

public class CountryInfo {
	private String country;
	private HashMap<String, RegionTaxIDetail> regionTaxDetailMap;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public HashMap<String, RegionTaxIDetail> getRegionTaxDetailMap() {
		return regionTaxDetailMap;
	}
	public void setRegionTaxDetailMap(HashMap<String, RegionTaxIDetail> regionTaxDetailMap) {
		this.regionTaxDetailMap = regionTaxDetailMap;
	}
	@Override
	public String toString() {
		return "CountryInfo [country=" + country + ", regionTaxDetailMap=" + regionTaxDetailMap + "]";
	}

	
	
	
}
