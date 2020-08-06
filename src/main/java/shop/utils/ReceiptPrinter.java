package shop.utils;

import java.text.DecimalFormat;

import shop.model.Product;
import shop.model.ShoppingReceipt;

public class ReceiptPrinter {
	public void printShoppingReceipt(ShoppingReceipt receipt) {
		
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String printFormat = "%-15s%15s%15s%n";
		System.out.printf(printFormat, "item", "price", "qty");
		System.out.printf(printFormat, "", "", "");
		
		for(Product product:receipt.getProductList()) {
			System.out.printf(printFormat, product.getProductName(), "$"+decimalFormat.format(product.getPrice()), product.getQuantity());
		}
		
		System.out.printf(printFormat, "subtotal:", "", "$"+decimalFormat.format(receipt.getCalSubTotal()));
		System.out.printf(printFormat, "tax:", "", "$"+decimalFormat.format(receipt.getCalTax()));
		System.out.printf(printFormat, "total:", "", "$"+decimalFormat.format(receipt.getCalTotal()));
	

	}
}
