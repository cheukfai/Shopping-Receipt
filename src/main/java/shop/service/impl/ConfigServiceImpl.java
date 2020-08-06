package shop.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import shop.model.CountryEnum;
import shop.model.CountryInfo;
import shop.service.ConfigService;

public class ConfigServiceImpl implements ConfigService {

	public HashMap<String, String> readItemCategory() throws JsonParseException, JsonMappingException, IOException {
		InputStream inputStream = getClass()
				.getClassLoader().getResourceAsStream("/data/itemCategoryMap.txt");
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		mapper.findAndRegisterModules();
		CountryInfo countryInfo = mapper.readValue(inputStream, CountryInfo.class);

		return null;
	}

	public CountryInfo readTaxInfo(CountryEnum countryEnum) throws JsonParseException, JsonMappingException, IOException {
		
		String fileName = countryEnum.name()+"TaxInfo.yaml";
		System.out.print(fileName);
		InputStream inputStream = getClass()
				.getClassLoader().getResourceAsStream("data/"+fileName);
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		CountryInfo countryInfo = mapper.readValue(inputStream, CountryInfo.class);

		return countryInfo;
	}

}
