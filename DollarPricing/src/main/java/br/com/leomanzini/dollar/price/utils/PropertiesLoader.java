package br.com.leomanzini.dollar.price.utils;

import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PropertiesLoader {
	
	private static final Logger LOG = LogManager.getLogger(PropertiesLoader.class);

	private static final String PROPERTIES_REAL_TIME_URL = "real.time.dollar.price";
	private static final String PROPERTIES_HISTORY_URL = "history.dollar.price";
	private static final String PROPERTIES_PATH = "/application.properties";

	private static String realTimeUrl;
	private static String historyUrl;

	private PropertiesLoader() {
	}

	public static void load() {

		Properties props = new Properties();

		try {
			InputStream fins = PropertiesLoader.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH);
			
			if(fins!=null) {
                props.load(fins);
			}
			
			//props.load(new FileInputStream(PROPERTIES_PATH));

			realTimeUrl = props.getProperty(PROPERTIES_REAL_TIME_URL);
			historyUrl = props.getProperty(PROPERTIES_HISTORY_URL);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			System.exit(-1);
		}
	}

	public static String getRealTimeUrl() {
		return realTimeUrl;
	}
	
	public static String getHistoryUrl() {
		return historyUrl;
	}
}
