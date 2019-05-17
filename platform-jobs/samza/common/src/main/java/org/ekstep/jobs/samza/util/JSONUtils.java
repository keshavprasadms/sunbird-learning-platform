package org.ekstep.jobs.samza.util;

import com.typesafe.config.ConfigFactory;
import org.apache.samza.config.Config;
import org.codehaus.jackson.map.ObjectMapper;
import org.ekstep.common.Platform;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JSONUtils {
	
	private static ObjectMapper mapper = new ObjectMapper();;

	public static String serialize(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void loadProperties(Config config){
		Map<String, Object> props = new HashMap<String, Object>();
		for (Entry<String, String> entry : config.entrySet()) {
			props.put(entry.getKey(), entry.getValue());
		}
		com.typesafe.config.Config conf = ConfigFactory.parseMap(props);
		Platform.loadProperties(conf);
	}
}