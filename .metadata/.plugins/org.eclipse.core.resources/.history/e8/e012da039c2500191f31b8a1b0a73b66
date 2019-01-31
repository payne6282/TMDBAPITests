package MovieDBAPI.TheMovieDBAPI;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;





public class HelperMethods {


	//Verify the http response status returned. Check Status Code is 200.

	public static void checkStatus200(Response res) {

		assertEquals("Status Check Failed!", 200, res.getStatusCode());
	}

	//Check wrong value response. Example - Wrong API key sent
	public static void checkStatus401(Response res, JsonPath jp) {
		//401 should be expected for unauthorized access
		assertEquals("Expected wrong params", 401, res.getStatusCode());
		System.out.println("Status code and message for invalid api key value: " +jp.getString("status_code") + ", " +jp.getString("status_message"));
	}
	
	//Check null value response for search query
	public static void checkStatus422(Response res, JsonPath jp) {
		//401 should be expected for unauthorized access
		assertEquals("Null results", 422, res.getStatusCode());
	}

	public static void checkJsonValueValidity(JsonPath jp) {
		String nameCheck = jp.getString("original_title");

		assertEquals("Wrong movie name", nameCheck , jp.get("original_title"));
	}

	//Check null value response. Example - sending null value for movie id or for an invalid movie id which does not exist
	public static void checkNullResponse(Response res, JsonPath jp) {
		//404 should be expected as the endpoint result should not be found because of the null value being passed
		assertEquals("Expected null values", 404, res.getStatusCode());
		System.out.println("Status code and message for movie id null value response or for movie id invalid: " +jp.getString("status_code") + ", " +jp.getString("status_message"));
	}

	public static void checkCountGenre(JsonPath jp) {
		List<String> genreCount = jp.get("genres.name");
		System.out.println("names: " +genreCount.size());
		for (String iterate: genreCount) {
			System.out.println(iterate);
		}
		assertEquals("Expected 19 genres", 19, genreCount.size());

	}

	//Checking if the id matches the correct genre
	public static void checkGenreIdWithName(JsonPath jp) {
		List<Integer> idCheck = jp.get("genres.id"); //Adding the genre ids in a list
		List<String> name = jp.get("genres.name"); //Adding the genre names in a list
		String nameCheck = null;
		int counter = 0;

		for (int i = 0; i < idCheck.size(); i++) { //Looping through the lists to get the index for the genre id
			if (idCheck.get(i) == 18) {

				counter = i; //getting the index and saving it in counter
			}	
		}
		nameCheck = name.get(counter); //getting the genre name based on the genre id index
		assertEquals("The genre name and id is not matching", "Drama", nameCheck); //asserting the id = 18 corresponds to "Drama"
	}




}
