package br.com.leomanzini.dollar.price.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.leomanzini.dollar.price.dto.response.RealTimeDollarResponse;
import br.com.leomanzini.dollar.price.utils.Convert;
import br.com.leomanzini.dollar.price.utils.PropertiesLoader;

@Service
public class DollarPriceService {
	
	public RealTimeDollarResponse getRealTimeDollarPrice() throws Exception {
		
		try {
			PropertiesLoader.load();
			
			URL url = new URL(PropertiesLoader.getRealTimeUrl());
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	
	        if (connection.getResponseCode() != 200) {
	            throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
	        }
	
	        BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
	        String jsonToString = Convert.jsonIntoString(response);
	
	        Gson gson = new Gson();
	        RealTimeDollarResponse returnObject = gson.fromJson(jsonToString, RealTimeDollarResponse.class);
			
			return returnObject;
		} catch(Exception e) {
			throw new Exception("Can't access the webpage");
		}
	}
}
