package shop.entry;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import shop.model.CountryEnum;
import shop.service.ConfigService;
import shop.service.impl.ConfigServiceImpl;

public class Main {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ConfigService configService = new ConfigServiceImpl();
		System.out.println(configService.readTaxInfo(CountryEnum.US));
		System.out.println(configService.readItemCategory());
		
	}

}
