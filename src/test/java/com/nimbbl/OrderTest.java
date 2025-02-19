package com.nimbbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class OrderTest {

	@Test
	public void getOneTest() throws NimbblException, JSONException, IOException {
		NimbblAPI api= new NimbblAPI("access_key_1MwvMkKkweorz0ry", "access_secret_81x7ByYkRpB4g05N");
		NimbblOrder order= api.orderApi.fetch("order_MwvMYYQjDOALevry");
		assertEquals(order.getJsonModel().get("order_id"), "order_MwvMYYQjDOALevry");
	}
	
	@Test
	public void getAllTest() throws NimbblException, JSONException, IOException {
		NimbblAPI api= new NimbblAPI("access_key_1MwvMkKkweorz0ry", "access_secret_81x7ByYkRpB4g05N");
		List<NimbblOrder> order= api.orderApi.fetchAll();
		assertEquals(order.size(), 20);
	}
	
	@Test
	public void createTest() throws Exception {
		NimbblAPI api = new NimbblAPI("access_key_1MwvMkKkweorz0ry", "access_secret_81x7ByYkRpB4g05N");
		String file = "src/test/resources/createOrderReq.json";
		String json;
		json = ApiUtils.readFileAsString(file);
		JSONObject jsonObj = new JSONObject(json);
//		NimbblOrder res = api.orderApi.create(jsonObj);
//		JSONObject resJson=res.getJsonModel();
//		assertNotNull(resJson.get("order_id"));
//		assertTrue(resJson.get("order_id").toString().contains("order"));

	}
	
	@Test(expected = NimbblException.class)
	public void editTest() throws NimbblException, JSONException, IOException {
		NimbblAPI api= new NimbblAPI("access_key_1MwvMkKkweorz0ry", "access_secret_81x7ByYkRpB4g05N");
		api.orderApi.edit(null);
	}

}
