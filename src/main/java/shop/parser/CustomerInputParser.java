package shop.parser;

import shop.model.ShoppingReceipt;

public interface CustomerInputParser {
	public ShoppingReceipt parse(String input);
	
}
