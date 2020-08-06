package shop.service;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import shop.model.CountryEnum;
import shop.model.CountryInfo;

public interface ConfigService {
	public HashMap<String,String> readProductCategory() throws JsonParseException, JsonMappingException, IOException;
	public CountryInfo readTaxInfo(CountryEnum countryEnum) throws JsonParseException, JsonMappingException, IOException;
}
