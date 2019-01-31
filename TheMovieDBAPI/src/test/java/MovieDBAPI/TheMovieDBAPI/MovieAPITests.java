package MovieDBAPI.TheMovieDBAPI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class MovieAPITests {

	/*These tests are to check the correctness of the API response codes. Like 401, 404 etc */

	//declaring Response and JsonPath objects.
	private static Response res = null; //Response object
	private static JsonPath jp = null; //JsonPath object

	//Setup operations
	@Before
	public void setup() {

		RestUtils.setBaseURI(Constants.BASE_URL); //Setup Base URI
		RestUtils.setBasePath(Constants.BASE_PATH_MOVIESAPI); //Setup Base Path
		RestUtils.setContentType(ContentType.JSON); //Setup Content Type
		RestUtils.createSearchQueryPathMovieAPI("522681-escape-room", "api_key", Constants.API_KEY_VALUE, "language", "en-US"); //Construct the path
		responsePathSetUp();
	}

	public static void responsePathSetUp() {
		res = RestUtils.getResponse(); //Get response
		jp = RestUtils.getJsonPath(res); //Get JsonPath
	}

	//checking the 200 response with all correct parameters
	@Test
	public void T01_StatusCodeTest() {
		HelperMethods.checkStatus200(res);
	}

	//checking the 401 unauthorized response after the wrong API key passed
	@Test
	public void T02_StatusCodeCheckNotFound() {
		RestUtils.createSearchQueryPathMovieAPI("522681-escape-room", "api_key", "17d2a5e61e584f6831d211e746949a689", "language", "en-US");//Wrong api key passed
		responsePathSetUp();
		HelperMethods.checkStatus401(res, jp);
	}

	//checking the 404 not found response if a null value is passed. Example - no movie id passed
	@Test
	public void T03_NullValueResponseCheck() {
		RestUtils.createSearchQueryPathMovieAPI("", "api_key", "17d2a5e61e584f6831d211e746949a68", "language", "en-US");//null movie id passed
		responsePathSetUp();
		HelperMethods.checkNullResponse(res, jp);
	}

	//Checking the 404 not found response with a movie id which does not exist
	@Test
	public void T04_WrongIdCheckResponse() {
		RestUtils.createSearchQueryPathMovieAPI("abcd", "api_key", "17d2a5e61e584f6831d211e746949a68", "language", "en-US");//invalid movie id passed
		responsePathSetUp();
		HelperMethods.checkNullResponse(res, jp);
	}


	/*Checking the validity of a json response expected value. Example - checking the value of the movie title returned
    against the expected correct value. */
	@Test
	public void T05_MovieNameCheck() {
		HelperMethods.checkJsonValueValidity(jp);
	}

	/*Checking how the response is handled if there is any null values in the resulting json results. Example - the movie id
	 * 433456 has some values for homepage urls in the json response which is null. So we want to check how it is handled. This
	 * should return a 200 response.
	 */
	@Test
	public void T06_JsonResponseHasNullValue() {
		RestUtils.createSearchQueryPathMovieAPI("433456", "api_key", "17d2a5e61e584f6831d211e746949a68", "language", "en-US"); //movie id with null json values passed
		responsePathSetUp();
		HelperMethods.checkStatus200(res);

	}

	@After
	public void afterTest (){
		//Reset Values for base URL and path
		RestUtils.resetBaseURI();
		RestUtils.resetBasePath();
	}

}

//https://api.themoviedb.org/3/movie/522681-escape-room?api_key=17d2a5e61e584f6831d211e746949a68&language=en-US
