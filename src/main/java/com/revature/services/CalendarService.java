package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.models.CalendarCurriculum;
import com.revature.models.CalendarEvent;
import com.revature.models.CalendarSubtopic;
import com.revature.repositories.CalendarCurriculumRepository;
import com.revature.repositories.CalendarEventRepository;
import com.revature.repositories.CalendarSubtopicRepository;

/**
 * This is the service that calls repository methods from
 * CalendarCurriculumRepository, CalendarEventRepository, and
 * CalendarSubtopicRepository to implement calendar CRUD functionality. It
 * implements CRUD functionality for calendar curriculums, calendar events, and
 * calendar subtopics. There is no functionality to delete records from the
 * database. The methods in this class are called from the CalendarController
 * class methods. They call repository methods to carry out CRUD functionality.
 * 
 * @author author Derek Loisel batch 1806-jun18-usf-java trainer Wezley
 *         Singleton
 */

@Service
@Transactional
public class CalendarService {

	@Autowired
	CalendarCurriculumRepository calendarCurriculumRepo;
	@Autowired
	CalendarEventRepository calendarEventRepo;
	@Autowired
	CalendarSubtopicRepository calendarSubtopicRepo;

	/**
	 * This method returns all Calendar curriculums in the database
	 * 
	 * @return List<CalendarCurriculum> a list of all curriculum
	 */
	public List<CalendarCurriculum> findAllCalendarCurriculums() {
		return calendarCurriculumRepo.findAll();
	}

	/**
	 * This method Returns all Calendar events in the database
	 * 
	 * @return List<CalendarEvent> a list of all calendar events
	 */
	public List<CalendarEvent> findAllCalendarEvents() {
		return calendarEventRepo.findAll();
	}

	/**
	 * This method Returns all Calendar subtopics in the database
	 * 
	 * @return List<CalendarSubtopic> a list of all calendar subtopics
	 */
	public List<CalendarSubtopic> findAllCalendarSubtopics() {
		return calendarSubtopicRepo.findAll();
	}

	/**
	 * This method Returns the calendar curriculum that corresponds with the id
	 * parameter
	 * 
	 * @param int id
	 * @return CalendarCurriculum
	 */
	public CalendarCurriculum findCalendarCurriculumById(Integer id) {
		return calendarCurriculumRepo.findCalendarCurriculumById(id);
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
	 * This method Returns the calendar subtopic that corresponds with the id
	 * parameter
	 * 
	 * @param int id
	 * @return CalendarSubtopic
	 */
	public CalendarSubtopic findCalendarSubtopicById(Integer id) {
		return calendarSubtopicRepo.findCalendarSubtopicById(id);
	}

	/**
	 * This method takes a CalendarCurriculum object and persists it to a database.
	 * 
	 * @param CalendarCurriculum newCalendarCurriculum
	 * @return Calendar
	 */
	public CalendarCurriculum addCalendarCurriculum(CalendarCurriculum newCalendarCurriculum) {
		return calendarCurriculumRepo.save(newCalendarCurriculum);
	}

	/**
	 * This method takes a CalendarEvent object and persists it to a database.
	 * 
	 * @param CalendarEvent newCalendarEvent
	 * @return CalenderEvent
	 */
	public CalendarEvent addCalendarEvent(CalendarEvent newCalendarEvent) {
		return calendarEventRepo.save(newCalendarEvent);
	}

	/**
	 * This method takes a CalendarSubtopic object and persists it to a database.
	 * 
	 * @param CalendarSubtopic newCalendarSubtopic
	 * @return CalenderSubtopic
	 */
	public CalendarSubtopic addCalendarSubtopic(CalendarSubtopic newCalendarSubtopic) {
		return calendarSubtopicRepo.save(newCalendarSubtopic);
	}

	/**
	 * This method takes a CalendarCurriculum object and updates it in a database.
	 * 
	 * @param CalendarCurriculum updatedCalendarCurriculum
	 * @return CalendarCurriculum
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public CalendarCurriculum updateCalendarCurriculum(CalendarCurriculum updatedCalendarCurriculum) {
		return calendarCurriculumRepo.save(updatedCalendarCurriculum);
	}

	/**
	 * This method takes a CalendarEvent object and updates it in a database.
	 * 
	 * @param CalendarEvent updatedCalendarEvent
	 * @return CalendarEvent
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public CalendarEvent updateCalendarEvent(CalendarEvent updatedCalendarEvent) {
		return calendarEventRepo.save(updatedCalendarEvent);
	}

	/**
	 * This method takes a CalendarSubtopic object and updates it in a database.
	 * 
	 * @param CalendarSubtopic updatedCalendarSubtopic
	 * @return CalendarSubtopic
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	public CalendarSubtopic updateCalendarSubtopic(CalendarSubtopic updatedCalendarSubtopic) {
		return calendarSubtopicRepo.save(updatedCalendarSubtopic);
	}
}
