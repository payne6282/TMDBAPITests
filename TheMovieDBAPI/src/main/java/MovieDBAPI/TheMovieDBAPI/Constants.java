package MovieDBAPI.TheMovieDBAPI;

public class Constants {
	/* Contains the constants like URLs */

	static String BASE_URL = "https://api.themoviedb.org"; //Base URL
	static String API_KEY_VALUE = "17d2a5e61e584f6831d211e746949a68"; //API key value goes here
	static String API_KEY_PARAM = "api_key"; //Api key param name

	//Path for the movie API
	static String BASE_PATH_MOVIESAPI = "/3/movie/";

	//path for the genre API
	static String BASE_PATH_GENRESAPI = "/3/genre/movie/list?";

	//path for Adding Search API
	static String BASE_PATH_SearchMOVIEAPI = "/3/search/movie";

}
