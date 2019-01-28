package MovieDBAPI.TheMovieDBAPI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class MovieAPITests {
	
	//declaring Response and JsonPath objects.
    private Response res = null; //Response object
    private JsonPath jp = null; //JsonPath object
    
    //Setup operations
    @Before
    public void setup() {
    	
        RestUtils.setBaseURI("https://api.themoviedb.org"); //Setup Base URI
        RestUtils.setBasePath("/3/movie/"); //Setup Base Path
        RestUtils.setContentType(ContentType.JSON); //Setup Content Type
        RestUtils.createSearchQueryPath("522681-escape-room", "api_key", "17d2a5e61e584f6831d211e746949a68", "language", "en-US"); //Construct the path
        res = RestUtils.getResponse(); //Get response
        jp = RestUtils.getJsonPath(res); //Get JsonPath
    }
    
    @Test
    public void T01_StatusCodeTest() {
    	HelperMethods.checkStatus200(res);
    }
    
    @Test
    public void T02_StatusCodeCheckNotFound() {
    	RestUtils.createSearchQueryPath("522681-escape-room", "api_key", "17d2a5e61e584f6831d211e746949a689", "language", "en-US");
    	res = RestUtils.getResponse(); //Get response
        jp = RestUtils.getJsonPath(res); //Get JsonPath
    	HelperMethods.checkStatus401(res);
    }
    
    @After
    public void afterTest (){
        //Reset Values
        RestUtils.resetBaseURI();
        RestUtils.resetBasePath();
    }

}

//https://api.themoviedb.org/3/movie/522681-escape-room?api_key=17d2a5e61e584f6831d211e746949a68&language=en-US
