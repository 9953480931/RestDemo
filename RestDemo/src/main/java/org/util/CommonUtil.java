package org.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {

	/**
	 * convert entity to json String using jackson api
	 * 
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String convertFromEntityToJsonStr(Object obj)
			throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(obj);

	}

	/**
	 * convert json String to object using jackson api.
	 * 
	 * @param clazz
	 * @param jsonStr
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Object convertFromJsonStrToEntity(Class<?> clazz,
			String jsonStr) throws JsonParseException, JsonMappingException,
			IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		Object obj = mapper.readValue(jsonStr, clazz);

		return obj;

	}
}
