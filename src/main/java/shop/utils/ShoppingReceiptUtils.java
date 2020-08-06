package shop.utils;

import java.util.HashMap;

import shop.model.CountryInfo;
import shop.model.Product;
import shop.model.RegionTaxIDetail;
import shop.model.ShoppingReceipt;

public class ShoppingReceiptUtils {
	private CountryInfo countryInfo;
	private HashMap<String, String> productCatMAp;
	
	public ShoppingReceiptUtils(CountryInfo countryInfo, HashMap<String, String> productCatMAp) {
		super();
		this.countryInfo = countryInfo;
		this.productCatMAp = productCatMAp;
	}
	
	public void generateCompleteReceipt(ShoppingReceipt receipt) {
		Double subtotal = 0.0;
		Double tax = 0.0;
		Double total = 0.0;
		
		for(Product product: receipt.getProductList()) {
			subtotal = subtotal + product.getPrice() * product.getQuantity();
			String prodcutType = productCatMAp.get(product.getProductName().replaceAll("\\s+",""));
			RegionTaxIDetail regionTaxIDetail = countryInfo.getRegionTaxDetailMap().get(receipt.getLocation());
			
			Boolean isExempt = false;
			for(String type:regionTaxIDetail.getExemptProductList()) {
				if(type.equalsIgnoreCase(prodcutType)) {
					isExempt = true;
					break;
				}
			}
			if(!isExempt) {
				tax = tax +  product.getPrice() * product.getQuantity() * (regionTaxIDetail.getTaxRate() / 100.0);
			}
			
		}
		
		tax = Math.ceil(tax * 20.0) / 20.0; // rounded up to the nearest 0.05 
		subtotal = Math.round(subtotal * 100.0) / 100.0; // rounded up to 2 decimal places
		total = tax + subtotal;
		total = Math.round(total * 100.0) / 100.0; // rounded up to 2 decimal places
		
		receipt.setCalTax(tax);
		receipt.setCalSubTotal(subtotal);
		receipt.setCalTotal(total);
		
	}
	
}
