package com.nimbbl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.junit.Test;

public class UserTest {

	@Test
	public void getOneByUserIdTest() throws NimbblException, JSONException, IOException {
		NimbblAPI api= new NimbblAPI("{access_key}", "{secret_key}");
		NimbblUser user= api.userApi.fetch("user_MwvMYXEABm1Oevry");
		assertEquals(user.getJsonModel().get("user_id"), "user_MwvMYXEABm1Oevry");
	}
	
	@Test
	public void getOneByIDTest() throws NimbblException, JSONException, IOException {
		NimbblAPI api= new NimbblAPI("{access_key}", "{secret_key}");
		NimbblUser user= api.userApi.fetch("202");
		assertEquals(user.getJsonModel().get("id"), 202);
	}
	
	@Test
	public void getAllTest() throws NimbblException, JSONException, IOException {
		NimbblAPI api= new NimbblAPI("{access_key}", "{secret_key}");
		List<NimbblUser> users= api.userApi.fetchAll();
		assertEquals(users.size(), 20);
	}
	
	@Test(expected = NimbblException.class)
	public void createTest() throws NimbblException, JSONException, IOException {
		NimbblAPI api= new NimbblAPI("{access_key}", "{secret_key}");
		api.userApi.create(null);
	}
	
	@Test(expected = NimbblException.class)
	public void editTest() throws NimbblException, JSONException, IOException {
		NimbblAPI api= new NimbblAPI("{access_key}", "{secret_key}");
		api.userApi.edit(null);
	}
}
