package com.revature.tests.calendarTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.Application;
import com.revature.models.CalendarEvent;
import com.revature.tests.TestDriver;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestDriver.class, properties = "/pebbles-calendar/src/test/resources/application.properties", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class)
public class CalendarEventTest extends TestDriver {

	static String url = "http://localhost:9994/calendars";

	@Test
	public void canGetAllCalendarEvents() {
		RestAssured.get(url + "/events").prettyPrint();
	}

	@Test
	public void canGetCalendarEventById() {
		int calendarEventId = RestAssured.get(url + "/events/1").as(CalendarEvent.class).getId();
		assertEquals(1, calendarEventId);
	}


}
