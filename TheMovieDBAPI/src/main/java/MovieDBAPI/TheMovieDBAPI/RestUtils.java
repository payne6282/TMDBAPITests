package MovieDBAPI.TheMovieDBAPI;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class RestUtils {

	public static String path;

	// Sets Base URI

	public static void setBaseURI (String baseURI) {
		RestAssured.baseURI = baseURI;
	}

	//sets base path

	public static void setBasePath(String basePath) {
		RestAssured.basePath = basePath;
	}

	//reset the base URI to null after the tests

	public static void resetBaseURI() {
		RestAssured.baseURI = null;
	}

	//reset the base path to null after the tests
	public static void resetBasePath(){
		RestAssured.basePath = null;
	}

	
	//path construction for MOVIE API
	public static void  createSearchQueryPathMovieAPI(String searchTerm, String APIKey, String APIKeyValue, String langParam, String langParamValue) {
		path = searchTerm + "?" + APIKey + "=" + APIKeyValue + "&" + langParam + "=" + langParamValue;
	}
	
	//path construction for GENRE API
	public static void createSearchQueryPathGenreAPI(String APIKey, String APIKeyValue, String langParam, String langParamValue) {
		path = "?" + APIKey + "=" + APIKeyValue + "&" + langParam + "=" + langParamValue;
		
	}
	
	//path construction for GENRE API
	public static void createSearchQueryPathSearchMovieAPI(String APIKey, String APIKeyValue, String langParam, String langParamValue, String query, String queryName, String page, String pageNumber) {
		path = "?" + APIKey + "=" + APIKeyValue + "&" + langParam + "=" + langParamValue + "&" + query + "=" + queryName + "&" + page + "=" + pageNumber;
		
	}

	
	public static Response getResponse() {
		System.out.println("path: " +path);
		return RestAssured.get(path);

	}
	
	public static Response postRequest() {
		return RestAssured.post(path);

	}
	

	/*Convert the API response to string and return it
	 * 
	 */
	public static JsonPath getJsonPath (Response res) {
		String json = res.asString();
		//System.out.println("Json results: " +json);
		return new JsonPath(json);
	}

	// Set content type as JSON or XML before starting the test

	public static void setContentType (ContentType Type){
		RestAssured.given().contentType(Type);
	}

}
