package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.CalendarSubtopic;

@Repository
public interface CalendarSubtopicRepository extends JpaRepository<CalendarSubtopic, Integer> {

	CalendarSubtopic findCalendarSubtopicById(int id);
	
}