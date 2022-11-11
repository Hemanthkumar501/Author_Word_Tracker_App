package junitTests;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class BookValidationTests {

	@Test
	public void validateGetBooks() throws JSONException {
		JSONObject actual = new JSONObject();
		actual.put("id", 1);
		actual.put("name", "Cool Book 1!");
		actual.put("chapter", 1);
		actual.put("name", "Letitia Mcmillan");
		actual.put("wordCount", 37);
		JSONAssert.assertEquals("{id:1}", actual, false); 
		JSONAssert.assertEquals("{name:\"Cool Book 1!\"}", actual, false);	
		JSONAssert.assertEquals("{name:\"Cool Book 1!\", chapter:1}", actual, false);
		JSONAssert.assertEquals("{name:Cool Book 1!, id:1}", actual, false);
		JSONAssert.assertEquals("{id:1, chapter:1}", actual, false);
		
		
	//@Test(timeout=3000)
		
	}

}
