package com.revature.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.CalendarCurriculum;
import com.revature.models.CalendarEvent;
import com.revature.models.CalendarSubtopic;
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
@RequestMapping
public class CalendarController {

	@Autowired
	CalendarService calendarService;

	/**
	 * This method Returns all Calendar curriculums in the database
	 * 
	 * @param no
	 *            parameters are taken
	 * @return ResponseEntity<List<CalendarCurriculum>> Returns a list of all
	 *         calendar curricula and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@GetMapping("/curriculum")
	public ResponseEntity<List<CalendarCurriculum>> findAllCalendarCurriculums() {
		List<CalendarCurriculum> allCalendarCurriculums = calendarService.findAllCalendarCurriculums();
		return new ResponseEntity<>(allCalendarCurriculums, HttpStatus.OK);
	}

	/**
	 * This method Returns all Calendar events in the database
	 * 
	 * @param no
	 *            parameters are taken
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
	 * This method Returns all Calendar subtopics in the database
	 * 
	 * @param no
	 *            parameters are taken
	 * @return Returns a response entity containing a list of all calendar subtopics
	 *         and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@GetMapping("/subtopic")
	public ResponseEntity<List<CalendarSubtopic>> findAllCalendarSubtopics() {
		List<CalendarSubtopic> allCalendarSubtopics = calendarService.findAllCalendarSubtopics();
		return new ResponseEntity<>(allCalendarSubtopics, HttpStatus.OK);
	}

	/**
	 * This method Returns the curriculum that corresponds with the id parameter
	 * 
	 * @param an
	 *            int id parameter is taken in
	 * @return Returns a response entity containing a curriculum that corresponds
	 *         with the id parameter and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@GetMapping("/curriculum/{id}")
	public ResponseEntity<CalendarCurriculum> findCalendarCurriculumById(@PathVariable("id") int id) {
		CalendarCurriculum calendarCurriculum = calendarService.findCalendarCurriculumById(id);
		if (calendarCurriculum == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(calendarCurriculum, HttpStatus.OK);
		}
	}

	/**
	 * This method Returns the calendar event that corresponds with the id parameter
	 * 
	 * @param an
	 *            int id parameter is taken in
	 * @return Returns a response entity containing a calendar event that
	 *         corresponds with the id parameter and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@GetMapping("/event/{id}")
	public ResponseEntity<CalendarEvent> findCalendarEventById(@PathVariable("id") int id) {
		CalendarEvent calendarEvent = calendarService.findCalendarEventById(id);
		if (calendarEvent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(calendarEvent, HttpStatus.OK);
		}
	}

	/**
	 * This method Returns the calendar subtopic that corresponds with the id
	 * parameter
	 * 
	 * @param an
	 *            int id parameter is taken in
	 * @return Returns a response entity containing a calendar event that
	 *         corresponds with the id parameter and an http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@GetMapping("/subtopic/{id}")
	public ResponseEntity<CalendarSubtopic> findCalendarSubtopicById(@PathVariable("id") int id) {
		CalendarSubtopic calendarSubtopic = calendarService.findCalendarSubtopicById(id);
		if (calendarSubtopic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(calendarSubtopic, HttpStatus.OK);
		}
	}

	/**
	 * This method Takes a CalendarCurriculum object from a request body, and
	 * persists it to a database.
	 * 
	 * @param a
	 *            CalendarCurriculum is taken in as the request body
	 * @return The CalendarCurriculum that was added to the database with its
	 *         generated id, and a corresponding http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@PostMapping("/curriculum")
	public ResponseEntity<CalendarCurriculum> addCalendarCurriculum(
			@Valid @RequestBody CalendarCurriculum newCalendarCurriculum) {
		CalendarCurriculum calendarCurriculum = calendarService.addCalendarCurriculum(newCalendarCurriculum);
		return new ResponseEntity<>(calendarCurriculum, HttpStatus.CREATED);
	}

	/**
	 * This method Takes a CalendarEvent object from a request body, and persists it
	 * to a database.
	 * 
	 * @param a
	 *            CalendarEvent is taken in as the request body
	 * @return The CalendarEvent that was added to the database with its generated
	 *         id, and a corresponding http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@PostMapping("/event")
	public ResponseEntity<CalendarEvent> addCalendarEvent(@Valid @RequestBody CalendarEvent newCalendarEvent) {
		CalendarEvent calendarEvent = calendarService.addCalendarEvent(newCalendarEvent);
		return new ResponseEntity<>(calendarEvent, HttpStatus.CREATED);
	}

	/**
	 * This method Takes a CalendarSubtopic object from a request body, and persists
	 * it to a database.
	 * 
	 * @param a
	 *            CalendarSubtopic is taken in as the request body
	 * @return The CalendarSubtopic that was added to the database with its
	 *         generated id, and a corresponding http status code
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@PostMapping("/subtopic")
	public ResponseEntity<CalendarSubtopic> addCalendarSubtopic(
			@Valid @RequestBody CalendarSubtopic newCalendarSubtopic) {
		CalendarSubtopic calendarSubtopic = calendarService.addCalendarSubtopic(newCalendarSubtopic);
		return new ResponseEntity<>(calendarSubtopic, HttpStatus.CREATED);
	}

	/**
	 * This method Takes a CalendarCurriculum object from a request body, and
	 * updates it in a database.
	 * 
	 * @param a
	 *            CalendarCurriculum is taken in as the request body
	 * @return The updated CalendarCurriculum object as it exist in the database,
	 *         and a corresponding Http Status Code in a ResponseEntity
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@PutMapping("/curriculum")
	public ResponseEntity<CalendarCurriculum> updateCalendarCurriculum(@RequestBody CalendarCurriculum updatedCalendarCurriculum) {
		CalendarCurriculum calendarCurriculum = calendarService.updateCalendarCurriculum(updatedCalendarCurriculum);
		return new ResponseEntity<>(calendarCurriculum, HttpStatus.OK);
	}

	/**
	 * This method Takes a CalendarEvent object from a request body, and updates it
	 * in a database.
	 * 
	 * @param a
	 *            CalendarEvent is taken in as the request body
	 * @return The updated CalendarEvent object as it exist in the database, and a
	 *         corresponding Http Status Code in a ResponseEntity
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@PutMapping("/event")
	public ResponseEntity<CalendarEvent> updateCalendarEvent(@RequestBody CalendarEvent updatedCalendarEvent) {
		CalendarEvent calendarEvent = calendarService.updateCalendarEvent(updatedCalendarEvent);
		return new ResponseEntity<>(calendarEvent, HttpStatus.OK);
	}

	/**
	 * This method Takes a CalendarSubtopic object from a request body, and updates
	 * it in a database.
	 * 
	 * @param a
	 *            CalendarSubtopic is taken in as the request body
	 * @return The updated CalendarSubtopic object as it exist in the database, and
	 *         a corresponding Http Status Code in a ResponseEntity
	 * @author John Beineke, Batch: 1806-jun18-java-usf, Trainer: Wezley Singleton
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@PutMapping("/subtopic")
	public ResponseEntity<CalendarSubtopic> updateCalendarSubtopic(@RequestBody CalendarSubtopic updatedCalendarSubtopic) {
		CalendarSubtopic calendarSubtopic = calendarService.updateCalendarSubtopic(updatedCalendarSubtopic);
		return new ResponseEntity<>(calendarSubtopic, HttpStatus.OK);
	}
}
