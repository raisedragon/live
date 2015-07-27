package com.winit.label.model;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Test;


public class RequestMessageTest {
	@Test
	public void test() {
		RequestMessage message = new RequestMessage();
		RequestMessage.Consignee consignee = new RequestMessage.Consignee();
		RequestMessage.Product product = new RequestMessage.Product();
		List<RequestMessage.Product> products = new ArrayList<RequestMessage.Product>();
		products.add(product);
		message.setConsignee(consignee);
		message.setProducts(products);

		System.out.println(JSONObject.fromObject(message));
	}

}
