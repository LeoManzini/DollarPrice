package br.com.leomanzini.dollar.price.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.leomanzini.dollar.price.dto.DollarResponse;
import br.com.leomanzini.dollar.price.utils.Convert;
import br.com.leomanzini.dollar.price.utils.PropertiesLoader;

@Service
public class DollarPriceService {
	
	@Autowired
	private DollarPriceRepository dollarRepository;
	
	public DollarResponse getRealTimeDollarPrice() throws Exception {
		
		try {
			PropertiesLoader.load();
			
			URL url = new URL(PropertiesLoader.getRealTimeUrl());
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	
	        if (connection.getResponseCode() != 200) {
	            throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
	        }
	
	        BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
	        String jsonEmString = Convert.jsonIntoString(response);
	
	        Gson gson = new Gson();
	        DollarResponse returnObject = gson.fromJson(jsonEmString, DollarResponse.class);
			
			return returnObject;
		} catch(Exception e) {
			throw new NoSuchMethodException("Access level not found by this ID: ");
		}
	}
}
