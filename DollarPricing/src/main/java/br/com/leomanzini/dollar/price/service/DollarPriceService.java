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
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Can't access the webpage");
		}
	}

	public List<HistoryDollarResponse> getHistoryDollarPrice(String day, String month, String year) throws Exception {

		try {
			PropertiesLoader.load();

			String date = year + month + day;

			String serviceUrl = PropertiesLoader.getHistoryUrl();
			serviceUrl = String.format(serviceUrl, date);

			URL url = new URL(serviceUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
			}

			BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			String jsonToString = Convert.jsonIntoString(response);

			Gson gson = new Gson();
			Type listType = new TypeToken<List<HistoryDollarResponse>>() {}.getType();
			List<HistoryDollarResponse> historyDollarResponse = gson.fromJson(jsonToString, listType);

			return historyDollarResponse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Can't access the webpage");
		}
	}
}
