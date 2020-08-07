package shop.service;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import shop.model.CountryEnum;
import shop.model.CountryInfo;
import shop.service.impl.ConfigServiceImpl;

public class ConfigServiceTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
	
    @Test
    public void CaseNormalGetTaxInfo() throws JsonParseException, JsonMappingException, IOException {
    	ConfigService configService = new ConfigServiceImpl();
    	CountryInfo countryInfo = configService.readTaxInfo(CountryEnum.US);
    }

    @Test
    public void CaseIOExceptionGetTaxInfo() throws JsonParseException, JsonMappingException, IOException{
    	exceptionRule.expect(IllegalArgumentException.class);
    	ConfigService configService = new ConfigServiceImpl();
    	configService.readTaxInfo(CountryEnum.CHINA);
    }
    
    @Test
    public void CCaseNormalGetProductCategory() throws JsonParseException, JsonMappingException, IOException {
    	ConfigService configService = new ConfigServiceImpl();
    	HashMap<String,String> productCatMap = configService.readProductCategory();
    }
}
