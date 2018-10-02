package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CalendarEvent;
import com.revature.services.CalendarService;

/**
 * This is the controller containing the endpoints to hit for calendar CRUD
 * functionality. It has CRUD functionality for calendar curriculums, calendar
 * events, and calendar subtopics. There is no functionality to delete records
 * from the database. The methods in this class are ran when the mapping
 * endpoints are hit. They call CalendarService class methods to implement the
 * CRUD functionality and finally return a ResponseEntity to the client
 * 
 * @author author Derek Loisel | 1806-jun18-usf-java | Wezley Singleton
 */

@CrossOrigin
@RestController
@RequestMapping("/calendars")
public class CalendarController {

	@Autowired
	CalendarService calendarService;

	/**
	 * This method Returns all Calendar events in the database
	 * 
	 * @param no parameters are taken
	 * @return Returns a response entity containing a list of all calendar events
	 *         and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@GetMapping("/event")
	public ResponseEntity<List<CalendarEvent>> findAllCalendarEvents() {
		List<CalendarEvent> allCalendarEvents = calendarService.findAllCalendarEvents();
		return new ResponseEntity<>(allCalendarEvents, HttpStatus.OK);
	}

	/**
	 * This method Returns the calendar event that corresponds with the id parameter
	 * 
	 * @param an int id parameter is taken in
	 * @return Returns a response entity containing a calendar event that
	 *         corresponds with the id parameter and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@GetMapping("/event/{id}")
	public ResponseEntity<CalendarEvent> findCalendarEventById(@PathVariable("id") int id) {
		CalendarEvent calendarEvent = calendarService.findCalendarEventById(id);
		if (calendarEvent != null) {
			return new ResponseEntity<>(calendarEvent, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This method returns a list of events that correspond with the given trainer id
	 * 
	 * @param int id
	 * @return Retruns a response entity containing a list of calendar events and an http status code
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@GetMapping("/event/trainer/{id}")
	public ResponseEntity<List<CalendarEvent>> findCalendarEventByTrainerId(@PathVariable("id") int id) {
		List<CalendarEvent> events = calendarService.findCalendarEventByTrainerId(id);
		return new ResponseEntity<>(events, HttpStatus.OK);
	}

	/**
	 * This method Takes a CalendarEvent object from a request body, and persists it
	 * to a database.
	 * 
	 * @param a CalendarEvent is taken in as the request body
	 * @return The CalendarEvent that was added to the database with its generated
	 *         id, and a corresponding http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@PostMapping("/event")
	public ResponseEntity<List<CalendarEvent>> addCalendarEvent(@RequestBody List<CalendarEvent> events) {
		List<CalendarEvent> calendarEvent = calendarService.addCalendarEvent(events);
		return new ResponseEntity<>(calendarEvent, HttpStatus.CREATED);
	}

	/**
	 * This method Takes a CalendarEvent object from a request body, and updates it
	 * in a database.
	 * 
	 * @param a CalendarEvent is taken in as the request body
	 * @return The updated CalendarEvent object as it exist in the database, and a
	 *         corresponding Http Status Code in a ResponseEntity
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@PutMapping("/event")
	public ResponseEntity<CalendarEvent> updateCalendarEvent(@RequestBody CalendarEvent updatedCalendarEvent) {
		CalendarEvent calendarEvent = calendarService.updateCalendarEvent(updatedCalendarEvent);
		if (calendarEvent != null) {
			return new ResponseEntity<>(calendarEvent, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
