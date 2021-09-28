package br.com.leomanzini.dollar.price.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.leomanzini.dollar.price.dto.response.HistoryDollarResponse;
import br.com.leomanzini.dollar.price.dto.response.RealTimeDollarResponse;
import br.com.leomanzini.dollar.price.enums.ReturnCodes;
import br.com.leomanzini.dollar.price.exceptions.GeneralException;
import br.com.leomanzini.dollar.price.exceptions.HistoryDollarPriceException;
import br.com.leomanzini.dollar.price.exceptions.RealTimeDollarPriceException;
import br.com.leomanzini.dollar.price.utils.Convert;
import br.com.leomanzini.dollar.price.utils.PropertiesLoader;

@Service
public class DollarPriceService {

	public RealTimeDollarResponse getRealTimeDollarPrice() throws Exception {

		try {
			loadProperties();
			
			HttpURLConnection connection = getServiceConnection(PropertiesLoader.getRealTimeUrl());

			String jsonToString = getServiceString(connection);

			RealTimeDollarResponse returnObject = getGsonRealTimeDollarPriceResponse(jsonToString);

			return returnObject;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RealTimeDollarPriceException(ReturnCodes.RETURN_REAL_TIME_ERROR.getCode());
		}
	}

	public List<HistoryDollarResponse> getHistoryDollarPrice(String day, String month, String year) throws Exception {

		try {
			loadProperties();

			String date = year + month + day;
			String serviceUrl = PropertiesLoader.getHistoryUrl();
			serviceUrl = String.format(serviceUrl, date);

			HttpURLConnection connection = getServiceConnection(serviceUrl);
			String jsonToString = getServiceString(connection);

			List<HistoryDollarResponse> returnObject = getGsonHistoryDollarPriceResponse(jsonToString);

			return returnObject;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new HistoryDollarPriceException(ReturnCodes.RETURN_HISTORY_ERROR.getCode());
		}
	}

	private void loadProperties() {
		PropertiesLoader.load();
	}

	private HttpURLConnection getServiceConnection(String serviceUrl) throws Exception {
		
		try {
			URL url = new URL(serviceUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
			}
			
			return connection;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException();
		}
	}
	
	private String getServiceString(HttpURLConnection connection) throws Exception {
		
		try {
			BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			String jsonToString = Convert.jsonIntoString(response);
			
			return jsonToString;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException();
		}
	}
	
	private RealTimeDollarResponse getGsonRealTimeDollarPriceResponse(String jsonToString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonToString, RealTimeDollarResponse.class);
	}
	
	private List<HistoryDollarResponse> getGsonHistoryDollarPriceResponse(String jsonToString) {
		Gson gson = new Gson();
		Type listType = new TypeToken<List<HistoryDollarResponse>>() {}.getType();
		return gson.fromJson(jsonToString, listType);
	}
}
