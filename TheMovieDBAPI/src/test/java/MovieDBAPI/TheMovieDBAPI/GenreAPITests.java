package MovieDBAPI.TheMovieDBAPI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;


/* The main purpose of this API end point test is to check how response results are handled. Example - Data which is given back. Checking multiple results,
 * correctness of the response etc*/

public class GenreAPITests {
	private Response res = null; //Response object
	private JsonPath jp = null; //JsonPath object

	//Setup operations
	@Before
	public void setup() {

		RestUtils.setBaseURI(Constants.BASE_URL); //Setup Base URI
		RestUtils.setBasePath(Constants.BASE_PATH_GENRESAPI); //Setup Base Path
		RestUtils.setContentType(ContentType.JSON); //Setup Content Type
		RestUtils.createSearchQueryPathGenreAPI(Constants.API_KEY_PARAM, Constants.API_KEY_VALUE, "language", "en-US"); //Construct the path
		res = RestUtils.getResponse(); //Get response
		jp = RestUtils.getJsonPath(res); //Get JsonPath
	}

	//checking the 200 response with all correct parameters
	@Test
	public void T01_StatusCodeTest() {
		HelperMethods.checkStatus200(res);
	}

	//Check the correct count of genres and displaying
	@Test
	public void T02_CheckGenresAndDisplay() {
		HelperMethods.checkCountGenre(jp);
	}

	//Checking if correct genre name is displayed against the correct genre id
	@Test
	public void T03_checkGenreNameAgainstId() {
		HelperMethods.checkGenreIdWithName(jp);
	}

	@After
	public void afterTest (){
		//Reset Values
		RestUtils.resetBaseURI();
		RestUtils.resetBasePath();
	}
}
