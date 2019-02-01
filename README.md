# TMDBAPITests
Tech assessment

Instead of writing multiple test cases on a single end point, I thought I will write test cases across 3 end points
which would help to broaden the range of test cases. Hope you guys do not mind. So there is a total of 21 test scenarios across
3 end points. I did not enable it to run everything together, because I thought it might be a little bit difficult to
sort out the results. Rather you can run each end point test cases separately.

Steps to run -

1. I have deleted my own API Key as told. So enter your own API Key, go to src/main/java and open Constants.java
You can put the value for your own API key in the initializer - API_KEY_VALUE
2. After entering the API key value, go to src/test/java and there are 3 tests there -
   1. GenreAPITests.java - These tests I wrote mainly on how to handle the API response results based on their Genre API 
   endpoint. (3 test cases)
   2. MovieAPITests.java - The tests here primarily focuses on the response codes. Like how the API handles a 404 or a 401 
   errors etc (6 test cases)
   3. SearchMoviesAPI.java - These tests primarily deals with how the API response is handled during the search query and
   how the response is handled when different kinds of search query are put in a request. (12 test cases)
3. Right click on any of the files above as select 'run as junit'

Hopefully this will run without a glitch and you can see the results. I was thinking of making a report, but it would
go beyond next week and I wanted to send this across within this week itself. Please let me know if you encounter any issues.
   
