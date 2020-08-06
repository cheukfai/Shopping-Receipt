package shop.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shop.model.Product;
import shop.model.ShoppingReceipt;
import shop.parser.CustomerInputParser;

public class CustomerInputParserImpl implements CustomerInputParser{
	private final Logger logger = LogManager.getLogger(CustomerInputParser.class);
	private static final String locationPattern = "Location: (.*)";
	private static final String productPattern = "^[0-9]* ([a-zA-z]* )*at [0-9]*(\\.[0-9]*)?$";
	
	public ShoppingReceipt parse(String input) {
		// "Location: CA, 1 book at 17.99, 1 potato chips at 3.99";
		ShoppingReceipt receipt = new ShoppingReceipt();
		String[] split = input.split(",");
		String location = this.findLocation(split[0]);
		receipt.setLocation(location);
		List<Product> productList = new ArrayList<Product>();
		for (int i=1; i<split.length; i++){
			String productString = split[i].trim();  // "17 potato chips at 17.99"
			if (!isProductValid(productString)){
				logger.error("productString not valid!");
				throw new IllegalArgumentException("productString not valid");
			}
			
			String[] productDetail = productString.split(" at "); // "17 potato chips", "17.99"
			List<String> productQtyAndName = Arrays.asList(productDetail[1].split(" ")); // "17","potato","chips"

			Integer quantity = Integer.parseInt(productQtyAndName.get(0));

			productQtyAndName.remove(0); //"potato","chips"
			
			String productName = String.join("", productQtyAndName);

			Double price = Double.parseDouble(productDetail[1]);
			Product product = new Product(productName, price, quantity );
			productList.add(product);
		}
		
		receipt.setProductList(productList);
		
		return receipt; 
		
	}
	
	private String findLocation(String locationString){
		String location = "";
		Pattern p = Pattern.compile(locationPattern);
		Matcher m = p.matcher(locationString);
		if ( m.find() ) {
			location = m.group(1);
		}
		return location;
	}
	
	private static boolean isProductValid(String productString){
		Pattern p = Pattern.compile(productPattern);
		Matcher m = p.matcher(productString);
		if ( m.find() ) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] arg){
		System.out.print(isProductValid("17 powefweftato chips at 17"));
	}
	
}
