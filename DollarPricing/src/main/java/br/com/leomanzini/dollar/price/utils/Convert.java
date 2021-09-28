package br.com.leomanzini.dollar.price.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Convert {
	
	public static String jsonIntoString(BufferedReader buffereReader) throws IOException {
        
		String response = "";
        String jsonToString = "";
        
        while ((response = buffereReader.readLine()) != null) {
            jsonToString += response;
        }
        return jsonToString;
    }
}
