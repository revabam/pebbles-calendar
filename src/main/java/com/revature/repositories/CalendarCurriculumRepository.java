package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.CalendarCurriculum;

/**
 * This is the repository that implements CRUD functionality directly to the calendar_curriculum table in the database.  
 * The methods in this class are called from the CalendarService class methods. You can create custom methods here, or use the built-in JPA methods available by extending the JPA repository such as findAll() and save().
 * @author author Derek Loisel batch 1806-jun18-usf-java trainer Wezley Singleton
 */
@Repository
public interface CalendarCurriculumRepository extends JpaRepository<CalendarCurriculum, Integer> {

	CalendarCurriculum findCalendarCurriculumById(int id);
	
}
