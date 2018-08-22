package com.revature.tests.calendarTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.Application;
import com.revature.models.CalendarSubtopic;
import com.revature.tests.TestDriver;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestDriver.class, properties = "/pebbles-calendar/src/test/resources/application.properties", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class)
public class CalendarSubtopicTest extends TestDriver {

	static String url = "http://localhost:9994";

	@Test
	public void canGetAllCalendarSubtopics() {
		RestAssured.get(url + "/subtopics").prettyPrint();
	}

	@Test
	public void canGetCalendarSubtopicById() {
		int calendarSubtopicId = RestAssured.get(url + "/subtopics/1").as(CalendarSubtopic.class).getId();
		assertEquals(1, calendarSubtopicId);
	}

	@Test
	public void canAddCalendarSubtopic() {
		CalendarSubtopic newCalendarSubtopic = new CalendarSubtopic(3, 1, 1);
		int status = RestAssured.given().contentType("application/json").body(newCalendarSubtopic)
				.post(url + "/subtopics").getStatusCode();
		assertEquals(201, status);
	}

	@Test
	public void canUpdateCalendarSubtopic() {
		CalendarSubtopic updatedCalendarSubtopic = new CalendarSubtopic(2, 1, 1);
		CalendarSubtopic calendarSubtopic = RestAssured.given().contentType("application/json")
				.body(updatedCalendarSubtopic).put(url + "/subtopics").as(CalendarSubtopic.class);
		assertEquals(updatedCalendarSubtopic, calendarSubtopic);
	}
}
