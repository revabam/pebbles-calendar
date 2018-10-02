package com.revature.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.CalendarEvent;
import com.revature.repositories.CalendarEventRepository;

/**
 * This is the service that calls repository methods from
 * CalendarCurriculumRepository, CalendarEventRepository, and
 * CalendarSubtopicRepository to implement calendar CRUD functionality. It
 * implements CRUD functionality for calendar curriculums, calendar events, and
 * calendar subtopics. There is no functionality to delete records from the
 * database. The methods in this class are called from the CalendarController
 * class methods. They call repository methods to carry out CRUD functionality.
 * 
 * @author Derek Loisel, Batch: 1806-jun18-usf-java, Trainer: Wezley Singleton
 */

@Service
@Transactional
public class CalendarService {

	@Autowired
	CalendarEventRepository calendarEventRepo;

	// This is the time when an event status will be changed from planned to missed
	// String formated "second minute hour"
	private final String statusChangeTime = "0 23 13 * * ?";

	/**
	 * This method Returns all Calendar events in the database
	 * 
	 * @return List<CalendarEvent> a list of all calendar events
	 */
	public List<CalendarEvent> findAllCalendarEvents() {
		return calendarEventRepo.findAll();
	}

	/**
	 * This method Returns the calendar event that corresponds with the id parameter
	 * 
	 * @param int id
	 * @return CalendarEvent
	 */
	public CalendarEvent findCalendarEventById(Integer id) {
		return calendarEventRepo.findCalendarEventById(id);
	}
	
	/**
	 * This method returns a list of calendar events from the database based on the trainer id
	 * 
	 * @param int id
	 * @return List<CalendarEvent>
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public List<CalendarEvent> findCalendarEventByTrainerId(int id){
		return calendarEventRepo.findCalendarEventByTrainerId(id);
	}
	

	/**
	 * This method takes a list of CalendarEvent objects and persists them to a database.
	 * If the event already exists its information will be updated in the database
	 * 
	 * @param CalendarEvent newCalendarEvent
	 * @return List<CalenderEvent>
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public List<CalendarEvent> addCalendarEvent(List<CalendarEvent> events) {
		return calendarEventRepo.save(events);
	}

	/**
	 * This method takes a CalendarEvent object and updates it in a database.
	 * 
	 * @param CalendarEvent updatedCalendarEvent
	 * @return Returns the updated CalendarEvent object if the object exists,
	 *         otherwise returns null
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public CalendarEvent updateCalendarEvent(CalendarEvent updatedCalendarEvent) {
		CalendarEvent calendarEvent = calendarEventRepo.findCalendarEventById(updatedCalendarEvent.getId());
		if (calendarEvent != null) {
			return calendarEventRepo.save(updatedCalendarEvent);
		}
		return null;
	}

	/**
	 * This method is a scheduled task. It will run at the specified time and
	 * will call a method to update the status of calendar events
	 * 
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@Scheduled(cron = statusChangeTime)
	public void updateStatusTimer() {
		updateStatus();
	}

	/**
	 * This method will update the status of a calendar event It will update the
	 * status of all events with an end date before the current date that have a
	 * status of pending into a status of missed
	 * 
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public void updateStatus() {
		Date currentDate = new Date();
		List<CalendarEvent> events = calendarEventRepo.findCalendarEventByStatusIdAndDate(1, currentDate);
		for (CalendarEvent event : events) {
			event.setStatusId(4);
			updateCalendarEvent(event);
		}
	}

}
