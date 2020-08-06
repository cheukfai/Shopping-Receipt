package shop.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import shop.model.CountryEnum;
import shop.model.CountryInfo;
import shop.service.ConfigService;

public class ConfigServiceImpl implements ConfigService {

	public HashMap<String, String> readProductCategory() throws JsonParseException, JsonMappingException, IOException {
		HashMap<String,String> productMap = new HashMap<String, String>();
		Properties properties = new Properties();
		properties.load(getClass().getResourceAsStream("/data/productCategoryMap.conf"));
	
		for (String key : properties.stringPropertyNames()) {
		    String value = properties.getProperty(key);
		    productMap.put(key, value);
		}

		return productMap;
	}

	public CountryInfo readTaxInfo(CountryEnum countryEnum) throws JsonParseException, JsonMappingException, IOException {
		
		String fileName = countryEnum.name()+"TaxInfo.yaml";
		InputStream inputStream = getClass()
				.getClassLoader().getResourceAsStream("data/"+fileName);
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		CountryInfo countryInfo = mapper.readValue(inputStream, CountryInfo.class);

		return countryInfo;
	}

}
