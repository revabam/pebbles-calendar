package com.revature.tests.calendarTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.Application;
import com.revature.models.CalendarEvent;
import com.revature.tests.TestDriver;

import io.restassured.RestAssured;

/**
 * Tests endpoints in the CalendarController
 * @author Joshua Maciejewski | Spark-1806-Jun-2018-USF | Steven Kelsey
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestDriver.class, properties = "/pebbles-calendar/src/test/resources/application.properties", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class)
public class CalendarEventTest extends TestDriver {

	static String url = "http://localhost:9994/calendars";

	@Test
	public void findAllCalendarEvents() {
		RestAssured.get(url + "/event").prettyPrint();
	}

	@Test
	public void findCalendarEventById() {
		
		int calendarEventId = RestAssured.get(url + "/event/1").as(CalendarEvent.class).getId();
		
		assertEquals(1, calendarEventId);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void findCalendarEventByTrainerId() {
		
		List<CalendarEvent> calendarEvents = RestAssured.get(url + "/event/trainer/1").as(List.class);
		
		assertEquals(2, calendarEvents.size());
	}
		
	@Test
	@Ignore
	public void addCalendarEvent() {
		
		CalendarEvent newCalendarEvent = new CalendarEvent( "Polymorphism event",
				"This is Polymorphism event from the Polymorphism subtopic in the Core Java topic", 3,
				new Date(1637224472690l), new Date(1937224472690l), "3", 3, 3, 3);
		
		int status = RestAssured.given().contentType("application/json").body(newCalendarEvent).post(url + "/event").getStatusCode();
		
		assertEquals(201, status);	
		}
	
	@Test
	public void updateCalendarEvent() {
		
		CalendarEvent updateCalendarEvent = new CalendarEvent(2, "Polymorphism event",
				"This is Polymorphism event from the Polymorphism subtopic in the Core Java topic", 1,
				new Date(1637224472690l), new Date(1937224472690l), "1", 1, 1, 1);
		
		int status = RestAssured.given().contentType("application/json").body(updateCalendarEvent).put(url + "/event").getStatusCode();
		
		assertEquals(200, status);	
		}

}