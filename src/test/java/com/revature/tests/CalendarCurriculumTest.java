package com.revature.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.google.gson.JsonObject;
import com.revature.models.CalendarCurriculum;
import io.restassured.RestAssured;

public class CalendarCurriculumTest {
	
	static String url = "http://localhost:9994";
	
	@Test
	public void canGetAllCalendarCurriculums() {
		RestAssured.get(url + "/curriculums").prettyPrint();
	}
	
	@Test
	public void canGetCalendarCurriculumById() {	
		int calendarCurriculumId = RestAssured.get(url+"/curriculums/1").as(CalendarCurriculum.class).getId();	
		assertEquals(1, calendarCurriculumId);	
	}
	
	//This test record needs to be cleared out of the database after the tests are run.  Currently this doesn't happen, but since it's using H2 database it clears everytime you stop the program.
	@Test
	public void canAddCalendarCurriculum() {
		CalendarCurriculum newCalendarCurriculum = new CalendarCurriculum(4, 8, 8);	
//		JsonObject json = new JsonObject();
//		json.addProperty("calendarCurriculum", newCalendarCurriculum.toString());	
		int status = RestAssured.given().contentType("application/json").body(newCalendarCurriculum).post(url+"/curriculums").getStatusCode();		
		assertEquals(201, status);
	}
	
	@Test
	public void canUpdateCalendarCurriculum() {
		CalendarCurriculum updatedCalendarCurriculum = new CalendarCurriculum(2, 11, 11);	
//		JsonObject json = new JsonObject();
//		json.addProperty("calendarCurriculum", updatedCalendarCurriculum.toString());	
		CalendarCurriculum calendarCurriculum = RestAssured.given().contentType("application/json").body(updatedCalendarCurriculum).put(url+"/curriculums").as(CalendarCurriculum.class);	
		assertEquals(updatedCalendarCurriculum, calendarCurriculum);
	}
}