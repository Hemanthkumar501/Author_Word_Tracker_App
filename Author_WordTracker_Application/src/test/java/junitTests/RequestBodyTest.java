package junitTests;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.json.JSONObject;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class RequestBodyTest {
	@Test
	public void validateResponseType() {
		JSONObject obj = new JSONObject();
		String type = "application/json";
		assertEquals("","Book created successfully! ");
		//assertEquals(jsonMimeType, mimeType);
	}
}
