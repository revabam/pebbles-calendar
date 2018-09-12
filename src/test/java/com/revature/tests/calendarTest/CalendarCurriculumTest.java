package com.revature.tests.calendarTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.Application;
import com.revature.models.CalendarCurriculum;
import com.revature.tests.TestDriver;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestDriver.class, properties = "/pebbles-calendar/src/test/resources/application.properties", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class)
public class CalendarCurriculumTest extends TestDriver {

	static String url = "http://localhost:9994/calendars";

	@Test
	public void canGetAllCalendarCurriculums() {
		RestAssured.get(url + "/curriculums").prettyPrint();
	}

	@Test
	public void canGetCalendarCurriculumById() {
		int calendarCurriculumId = RestAssured.get(url + "/curriculums/1").as(CalendarCurriculum.class).getId();
		assertEquals(1, calendarCurriculumId);
	}

	@Test
	public void canAddCalendarCurriculum() {
		CalendarCurriculum newCalendarCurriculum = new CalendarCurriculum(4, 8, 8);
		int status = RestAssured.given().contentType("application/json").body(newCalendarCurriculum)
				.post(url + "/curriculums").getStatusCode();
		assertEquals(201, status);
	}

	@Test
	public void canUpdateCalendarCurriculum() {
		CalendarCurriculum updatedCalendarCurriculum = new CalendarCurriculum(2, 11, 11);
		CalendarCurriculum calendarCurriculum = RestAssured.given().contentType("application/json")
				.body(updatedCalendarCurriculum).put(url + "/curriculums").as(CalendarCurriculum.class);
		assertEquals(updatedCalendarCurriculum, calendarCurriculum);
	}
}