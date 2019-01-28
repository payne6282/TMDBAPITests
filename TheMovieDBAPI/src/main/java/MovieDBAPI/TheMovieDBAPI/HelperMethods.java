package MovieDBAPI.TheMovieDBAPI;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import static org.junit.Assert.assertEquals;

import java.util.*;



public class HelperMethods {
	
	/*
    Verify the http response status returned. Check Status Code is 200?
    We can use Rest Assured library's response's getStatusCode method
    */
    public static void checkStatus200(Response res) {
    	
    	assertEquals("Status Check Failed!", 200, res.getStatusCode());
    }
    
 public static void checkStatus401(Response res) {
    	
    	assertEquals("Expectd wrong params", 401, res.getStatusCode());
    }
 

}
