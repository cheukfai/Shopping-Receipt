package shop.parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import shop.model.Product;
import shop.model.ShoppingReceipt;
import shop.parser.impl.CustomerInputParserImpl;

public class CustomerInputParserTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
	
    @Test
    public void CaseNormalParse() {
    	String input = "Location: CA, 1 book at 17.99, 1 potato chips at 3.99, 12 coke at 0.99";
    	CustomerInputParser inpurParser = new CustomerInputParserImpl();
    	ShoppingReceipt praseReceipt = inpurParser.parse(input);
    	
    	ShoppingReceipt genReceipt = new ShoppingReceipt();
    	genReceipt.setLocation("CA");
    	List<Product> productList = new ArrayList<Product>();
    	Product a = new Product("book",17.99,1);
    	Product b = new Product("potato chips",3.99,1);
    	Product c = new Product("coke",0.99,12);
    	productList.add(a);
    	productList.add(b);
    	productList.add(c);
    	genReceipt.setProductList(productList);
    	
    	Assert.assertEquals(praseReceipt.toString(), genReceipt.toString());
       
    }

    @Test
    public void CaseWrongFormatParse() {
    	exceptionRule.expect(IllegalArgumentException.class);
    	String input = "Location: CA";
    	CustomerInputParser inpurParser = new CustomerInputParserImpl();
    	ShoppingReceipt praseReceipt = inpurParser.parse(input);
    }
}
