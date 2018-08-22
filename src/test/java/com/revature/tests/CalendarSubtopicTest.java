package com.revature.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.google.gson.JsonObject;
import com.revature.models.CalendarSubtopic;
import io.restassured.RestAssured;

public class CalendarSubtopicTest {

static String url = "http://localhost:9994";
	
	@Test
	public void canGetAllCalendarSubtopics() {
		RestAssured.get(url + "/subtopics").prettyPrint();
	}
	
	@Test
	public void canGetCalendarSubtopicById() {	
		int calendarSubtopicId = RestAssured.get(url+"/subtopics/1").as(CalendarSubtopic.class).getId();	
		assertEquals(1, calendarSubtopicId);	
	}
	
	//This test record needs to be cleared out of the database after the tests are run.  Currently this doesn't happen, but since it's using H2 database it clears everytime you stop the program.
	@Test
	public void canAddCalendarSubtopic() {
		CalendarSubtopic newCalendarSubtopic = new CalendarSubtopic(3, 1, 1);	
//		JsonObject json = new JsonObject();
//		json.addProperty("calendarSubtopic", newCalendarSubtopic.toString());	
		int status = RestAssured.given().contentType("application/json").body(newCalendarSubtopic).post(url+"/subtopics").getStatusCode();		
		assertEquals(201, status);
	}
	
	@Test
	public void canUpdateCalendarSubtopic() {
		CalendarSubtopic updatedCalendarSubtopic = new CalendarSubtopic(2, 1, 1);	
//		JsonObject json = new JsonObject();
//		json.addProperty("calendarSubtopic", updatedCalendarSubtopic.toString());	
		CalendarSubtopic calendarSubtopic = RestAssured.given().contentType("application/json").body(updatedCalendarSubtopic).put(url+"/subtopics").as(CalendarSubtopic.class);	
		assertEquals(updatedCalendarSubtopic, calendarSubtopic);
	}
}
