package com.revature.tests;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.junit.Test;
import com.google.gson.JsonObject;
import com.revature.models.CalendarEvent;
import io.restassured.RestAssured;

public class CalendarEventTest {

static String url = "http:localhost:8765/bam/calendars";
	
	@Test
	public void canGetAllCalendarEvents() {
		RestAssured.get(url).prettyPrint();
	}
	
	@Test
	public void canGetCalendarEventById() {	
		int calendarEventId = RestAssured.get(url+"/events/1").as(CalendarEvent.class).getId();	
		assertEquals(1, calendarEventId);	
	}
	
	//This test record needs to be cleared out of the database after the tests are run.  Currently this doesn't happen, but since it's using H2 database it clears everytime you stop the program.
	@Test
	public void canAddCalendarEvent() {
		Date date1 = new Date();
		date1.getTime();
		Date date2 = new Date();
		date2.getTime();
		CalendarEvent newCalendarEvent = new CalendarEvent(1000, "Polymorphism event", "This is Polymorphism event from the Polymorphism subtopic in the Core Java topic", 1, date1, date2, 1000);	
		JsonObject json = new JsonObject();
		json.addProperty("calendarEvent", newCalendarEvent.toString());	
		int status = RestAssured.given().body(json).post(url+"/events").getStatusCode();		
		assertEquals(201, status);
	}
	
	@Test
	public void canUpdateCalendarEvent() {
		Date date1 = new Date();
		date1.getTime();
		Date date2 = new Date();
		date2.getTime();
		CalendarEvent updatedCalendarEvent = new CalendarEvent(1000, "Polymorphism event", "This is Polymorphism event from the Polymorphism subtopic in the Core Java topic", 1, date1, date2, 1000);	
		JsonObject json = new JsonObject();
		json.addProperty("calendarEvent", updatedCalendarEvent.toString());	
		CalendarEvent calendarEvent = RestAssured.given().body(json).put(url+"events").as(CalendarEvent.class);	
		assertEquals(updatedCalendarEvent, calendarEvent);
	}
}
