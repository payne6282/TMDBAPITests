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
	
	 public static void  createSearchQueryPath(String searchTerm, String APIKey, String APIKeyValue, String param, String paramValue) {
	        path = searchTerm + "?" + APIKey + "=" + APIKeyValue + "&" + param + "=" + paramValue;
	    }
	 
	  public static Response getResponse() {
	        //System.out.print("path: " + path +"\n");
	        return RestAssured.get(path);
	        
	    }
	  
	  public static JsonPath getJsonPath (Response res) {
	        String json = res.asString();
	        //System.out.print("returned json: " + json +"\n");
	        return new JsonPath(json);
	    }

	/*public static void setContentType(ContentType json) {
	
		
	}*/
	
	 // Set content type as JSON or XML before starting the test
	   
	    public static void setContentType (ContentType Type){
	        RestAssured.given().contentType(Type);
	    }

}
