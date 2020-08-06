package shop.entry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import shop.model.CountryEnum;
import shop.model.CountryInfo;
import shop.model.ShoppingReceipt;
import shop.parser.CustomerInputParser;
import shop.parser.impl.CustomerInputParserImpl;
import shop.service.ConfigService;
import shop.service.impl.ConfigServiceImpl;
import shop.utils.ReceiptPrinter;
import shop.utils.ShoppingReceiptUtils;

public class Main {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ConfigService configService = new ConfigServiceImpl();
		CountryInfo countryInfo = configService.readTaxInfo(CountryEnum.US);
		HashMap<String,String> productCatMap = configService.readProductCategory();
		//System.out.println(configService.readTaxInfo(CountryEnum.US));
		//System.out.println(configService.readProductCategory());
		ShoppingReceiptUtils shoppingReceiptUtils = new ShoppingReceiptUtils(countryInfo, productCatMap);
		
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		//String input = "Location: NY, 2 pencils at 2.99, 1 shirt at 29.99";
		String input = scanner.nextLine();
		CustomerInputParser inpurParser = new CustomerInputParserImpl();
		ShoppingReceipt receipt = inpurParser.parse(input);
		
		
		shoppingReceiptUtils.generateCompleteReceipt(receipt);
		
		ReceiptPrinter printer = new ReceiptPrinter();
		
		printer.printShoppingReceipt(receipt);
		
	}

}
