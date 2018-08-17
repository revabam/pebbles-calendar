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

@Service
@Transactional
public class CalendarService {

	@Autowired
	CalendarCurriculumRepository calendarCurriculumRepo;
	CalendarEventRepository calendarEventRepo;
	CalendarSubtopicRepository calendarSubtopicRepo;
	
	//find all
	public List<CalendarCurriculum> findAllCalendarCurriculums() {
		return calendarCurriculumRepo.findAll();
	}
	public List<CalendarEvent> findAllCalendarEvents() {
		return calendarEventRepo.findAll();
	}
	public List<CalendarSubtopic> findAllCalendarSubtopics() {
		return calendarSubtopicRepo.findAll();
	}
	
	//find by id
	public CalendarCurriculum findCalendarCurriculumById(Integer id) {
		return calendarCurriculumRepo.findCalendarCurriculumById(id);
	}
	public CalendarEvent findCalendarEventById(Integer id) {
		return calendarEventRepo.findCalendarEventById(id);
	}
	public CalendarSubtopic findCalendarSubtopicById(Integer id) {
		return calendarSubtopicRepo.findCalendarSubtopicById(id);
	}
	
	//add
	public CalendarCurriculum addCalendarCurriculum(CalendarCurriculum newCalendarCurriculum) {
		return calendarCurriculumRepo.save(newCalendarCurriculum);
	}
	public CalendarEvent addCalendarEvent(CalendarEvent newCalendarEvent) {
		return calendarEventRepo.save(newCalendarEvent);
	}
	public CalendarSubtopic addCalendarSubtopic(CalendarSubtopic newCalendarSubtopic) {
		return calendarSubtopicRepo.save(newCalendarSubtopic);
	}
	
	//update
	public CalendarCurriculum updateCalendarCurriculum(CalendarCurriculum updatedCalendarCurriculum) {
		CalendarCurriculum calendarCurriculum = calendarCurriculumRepo.findCalendarCurriculumById(updatedCalendarCurriculum.getId());	
		if(calendarCurriculum == null) {
			return calendarCurriculum;
		} else {
			return calendarCurriculumRepo.save(updatedCalendarCurriculum);
		}
	}
	public CalendarEvent updateCalendarEvent(CalendarEvent updatedCalendarEvent) {
		CalendarEvent calendarEvent = calendarEventRepo.findCalendarEventById(updatedCalendarEvent.getId());	
		if(calendarEvent == null) {
			return calendarEvent;
		} else {
			return calendarEventRepo.save(updatedCalendarEvent);
		}
	}
	public CalendarSubtopic updateCalendarSubtopic(CalendarSubtopic updatedCalendarSubtopic) {
		CalendarSubtopic calendarSubtopic = calendarSubtopicRepo.findCalendarSubtopicById(updatedCalendarSubtopic.getId());	
		if(calendarSubtopic == null) {
			return calendarSubtopic;
		} else {
			return calendarSubtopicRepo.save(updatedCalendarSubtopic);
		}
	}
}
