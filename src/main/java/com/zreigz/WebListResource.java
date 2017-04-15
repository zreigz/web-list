package com.zreigz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

@Path("/list")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WebListResource {

	private final Jedis jedis;
	// SLF4J is provided with dropwizard. Logback is also provided
	Logger log = LoggerFactory.getLogger(WebListResource.class);

	public WebListResource() {
		String redisHost = System.getenv("REDIS_SERVICE_HOST");
		if(redisHost == null){
			redisHost = "localhost";
		}
		log.info("Redis master IP: ", redisHost);
		jedis = new Jedis(redisHost);
	}

	@GET
	public List<WebListData> getData() {
		List<WebListData> dataList = new ArrayList<WebListData>();

		List<String> list = jedis.lrange("data", 0, 5);
		for (int i = 0; i < list.size(); i++) {

			dataList.add(new WebListData(list.get(i)));

		}

		return dataList;
	}

	@POST
	public void receiveData(@Valid WebListData data) {
		log.info("Received a data: {}", data);
		jedis.lpush("data", data.getText());
	}
}
