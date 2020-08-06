package shop.utils;

import shop.model.Product;
import shop.model.ShoppingReceipt;

public class ReceiptPrinter {
	public void printShoppingReceipt(ShoppingReceipt receipt) {
		String formatHeader = "%-20s%15s%15s%n";
		System.out.printf(formatHeader, "item", "price", "qty");
		System.out.printf(formatHeader, "", "", "");
		
		String formatProduct = "%-20s%15s%15s%n";
		for(Product product:receipt.getProductList()) {
			System.out.printf(formatProduct, product.getProductName(), "$"+product.getPrice(), product.getQuantity());
		}
		
		String formatTotal = "%-20s%15s%15s%n";
		System.out.printf(formatTotal, "subtotal:", "", "$"+receipt.getCalSubTotal());
		System.out.printf(formatTotal, "tax:", "", "$"+receipt.getCalTax());
		System.out.printf(formatTotal, "total:", "", "$"+receipt.getCalTotal());
	

	}
}
