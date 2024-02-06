package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTest2 {

	Faker faker;
	User userPayload;
	
	public Logger logger;

	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUsername(faker.name().username());
		
		logger = LogManager.getLogger(this.getClass());
		
	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("************* Creating User ************* ");
		Response res = UserEndPoints2.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*************  User Created ************* ");
		logger.debug("Debuging....");
	}

	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("*************  Getting User by name ************* ");
		Response res = UserEndPoints2.getUserByName(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*************  got the User by name ************* ");
	}

	@Test(priority = 3)
	public void testUpdateUserByName() {
		logger.info("*************  Updating the user by name ************* ");
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());

		Response res = UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);

		Response resAfterUpdate = UserEndPoints2.getUserByName(this.userPayload.getUsername());

		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
		logger.info("*************  Updated the user by name ************* ");
	}

	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("*************  Deleting the user by name ************* ");
		Response res = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		//res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*************  Deleted the user by name ************* ");
	}

}
