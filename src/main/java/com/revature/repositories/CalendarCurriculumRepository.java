package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.CalendarCurriculum;

@Repository
public interface CalendarCurriculumRepository extends JpaRepository<CalendarCurriculum, Integer> {

	CalendarCurriculum findCalendarCurriculumById(int id);
	
}
