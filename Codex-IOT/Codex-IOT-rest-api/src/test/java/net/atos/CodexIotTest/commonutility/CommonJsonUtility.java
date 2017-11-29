package net.atos.CodexIotTest.commonutility;


import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author A622890
 *
 */
@Component
public class CommonJsonUtility {

	/**
	 * @param object
	 * @return Json String for Object
	 * @throws JsonProcessingException
	 */
	public String getJsonStringForObject(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	/**
	 * @param jsonString
	 * @param class1
	 * @return Object for Json String
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getObjectForJsonString(String jsonString, Class class1)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonString, class1);
	}

}
