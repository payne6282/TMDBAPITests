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
	
	public static void resetBaseURL() {
		RestAssured.baseURI = null;
	}
	
	//reset the base path to null after the tests
	public static void resetBasePath(){
        RestAssured.basePath = null;
    }
	
	 /* Set content type as JSON or XML before starting the test
	   
	    public static void setContentType (ContentType Type){
	        given().contentType(Type);
	    }*/

}
