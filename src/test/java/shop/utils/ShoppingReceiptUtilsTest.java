package shop.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import shop.model.CountryEnum;
import shop.model.CountryInfo;
import shop.model.Product;
import shop.model.ShoppingReceipt;
import shop.parser.CustomerInputParser;
import shop.parser.impl.CustomerInputParserImpl;
import shop.service.ConfigService;
import shop.service.impl.ConfigServiceImpl;

public class ShoppingReceiptUtilsTest {
    @Test
    public void CaseNormal() throws JsonParseException, JsonMappingException, IOException {
    	ConfigService configService = new ConfigServiceImpl();
		CountryInfo countryInfo = configService.readTaxInfo(CountryEnum.US);
		HashMap<String,String> productCatMap = configService.readProductCategory();
		ShoppingReceiptUtils shoppingReceiptUtils = new ShoppingReceiptUtils(countryInfo, productCatMap);
		
    	List<Product> productList = new ArrayList<Product>();
    	Product a = new Product("book",17.99,1);
    	Product b = new Product("potato chips",3.99,1);
    	productList.add(a);
    	productList.add(b);
		
    	ShoppingReceipt receipt = new ShoppingReceipt();
    	receipt.setLocation("CA");
    	receipt.setProductList(productList);
		shoppingReceiptUtils.generateCompleteReceipt(receipt);
		
		
    	ShoppingReceipt genReceipt = new ShoppingReceipt();
    	genReceipt.setLocation("CA");
    	genReceipt.setProductList(productList);
    	genReceipt.setCalSubTotal(21.98);
    	genReceipt.setCalTax(1.80);
    	genReceipt.setCalTotal(23.78);
    	
    	
        Assert.assertEquals(receipt.toString(),genReceipt.toString());
    }

    @Test
    public void CaseNotEqual() throws JsonParseException, JsonMappingException, IOException {
    	ConfigService configService = new ConfigServiceImpl();
		CountryInfo countryInfo = configService.readTaxInfo(CountryEnum.US);
		HashMap<String,String> productCatMap = configService.readProductCategory();
		ShoppingReceiptUtils shoppingReceiptUtils = new ShoppingReceiptUtils(countryInfo, productCatMap);
		
    	List<Product> productList = new ArrayList<Product>();
    	Product a = new Product("book",17.99,1);
    	Product b = new Product("potato chips",3.99,1);
    	productList.add(a);
    	productList.add(b);
		
    	ShoppingReceipt receipt = new ShoppingReceipt();
    	receipt.setLocation("CA");
    	receipt.setProductList(productList);
		shoppingReceiptUtils.generateCompleteReceipt(receipt);
		
		
    	ShoppingReceipt genReceipt = new ShoppingReceipt();
    	genReceipt.setLocation("CA");
    	genReceipt.setProductList(productList);
    	genReceipt.setCalSubTotal(21.98);
    	genReceipt.setCalTax(1.80);
    	genReceipt.setCalTotal(25.00);
    	
    	
        Assert.assertNotEquals(receipt.toString(),genReceipt.toString());
    }
}
