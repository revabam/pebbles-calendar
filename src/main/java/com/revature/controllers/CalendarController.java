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
 * <This is the controller containing the endpoints to hit for calendar CRUD functionality.
 * It has CRUD functionality for calendar curriculums, calendar events, and calendar subtopics.
 * There is no functionality to delete records from the database.
 * The methods in this class are ran when the mapping endpoints are hit. They call CalendarService class methods to implement the CRUD functionality and finally return a ResponseEntity to the client>
 * @author <author Derek Loisel><><batch 1806-jun18-usf-java><trainer Wezley Singleton>
 */

@CrossOrigin
@RestController
@RequestMapping
public class CalendarController {

	@Autowired
	CalendarService calendarService;
	
	//find all calendar curriculums, events, or subtopics
	//curriculums
	@GetMapping(value="/curriculums", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalendarCurriculum>> findAllCalendarCurriculums() {
		List<CalendarCurriculum> allCalendarCurriculums =  calendarService.findAllCalendarCurriculums();
		return new ResponseEntity<List<CalendarCurriculum>>(allCalendarCurriculums, HttpStatus.OK);
	}
	//events
	@GetMapping(value="/events", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalendarEvent>> findAllCalendarEvents() {
		List<CalendarEvent> allCalendarEvents =  calendarService.findAllCalendarEvents();
		return new ResponseEntity<List<CalendarEvent>>(allCalendarEvents, HttpStatus.OK);
	}
	//subtopics
	@GetMapping(value="/subtopics", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalendarSubtopic>> findAllCalendarSubtopics() {
		List<CalendarSubtopic> allCalendarSubtopics =  calendarService.findAllCalendarSubtopics();
		return new ResponseEntity<List<CalendarSubtopic>>(allCalendarSubtopics, HttpStatus.OK);
	}
	
	//find a calendar curriculum, event, or subtopic by id
	//curriculum
	@GetMapping(value="/curriculums/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarCurriculum> findCalendarCurriculumById(@PathVariable("id") int id) {		
		CalendarCurriculum calendarCurriculum = calendarService.findCalendarCurriculumById(id);	
		if(calendarCurriculum == null) {
			return new ResponseEntity<CalendarCurriculum>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CalendarCurriculum>(calendarCurriculum, HttpStatus.OK);
		}
	}
	//event
	@GetMapping(value="/events/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarEvent> findCalendarEventById(@PathVariable("id") int id) {		
		CalendarEvent calendarEvent = calendarService.findCalendarEventById(id);		
		if(calendarEvent == null) {
			return new ResponseEntity<CalendarEvent>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CalendarEvent>(calendarEvent, HttpStatus.OK);
		}
	}
	//subtopic
	@GetMapping(value="/subtopics/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarSubtopic> findCalendarSubtopicById(@PathVariable("id") int id) {		
		CalendarSubtopic calendarSubtopic = calendarService.findCalendarSubtopicById(id);		
		if(calendarSubtopic == null) {
			return new ResponseEntity<CalendarSubtopic>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CalendarSubtopic>(calendarSubtopic, HttpStatus.OK);
		}
	}
	
	//add a calendar curriculum, event, or subtopic
	//curriculum
	@PostMapping(value="/curriculums", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarCurriculum> addCalendarCurriculum(@Valid @RequestBody CalendarCurriculum newCalendarCurriculum) {
		CalendarCurriculum calendarCurriculum = calendarService.addCalendarCurriculum(newCalendarCurriculum);
		return new ResponseEntity<CalendarCurriculum>(calendarCurriculum, HttpStatus.CREATED);
	}
	//event
	@PostMapping(value="/events", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarEvent> addCalendarEvent(@Valid @RequestBody CalendarEvent newCalendarEvent) {
		CalendarEvent calendarEvent = calendarService.addCalendarEvent(newCalendarEvent);
		return new ResponseEntity<CalendarEvent>(calendarEvent, HttpStatus.CREATED);
	}
	//subtopic
	@PostMapping(value="/subtopics", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarSubtopic> addCalendarSubtopic(@Valid @RequestBody CalendarSubtopic newCalendarSubtopic) {
		CalendarSubtopic calendarSubtopic = calendarService.addCalendarSubtopic(newCalendarSubtopic);
		return new ResponseEntity<CalendarSubtopic>(calendarSubtopic, HttpStatus.CREATED);
	}
	
	//update a calendar curriculum, event, or subtopic
	//curriculum
	@PutMapping(value="/curriculums", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarCurriculum> updateCalendarCurriculum(@RequestBody CalendarCurriculum updatedCalendarCurriculum) {
		CalendarCurriculum calendarCurriculum = calendarService.updateCalendarCurriculum(updatedCalendarCurriculum);
		return new ResponseEntity<CalendarCurriculum>(calendarCurriculum, HttpStatus.OK);
	}
	//event
	@PutMapping(value="/events", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarEvent> updateCalendarEvent(@RequestBody CalendarEvent updatedCalendarEvent) {
		CalendarEvent calendarEvent = calendarService.updateCalendarEvent(updatedCalendarEvent);
		return new ResponseEntity<CalendarEvent>(calendarEvent, HttpStatus.OK);
	}
	//subtopic
	@PutMapping(value="/subtopics", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarSubtopic> updateCalendarSubtopic(@RequestBody CalendarSubtopic updatedCalendarSubtopic) {
		CalendarSubtopic calendarSubtopic = calendarService.updateCalendarSubtopic(updatedCalendarSubtopic);
		return new ResponseEntity<CalendarSubtopic>(calendarSubtopic, HttpStatus.OK);
	}	
}
