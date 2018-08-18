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
 * <This is the service that calls repository methods from CalendarCurriculumRepository, CalendarEventRepository, and CalendarSubtopicRepository to implement calendar CRUD functionality.  
 * It implements CRUD functionality for calendar curriculums, calendar events, and calendar subtopics.
 * There is no functionality to delete records from the database.
 * The methods in this class are called from the CalendarController class methods. They call repository methods to carry out CRUD functionality.>
 * @author <author Derek Loisel><><batch 1806-jun18-usf-java><trainer Wezley Singleton>
 */

@Service
@Transactional
public class CalendarService {

	//inject the repositories used by this service
	@Autowired
	CalendarCurriculumRepository calendarCurriculumRepo;
	CalendarEventRepository calendarEventRepo;
	CalendarSubtopicRepository calendarSubtopicRepo;
	
	//find all calendar curriculums, events, or subtopics
	//curriculums
	public List<CalendarCurriculum> findAllCalendarCurriculums() {
		return calendarCurriculumRepo.findAll();
	}
	//events
	public List<CalendarEvent> findAllCalendarEvents() {
		return calendarEventRepo.findAll();
	}
	//subtopics
	public List<CalendarSubtopic> findAllCalendarSubtopics() {
		return calendarSubtopicRepo.findAll();
	}
	
	//find a calendar curriculum, event, or subtopic by id
	//curriculum
	public CalendarCurriculum findCalendarCurriculumById(Integer id) {
		return calendarCurriculumRepo.findCalendarCurriculumById(id);
	}
	//event
	public CalendarEvent findCalendarEventById(Integer id) {
		return calendarEventRepo.findCalendarEventById(id);
	}
	//subtopic
	public CalendarSubtopic findCalendarSubtopicById(Integer id) {
		return calendarSubtopicRepo.findCalendarSubtopicById(id);
	}
	
	//add a calendar curriculum, event, or subtopic
	//curriculum
	public CalendarCurriculum addCalendarCurriculum(CalendarCurriculum newCalendarCurriculum) {
		return calendarCurriculumRepo.save(newCalendarCurriculum);
	}
	//event
	public CalendarEvent addCalendarEvent(CalendarEvent newCalendarEvent) {
		return calendarEventRepo.save(newCalendarEvent);
	}
	//subtopic
	public CalendarSubtopic addCalendarSubtopic(CalendarSubtopic newCalendarSubtopic) {
		return calendarSubtopicRepo.save(newCalendarSubtopic);
	}
	
	//update a calendar curriculum, event, or subtopic
	//curriculum
	public CalendarCurriculum updateCalendarCurriculum(CalendarCurriculum updatedCalendarCurriculum) {
		CalendarCurriculum calendarCurriculum = calendarCurriculumRepo.findCalendarCurriculumById(updatedCalendarCurriculum.getId());	
		if(calendarCurriculum == null) {
			return calendarCurriculum;
		} else {
			return calendarCurriculumRepo.save(updatedCalendarCurriculum);
		}
	}
	//event
	public CalendarEvent updateCalendarEvent(CalendarEvent updatedCalendarEvent) {
		CalendarEvent calendarEvent = calendarEventRepo.findCalendarEventById(updatedCalendarEvent.getId());	
		if(calendarEvent == null) {
			return calendarEvent;
		} else {
			return calendarEventRepo.save(updatedCalendarEvent);
		}
	}
	//subtopic
	public CalendarSubtopic updateCalendarSubtopic(CalendarSubtopic updatedCalendarSubtopic) {
		CalendarSubtopic calendarSubtopic = calendarSubtopicRepo.findCalendarSubtopicById(updatedCalendarSubtopic.getId());	
		if(calendarSubtopic == null) {
			return calendarSubtopic;
		} else {
			return calendarSubtopicRepo.save(updatedCalendarSubtopic);
		}
	}
}
