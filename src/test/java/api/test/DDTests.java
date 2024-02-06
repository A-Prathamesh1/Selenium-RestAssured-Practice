package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	/*
	 * creating test to create user by using post request using data provider
	 * 
	 */
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID, String UserName, String FirstName, String LastName, String Email,
			String Password, String Phone) {

		// THis test will execute n number of times, n is no of data in excel

		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);

		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	/*
	 * Deleting the users by using delete requests by providing the user names to
	 * delete req
	 */

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		
		Response res = UserEndPoints.deleteUser(userName);
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
